package ru.greg3d.applogic.interfaces;

import java.util.List;

import ru.greg3d.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	List<Film> search(String title);
	Film getFilmFromGrigByIndex(int index);
	void clearFilter();
	int getRecordCount();
	boolean filmWasNotAdded();
	boolean filmWasAdded();
	String searchNotValidTitleInFilmList(List<Film> films, String title);
	boolean gridIsEmpty();
	boolean filmListContains(Film searchFilm);
}
