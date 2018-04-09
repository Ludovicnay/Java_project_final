package domaine;

import java.util.ArrayList;

import beans.Acteur;
import beans.Film;

public class Acteurs extends ArrayList<Acteur>{
	public Acteur getActeurByCode(int codeA) {
		for(Acteur a:this)
			if(a.getCodeActeur()==codeA)
				return a;
		return null;
	}
	public Films filmsCommunsActeur(int id_film1, int id_film2)
	{
		return null;
	}
	public static Acteurs et (Acteurs liste_acteur1, Acteurs liste_acteur2)
	{
		Acteurs intersection = null;
		for(Acteur A : liste_acteur1)
		{
			for (Acteur B : liste_acteur2)
			{
				if (A==B)
				{
					if(!intersection.contains(A))
					intersection.add(A);
				}
			}
			
		}
		return intersection;
	}
}
