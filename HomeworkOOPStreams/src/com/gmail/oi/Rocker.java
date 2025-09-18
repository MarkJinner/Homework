package com.gmail.oi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rocker implements Comparable<Rocker>{
	private String name;
	private List<String> songs;
	
	public Rocker(String name, String...songs) {
		this.name = name;
		this.songs = new ArrayList<>();
		for(int i  = 0; i< songs.length;i++) {
			this.songs.add(songs[i]);
		}
	}
	
	public Rocker() {
		
	}
	
	public static void getYou() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSongs() {
		return songs;
	}

	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, songs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rocker other = (Rocker) obj;
		return Objects.equals(name, other.name) && Objects.equals(songs, other.songs);
	}

	@Override
	public String toString() {
		return "Rocker "+this.getName()+"with songs "+this.songs;
	}

	@Override
	public int compareTo(Rocker other) {
		if(other==null) {
			throw new NullPointerException();
		}else if(this.name.compareTo(other.name)>0) {
			return 1;
		}else if(this.name.compareTo(other.name)<0) {
			return -1;
		}
		
		return this.songs.size()-other.songs.size();
	}
}
