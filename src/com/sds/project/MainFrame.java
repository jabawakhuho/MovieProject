package com.sds.project;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public static final int WIDTH=400;
	public static final int HEIGHT=600;

	//TopPlanel ฐüทร
	MainTop mainTop;
	MainPanel mainPanel;
	
	public MainFrame() {
		mainTop = new MainTop(WIDTH, 70);
		mainPanel = new MainPanel(WIDTH,HEIGHT-mainTop.getWidth());
		
		add(mainTop,BorderLayout.NORTH);
		add(mainPanel);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new MainFrame();
	}
}
