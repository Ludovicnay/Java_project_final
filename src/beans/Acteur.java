package beans;

import domaine.Films;
import domaine.Roles;

public class Acteur {
	private int m_codeActeur;
	private String m_prenomActeur, m_nomActeur;
	private Genre m_sexeActeur;
	private int m_anneeNaissanceActeur;
	private Roles m_roles = new Roles();
	
	public Acteur(int codeActeur, String prenomActeur, String nomActeur,
			Genre sexeActeur, int anneeNaissanceActeur) {
		m_codeActeur = codeActeur;
		m_prenomActeur = prenomActeur;
		m_nomActeur = nomActeur;
		m_sexeActeur = sexeActeur;
		m_anneeNaissanceActeur = anneeNaissanceActeur;
	}
	public Acteur(int codeActeur, String prenomActeur, String nomActeur,
			Genre sexeActeur, int anneeNaissanceActeur, Roles role) {
		m_codeActeur = codeActeur;
		m_prenomActeur = prenomActeur;
		m_nomActeur = nomActeur;
		m_sexeActeur = sexeActeur;
		m_anneeNaissanceActeur = anneeNaissanceActeur;
		m_roles = role;
	}
	
	public Roles getRole() {
		return m_roles;
	}
	public void setRole(Roles role) {
		m_roles = role;
	}
	
	public void addRole(Role role){
		this.m_roles.add(role);
	}
	public Films getFilms() {
		String AfficheFilms = "Films : ";
		Films films = new Films();
		for(Role r: m_roles)
		{
			films.add(r.getFilm());
			AfficheFilms+= "\n"+ r.getFilm();
		}
		return films;
	}
	
	
	public int getCodeActeur() {
		return m_codeActeur;
	}
	public String getPrenomActeur() {
		return m_prenomActeur;
	}
	public String getNomActeur() {
		return m_nomActeur;
	}
	public Genre getSexeActeur() {
		return m_sexeActeur;
	}
	public int getAnneeNaissanceActeur() {
		return m_anneeNaissanceActeur;
	}

	public String toString() {
		String titre=m_sexeActeur==Genre.Feminin?"Mme":"M.";
		return "[Acteur "+m_codeActeur+"] : "+titre+" "+m_prenomActeur+" "+m_nomActeur+" ("+m_anneeNaissanceActeur+")";
	}
}
