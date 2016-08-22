package com.sds.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener, Runnable {
	JPanel p_center; // 영화 Image 및 네비게이터가 그려질 JPanel
	JPanel p_south; // 영화Info 가 그려질 JPanel
	JPanel p_prev; // bt_prev 예비용 panel
	JPanel p_next; // bt_next 예비용 panel
	JPanel p_movie; // 영화 Image가 그려질 Jpanel
	JButton bt_prev; // 영화Info 이전 이동 버튼
	JButton bt_next; // 영화Info 이후 이동 버튼
	JButton bt_reserve;
	JPanel p_navi; // 영화 네비게이터 Icon이 그려질 JPanel
	int count = 0; // 영화 Dis Index
	String[] movieCount = { "국가대표2.jpg", "덕혜옹주.jpg", "라이트아웃.jpg", "밀정.jpg", "부산행.jpg", "스타트렉.jpg", "제임스본.jpg",
			"터널.jpg" };

	JLabel[] naviList = new JLabel[movieCount.length]; // 영화 네비게이터 Icon(JLabel)
	// 영화 Image의 마우스 이벤트 구현
	MouseAdapter mouseAdapter=new MouseAdapter(){public void mouseClicked(MouseEvent e){Object obj=e.getSource();if(obj.equals(p_movie)){System.out.println("MovieInfo");return;}while(true){for(int i=0;i<naviList.length;i++){if(obj.equals(naviList[i])){count=i;p_center.remove(p_navi);createNavi(20);updateUI();return;}}}}};
	// 이벤트 동작 시 사용(updateUI)될 쓰레드
	Thread thread;
	int time = 1000;// Thread.sleep의 시간을 정하는 요소

	public MainPanel(int width, int height) {
		setLayout(new BorderLayout());
		p_center = new JPanel();
		p_prev = new JPanel();
		p_next = new JPanel();
		bt_prev = new JButton("<");
		bt_next = new JButton(">");
		// 쓰레드 생성및시작
		thread = new Thread(this);
		thread.start();

		// p_movie.setBackground(Color.WHITE);
		p_center.setLayout(new BorderLayout());
		p_prev.setPreferredSize(new Dimension(60, 400));
		p_next.setPreferredSize(new Dimension(60, 400));

		p_center.setPreferredSize(new Dimension(width, 400));

		// p_prev.add(bt_prev);
		// p_next.add(bt_next);
		bt_prev.addActionListener(this); // Action이벤트 연결
		bt_next.addActionListener(this); // Action이벤트 연결

		p_center.add(bt_prev, BorderLayout.WEST);
		p_center.add(bt_next, BorderLayout.EAST);
		// movie img가 그려질 Panel 생성
		createMoviePanel();
		// movie nevigator 생성
		createNavi(20);

		add(p_center);
		// movie info panel 생성
		createMovieInfo(width);

		setPreferredSize(new Dimension(width, height));
	}

	// img 생성을 위한 메서드
	public Image getImage(String name) {
		Image img = null;// 지역변수는 컴파일러가 초기화 해주지 않으므로 , 반드시 개발자가 사용전에 초기화 하자!!!
		Class myClass = this.getClass();
		// Classloader는 JVM의 static에서 원본 class 소스를 읽는 자이다.
		URL url = myClass.getClassLoader().getResource(name);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
		}
		return img;
	}

	// moviePanel 생성 매서드
	// moviePanel을 만드는 메서드
	public void createMoviePanel() {
		p_movie = new JPanel() {
			Image img = getImage(movieCount[count]);

			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		};
		p_movie.setPreferredSize(new Dimension(280, 400));
		// image선택(Click)시 이벤트리스너 연결
		p_movie.addMouseListener(mouseAdapter);
		p_center.add(p_movie);
	}

	// movie nevigator 생성 매서드
	// moviePanel아래 네비게이터icon 만드는 메서드
	public void createNavi(int height) {
		p_navi = new JPanel();
		for (int i = 0; i < movieCount.length; i++) {
			JLabel lb = new JLabel("●");
			if (i == count) {
				lb.setText("○");
			}
			// System.out.println(280/movieCount);
			lb.setPreferredSize(new Dimension(200 / movieCount.length, height));
			naviList[i] = lb;
			naviList[i].addMouseListener(mouseAdapter);
			p_navi.add(naviList[i]);
		}
		p_center.add(p_navi, BorderLayout.SOUTH);
		updateUI();
	}

	// movieInfoPanel 생성 메서드
	// movie 정보를 나타낼 Panel생성 메서드
	public void createMovieInfo(int width) {
		p_south = new JPanel();
		bt_reserve = new JButton("예매");
		bt_reserve.addActionListener(this); // Action이벤트 연결
		p_south.setBackground(Color.DARK_GRAY);
		p_south.setPreferredSize(new Dimension(width, 50));
		p_south.add(bt_reserve);

		add(p_south, BorderLayout.SOUTH);
	}

	// count 증가 메서드
	public void countUp(){
				//JOptionPane.showMessageDialog(this, count);
				if(count < movieCount.length-1){
					count++;
				}else{
					count =0;
				}
				time=100;
				//System.out.println("버튼"+count);
	}
	//count 감소 메서드
	public void countDown(){
			// JOptionPane.showMessageDialog(this, "p_movie 이전");
			if (count > 0) {
				count--;
			} else {
				count = movieCount.length - 1;
			}
			time = 100;
			//System.out.println("버튼" + count);
	}
	//예매버튼 관련 동작 메서드
	public void reserve(){
			JOptionPane.showMessageDialog(this, "예매과정동작");
	}

	// Action 이벤트 동작구현 메서드(bt_prev,bt_next,bt_reserve)
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(bt_prev)) {
			countDown();
		}else if(obj.equals(bt_next)){
			countUp();
		}else if(obj.equals(bt_reserve)){
			reserve();
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(time);
				// System.out.println("동작중");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p_center.remove(p_navi);
			p_center.remove(p_movie);
			createMoviePanel();
			createNavi(20);
			updateUI();
			time = 1000;
		}
	}
}
