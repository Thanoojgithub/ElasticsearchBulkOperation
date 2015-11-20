package com.elasticsearchbulkoperation.app;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.elasticsearchbulkoperation.type.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MoviesJSON {

	public static String getMoviesJSON() {
		List<Movie> list = new ArrayList<Movie>();
		String genres[] = { "action", "drama" };
		for (int i = 1; i <= 20; i++) {
			list.add(new Movie("movie" + i, "director" + i, genres, 1995 + i));
		}
		Gson gson = new Gson();
		Type type = new TypeToken<List<Movie>>() {}.getType();
		return gson.toJson(list, type);
	}

	public static List<Movie> getMoviesListFromJSON(String moviesJSON) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Movie>>() {
		}.getType();
		List<Movie> fromJson = gson.fromJson(moviesJSON, type);
		return fromJson;
	}

	public static void main(String[] args) {
		String moviesJSON = getMoviesJSON();
		System.out.println("Movie JSON :: " + moviesJSON);
		List<Movie> moviesListFromJSON = getMoviesListFromJSON(moviesJSON);
		for (Movie movie : moviesListFromJSON) {
			System.out.println("movie : " + movie);
		}

	}

}
