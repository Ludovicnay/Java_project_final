package domaine;

import java.util.ArrayList;

import beans.Film;

public class Films extends ArrayList<Film>{
	public Film getFilmByCode(int codef) {
		for(Film f:this)
			if(f.getCodeFilm()==codef)
				return f;
		return null;
	}
	
	public Acteurs acteursCommunsFilms(int id_acteur, int id_acteur2)
	{
		return null;
	}
	public Films et (Films liste_film1, Film liste_film2)
	{
		return null ;
	}
	
}

