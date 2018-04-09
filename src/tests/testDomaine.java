package tests;


import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Acteur;
import beans.Film;
import connecteurs.MySqlB3;
import domaine.Acteurs;
import domaine.DomaineBdd;
import domaine.Films;


public class testDomaine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DomaineBdd dom=new DomaineBdd();
		Acteurs acteurs = dom.getAllActeurs();
		Films films = dom.getAllFilms();
		
		
		System.out.println("\n \n ");
		
		System.out.println("AFFICHAGE DE TOUS LES ACTEURS \n ");
		
		for(Acteur a:acteurs){
			Films filmsActeur= a.getFilms();
			System.out.println(a + "\n");
			System.out.println(filmsActeur + "\n");	
		}
		
		System.out.println("\n \n");
		System.out.println("AFFICHAGE DE TOUS LES FILMS \n ");

		for(Film f:films){
			Acteurs acteursFilm= f.getActeurs();
			System.out.println(f + "\n");
			System.out.println(acteursFilm + "\n");	
		}
		
		System.out.println("\n \n");
		System.out.println("INSERTION D'UN FILM \n ");
		
		String sql="SELECT count(*) as nb FROM films "; 
		int res=0;
		MySqlB3 m_myB3 = new MySqlB3("films");
		ResultSet rs=m_myB3.requete(sql);
		try {
			rs.next();
			res=rs.getInt("nb"); } catch (SQLException e) {}
		System.out.println("Nombre de films avant : " + res);
		
		dom.addFilm("Mon FILM", 2018);
		
		int resEnd=0;
	
		rs=m_myB3.requete(sql);
		try {
			rs.next();
			resEnd=rs.getInt("nb"); } catch (SQLException e) {}
		System.out.println("Nombre de films après : " + resEnd);
		
// SUPPRESSION D'UN FILM 
		
		System.out.println("\n \n");
		System.out.println("SUPPRESSION D'UN FILM \n ");
		
		sql="SELECT count(*) as nb FROM films "; 
		res=0;
		m_myB3 = new MySqlB3("films");
		rs=m_myB3.requete(sql);
		try {
			rs.next();
			res=rs.getInt("nb"); } catch (SQLException e) {}
		System.out.println("Nombre de films avant : " + res);
		
		dom.deleteFilm(11);
		
		resEnd=0;
	
		rs=m_myB3.requete(sql);
		try {
			rs.next();
			resEnd=rs.getInt("nb"); } catch (SQLException e) {}
		System.out.println("Nombre de films après : " + resEnd);
		
		
		
		
	}

}