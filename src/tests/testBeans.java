package tests;

import beans.Acteur;
import beans.Film;
import beans.Genre;
import beans.Role;
import domaine.Acteurs;
import domaine.DomaineBdd;
import domaine.Films;
import domaine.IDomaine;

public class testBeans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acteur a=new Acteur(1, "Jodie", "FOSTER", Genre.Feminin, 1962); Film f=new Film(1, "Contact", 1997);
		Role r=new Role(a, f, "Eleanore ARROWAY");
		a.addRole(r);
		f.addRole(r);
		System.out.println(f); for(Acteur a1:f.getActeurs())
		System.out.println("- "+a1);
		System.out.println(a); for(Film f1:a.getFilms())
		System.out.println("- "+f1);
	}

}
