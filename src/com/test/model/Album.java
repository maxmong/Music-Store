package com.test.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Album {
    public int albumId;
    public int genreId;
    
    @Range(min=3,max=5)
    public int artistId;
    
    @NotNull @Size(min=1)
    public String title;
    
    
    public BigDecimal price;
    public String albumArtUrl;
    
    public Genre genre;
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Artist artist;
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAlbumArtUrl() {
		return albumArtUrl;
	}
	public void setAlbumArtUrl(String albumArtUrl) {
		this.albumArtUrl = albumArtUrl;
	}

	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist list) {
		this.artist = list;
	}
    
    
    
}
