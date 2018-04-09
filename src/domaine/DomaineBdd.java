package domaine;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Acteur;
import beans.Film;
import beans.Genre;
import beans.Role;
import connecteurs.MySqlB3;

public class DomaineBdd implements IDomaine {

	private boolean m_toRefresh = true;
	private Acteurs m_acteurs;
	private Films m_films;
	private MySqlB3 m_myB3 = null;
	
	public void readBDD() {
		// TODO Auto-generated method stub

		if(m_toRefresh == true) {
			m_acteurs= new Acteurs();
			m_films = new Films();
			if(m_myB3 == null)
			m_myB3=new MySqlB3("films");
			try 
			{
				// Pour les films 
				ResultSet rs=m_myB3.requete("films");
				while(rs.next()) {
					int id_film =rs.getInt("codeFilm");
					String titre_film =rs.getString("titreFilm");
					int annee_film = rs.getInt("anneeFilm");
					Film film=new Film(id_film,titre_film,annee_film);
					m_films.add(film);
				}
				// Pour les acteurs 
				 rs=m_myB3.requete("acteurs");
				while(rs.next()) 
				{
					int id_acteur =rs.getInt("codeActeur");
					String prenom_acteur =rs.getString("prenomActeur");
					String nom_acteur = rs.getString("nomActeur");
					Genre sexe_acteur = rs.getInt("sexeActeur") == 1  ? Genre.Feminin : Genre.Masculin;
					int naissance_acteur = rs.getInt("anneeNaissanceActeur");
					
					Acteur acteur=new Acteur(id_acteur,prenom_acteur ,nom_acteur,sexe_acteur,naissance_acteur);
					m_acteurs.add(acteur);
				}
				rs= m_myB3.requete("joue");
				while(rs.next()) 
				{
					int id_acteur =rs.getInt("codeA");
					int id_film =rs.getInt("codeF");
					String casting =rs.getString("casting");
					
					Film filmConcernee = m_films.getFilmByCode(id_film);
					Acteur acteurConcernee = m_acteurs.getActeurByCode(id_acteur);
					
					Role role=new Role(acteurConcernee,filmConcernee,casting);
					acteurConcernee.addRole(role);
					filmConcernee.addRole(role);
					System.out.println("Ok : Le role "+ role.getCasting() + "a été récupéré avec l'acteur : " +acteurConcernee +" dans le film" + filmConcernee);
				}
			}catch (Exception e) 
			{
				System.err.println("DomaineBDD.readBDD : "+e.getMessage());
			}
		}
	}

	public Acteurs getAllActeurs() {
		// TODO Auto-generated method stub
		if(m_toRefresh == true) {
			readBDD();
			m_toRefresh = false;
		}
		return this.m_acteurs;
		
		
	}

	public Films getAllFilms() {
		// TODO Auto-generated method stub
		if(m_toRefresh) {
			readBDD();
			m_toRefresh = false;
		}
		return this.m_films;
		
	}

	public int addActeur(String nom, String prenom, Genre genre, int id_acteur) {
		// TODO Auto-generated method stub
		int g = 0;
		if(genre == Genre.Masculin){
			g = 0;
		}
		else if(genre == Genre.Feminin){
			g = 1;
		}	
		int l=this.m_myB3.insereAI("INSERT INTO acteurs (codeActeur,prenomActeur,nomActeur,sexeActeur) "
				+ "VALUES(null,'" + prenom + "','" + nom + "', "+g);
		if (l != -1) {
			m_toRefresh = true;
		}	
		return l;
	}

	public int addFilm(String nom, int date_film) {
		
		int l=this.m_myB3.insereAI("INSERT INTO films VALUES(null,'" + nom + "', "+ date_film+")");
		if (l != -1) {
			m_toRefresh = true;
		}	
		return l;
	}
	

	public boolean addRole(int id_acteur, int id_film, String casting) {
		// TODO Auto-generated method stub
		int l=this.m_myB3.update("INSERT INTO joue (codeF,codeA,casting) "
				+ "VALUES(null,'" + id_film + "','" + id_acteur +"','" +casting+"'");
		if (l == 1) {
			System.out.println("1 ligne affecté !");
			return true;
		}	
		else {
		return false;
		}
	}

	public boolean deleteRole(int id_acteur, int id_film) {     
		int req=this.m_myB3.update("DELETE FROM joue WHERE codeA = " + id_acteur + " AND codeF = " + id_film );
		if(req ==1){
			this.m_toRefresh=true;
			return true;
		}
		else{
			return false;
		}
	}

	public int nbRoles(String sqlFin) {
			String sql="SELECT count(*) as nb FROM joue WHERE "+sqlFin; System.out.println(sql);
			int res=0;
			ResultSet rs=m_myB3.requete(sql);
			try {
			rs.next();
			res=rs.getInt("nb"); 
			} catch (SQLException e) {}
			return res;
			}
	
	public boolean deleteActeur(int id_acteur) {
		// TODO Auto-generated method stub
		int count = nbRoles("CodeA="+id_acteur);
		if(count ==0){
			int res=this.m_myB3.update("DELETE FROM acteurs WHERE codeActeur = "+id_acteur+")");
			if(res ==1){
				this.m_toRefresh=true;
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	public boolean deleteFilm(int id_film) {
		// TODO Auto-generated method stub
		int count = nbRoles("CodeF="+id_film);
		if(count ==0){
			int res=this.m_myB3.update("DELETE FROM films WHERE codeFilm = "+id_film+"");
			if(res ==1){
				this.m_toRefresh=true;
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	

	
	
	
	
	
	
	

}
