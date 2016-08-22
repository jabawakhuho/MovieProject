package com.sds.project;

import javax.swing.JFrame;

public class MovieApp extends JFrame{

	MovieInfo movieInfo;
	
	public MovieApp() {
		// TODO Auto-generated constructor stub
		super("영화예매프로그램");
		movieInfo= new MovieInfo("제목");
	
		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MovieApp();
	}

}
