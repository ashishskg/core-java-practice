package com.ashish.java.ocp.ch06.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class App02Sort {

	public static void main(String[] args) {
		sort();
		sortWithComparable();
		sortWithComparator();
	}

	static void sort() {
		ArrayList<String> stuff = new ArrayList<>();
		stuff.add("Denver");
		stuff.add("Vail");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted: " + stuff);
		Collections.sort(stuff);
		System.out.println("sorted: " + stuff);
	}

	static void sortWithComparable() {

		ArrayList<DVDInfo> dvdList = new ArrayList<>();
		dvdList.add(new DVDInfo("Donnie Darko", "sci-fi", "Gyllenhall, Jake"));
		dvdList.add(new DVDInfo("Caddyshack", "comedy", "Murray, Bill"));
		System.out.println("unsorted: " + dvdList);
		Collections.sort(dvdList);
		System.out.println("sorted: " + dvdList);

	}

	static void sortWithComparator() {

		ArrayList<DVDInfo2> dvdList2 = new ArrayList<>();
		dvdList2.add(new DVDInfo2("Donnie Darko", "sci-fi", "Gyllenhall, Jake"));
		dvdList2.add(new DVDInfo2("Caddyshack", "comedy", "Murray, Bill"));
		System.out.println("unsorted: " + dvdList2);

		/*
		 * GenreSort gs = new GenreSort(); 
		 * Collections.sort(dvdList2, gs);
		 */

		// Using Lambdas
		/*
		 * Collections.sort(dvdList2, (one, two) ->
		 * one.getGenre().compareTo(two.getGenre())); System.out.println("sorted: " +
		 * dvdList2);
		 */

		// Sort with Arraylist.sort(Comparator)
		dvdList2.sort((one, two) -> one.getGenre().compareTo(two.getGenre()));
		System.out.println("sorted: " + dvdList2);

	}

}

class GenreSort implements Comparator<DVDInfo2> {

	@Override
	public int compare(DVDInfo2 one, DVDInfo2 two) {
		return one.getGenre().compareTo(two.genre);
	}

}

class DVDInfo implements Comparable<DVDInfo> {
	String title;
	String genre;
	String leadActor;

	public DVDInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	@Override
	public String toString() {
		return "DVDInfo [title=" + title + ", genre=" + genre + ", leadActor=" + leadActor + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	@Override
	public int compareTo(DVDInfo d) {
		return title.compareTo(d.getTitle());
	}

}

class DVDInfo2 {
	String title;
	String genre;
	String leadActor;

	public DVDInfo2(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	@Override
	public String toString() {
		return "DVDInfo [title=" + title + ", genre=" + genre + ", leadActor=" + leadActor + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
}