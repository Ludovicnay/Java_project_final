package beans;



public class Role {
	
	private Acteur m_acteur;
	private Film m_film;
	private String m_casting;
	
	public Role(Acteur acteur, Film film, String casting )
	{
		m_acteur = acteur;
		m_film = film;
		m_casting = casting;
	}

	public Acteur getActeur()
	{
		return m_acteur;
	}

	public Film getFilm()
	{
		return m_film;
	}

	public String getCasting() 
	{
		return m_casting;
	}
	
}
