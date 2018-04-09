package domaine;


import beans.Genre;

public interface IDomaine {
	
	
	public Acteurs getAllActeurs();
	public Films getAllFilms();
	public int addActeur(String nom ,String prenom ,Genre genre,int id_acteur);
	public int addFilm(String nom, int date_film);
	public boolean addRole(int id_acteur, int id_film, String casting);
	public boolean deleteRole(int id_acteur, int id_film);
	public boolean deleteActeur(int id_acteur);
	public boolean deleteFilm(int id_film);
}


