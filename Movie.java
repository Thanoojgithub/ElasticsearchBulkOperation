package com.elasticsearchbulkoperation.type;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String director;
	private String[] genres;
	private long year;
	
	public Movie(String title, String director, String[] genres, long year) {
		super();
		this.title = title;
		this.director = director;
		this.genres = genres;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", genres=" + Arrays.toString(genres) + ", year="
				+ year + "]";
	}
	
}
