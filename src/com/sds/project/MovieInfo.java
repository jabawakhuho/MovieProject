package com.sds.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MovieInfo extends JPanel{
	//전체 패널
	JPanel p_wrapper; 
	JScrollPane w_scroll;
	
	//이미지
	JPanel p_img; 
	// 이미지 Inner 패널
	JPanel p_innerImg,p_innerVideo; 
	
	//정보
	JPanel p_info;
	// 정보 Inner 패널
	JPanel p_innerTitle, p_innerCon; 
	
	//정보관련 Container
	JLabel lb_title, lb_content; //제목,내용
	JTextArea content;
	JScrollPane  c_scroll;
	
	//댓글
	JPanel p_com;
	
	public MovieInfo(String title) {
		// TODO Auto-generated constructor stub
		// 전체Panel 생성
		p_wrapper = new JPanel();
		p_wrapper.setPreferredSize(new Dimension(380, 560)); //width, height는 맞춰서 해야할듯.
		w_scroll = new JScrollPane(p_wrapper);

		//이미지관련 생성
		p_img = new JPanel();
		p_img.setPreferredSize(new Dimension(380, 130));
		p_innerImg = new JPanel();
		p_innerImg.setBackground(Color.CYAN); //색대신 이미지 들어갈 자리.
		p_innerVideo = new JPanel();
		p_innerVideo.setBackground(Color.magenta); //색대신 영상이 가능하면 영상자리. 

		//영화정보관련 생성
		p_info = new JPanel();
		p_info.setBackground(Color.RED);
		p_innerTitle = new JPanel();
		p_innerTitle.setPreferredSize(new Dimension(0, 50));
		//p_innerTitle.setBackground(Color.DARK_GRAY);
		p_innerCon = new JPanel();

		//댓글관련 생성
		p_com = new JPanel();
		p_com.setPreferredSize(new Dimension(380, 130));
		p_com.setBackground(Color.GREEN);
		
		//container 생성
		lb_title = new JLabel(title);
		lb_title.setFont(new Font("고딕", 50, 30));
		lb_content = new JLabel("줄거리");
		content = new JTextArea(13,33);
		content.setEditable(false); //고침 x
		c_scroll = new JScrollPane(content);
		
		
		//전체 위치
		p_wrapper.setLayout(new BorderLayout());
		//p_wrapper.setLayout(new GridLayout(3, 1));
		//p_innerImg.setPreferredSize(new Dimension(200, 177));
		
		//이미지 위치 & 관련 container 추가
		p_img.setLayout(new GridLayout(0,2));
		p_img.add(p_innerImg);
		p_img.add(p_innerVideo);
		
		//정보 위치 & 관련 container 추가
		p_info.setLayout(new BorderLayout());
		p_info.add(p_innerTitle, BorderLayout.NORTH);
		p_innerTitle.add(lb_title);			//제목
		p_info.add(p_innerCon ,BorderLayout.CENTER);
		
		p_innerCon.add(lb_content, BorderLayout.NORTH);		//내용
		p_innerCon.add(c_scroll, BorderLayout.CENTER);
		
		//댓글
		

		
		//추가
		p_wrapper.add(p_img, BorderLayout.NORTH);
		p_wrapper.add(p_info, BorderLayout.CENTER);
		p_wrapper.add(p_com, BorderLayout.SOUTH);
		
	
		add(w_scroll);
		
	
	}
	
}



