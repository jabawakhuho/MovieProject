package com.sds.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainTop extends JPanel implements ActionListener{
	JPanel p_center;
	JLabel lb_name;
	JLabel lb_id;
	JLabel lb_pwd;
	JButton bt_item;
	JButton bt_login;
	JButton bt_regist;
	JTextField tf_id;
	JTextField tf_pwd;
	
	// menubar관련
	MyMenuBar bar;
	String[] menuList = { "무비차트", "아트하우스", "개봉예정" };
	ArrayList<String[]> menuItemList = new ArrayList<String[]>();
	String[] move = { "test", "test2", "test3" };
	String[] art = { "test", "test2", "test3" };
	String[] open = { "test", "test2", "test3" };

	public MainTop(int width, int height) {
		setLayout(new BorderLayout());

		p_center = new JPanel();

		p_center.setLayout(null);
		p_center.setPreferredSize(new Dimension(width, height));
		//p_center.setBackground(Color.CYAN);

		drawIcon();

		add(p_center);
		// menuBar붙이기
		createMenubar();
	}

	// 메뉴 ICON만 나오게 하는 메서드
	public void drawIcon() {
		p_center.removeAll();
		lb_name = new JLabel("LTKO");
		bt_item = new JButton("+");

		lb_name.setFont(new Font("Georgia", Font.BOLD, 20));
		bt_item.setFont(new Font("", Font.BOLD, 10));
		// 자리배치
		lb_name.setBounds(10, 10, 80, 30);
		bt_item.setBounds(330, 10, 40, 30);
		// bt_item에 이벤트 처리하기
		bt_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "+") {
					drawLogin();
				} else if (e.getActionCommand() == "-") {
					drawIcon();
				}
			}
		});
		
		// 붙이기
		p_center.add(lb_name);
		p_center.add(bt_item);
		updateUI();
	}

	// 회원 가입 화면 나오게하는 메서드
	public void drawLogin() {
		bt_item.setText("-");
		bt_item.setBounds(100, 10, 40, 30);
		
		lb_id = new JLabel("ID");
		lb_pwd = new JLabel("password");
		tf_id = new JTextField(10);
		tf_pwd = new JTextField(10);
		bt_login = new JButton("로그인");
		bt_regist = new JButton("회원가입");
		bt_login.setFont(new Font("", Font.BOLD, 10));
		bt_regist.setFont(new Font("", Font.BOLD, 10));
		
		lb_id.setBounds(145, 10, 60, 30);
		lb_pwd.setBounds(145, 40, 60, 30);
		tf_id.setBounds(210, 10, 80, 30);
		tf_pwd.setBounds(210, 40, 80, 30);
		bt_login.setBounds(300, 10, 80, 30);
		bt_regist.setBounds(300, 40, 80, 30);

		bt_login.addActionListener(this);
		bt_regist.addActionListener(this);
		
		p_center.add(lb_id);
		p_center.add(lb_pwd);
		p_center.add(tf_id);
		p_center.add(tf_pwd);
		p_center.add(bt_login);
		p_center.add(bt_regist);

		updateUI();
	}

	public void createMenubar() {
		// menuBar관련
		menuItemList.add(move);
		menuItemList.add(art);
		menuItemList.add(open);
		bar = new MyMenuBar(menuList, menuItemList);
		bar.setPreferredSize(new Dimension(WIDTH, 30));
		add(bar, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(bt_login)){
				JOptionPane.showMessageDialog(this, "로그인동작");
		}else if(obj.equals(bt_regist)){
			JOptionPane.showMessageDialog(this, "회원가입동작");
		}
		
	}
}
