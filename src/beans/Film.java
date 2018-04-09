package beans;

import domaine.Acteurs;
import domaine.Roles;

public class Film {
	private int m_codeFilm;
	private String m_titreFilm;
	private int m_anneeFilm;
	private Roles m_roles = new Roles();
	
	
	public Film(int codeFilm, String titreFilm, int anneeFilm) {
		m_codeFilm = codeFilm;
		m_titreFilm = titreFilm;
		m_anneeFilm = anneeFilm;
	}
	public Film(int codeFilm, String titreFilm, int anneeFilm, Roles role) {
		m_codeFilm = codeFilm;
		m_titreFilm = titreFilm;
		m_anneeFilm = anneeFilm;
		m_roles = role;
	}
	
	public Roles getRole() {
		return m_roles;
	}
	
	public void addRole(Role role){
		this.m_roles.add(role);
	}
	
	public Acteurs getActeurs() {
		String AfficheActeurs = "Films : ";
		Acteurs acteurs = new Acteurs();
		for(Role r: m_roles)
		{
			acteurs.add(r.getActeur());
			AfficheActeurs+= "\n"+ r.getActeur();
		}
		return acteurs;
	}
	
	
	
	public int getCodeFilm() {
		return m_codeFilm;
	}
	public String getTitreFilm() {
		return m_titreFilm;
	}
	public int getAnneeFilm() {
		return m_anneeFilm;
	}


	public String toString() {
		return "[Film "+m_codeFilm+"] : "+m_titreFilm+" ("+m_anneeFilm+")";
	}
}
