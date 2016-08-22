package com.sds.project;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistForm extends JFrame implements ActionListener {
	JTextField tf_id, tf_name, tf_add, tf_cardnum, tf_cardpwd, tf_qa, tf_img;
	JTextArea ta_add;
	JButton bt_overlap, bt_find, bt_img, bt_enroll, bt_cancel;
	JLabel lb_tel, lb_title, lb_id, lb_pwd, lb_pwd2, lb_name, lb_add, lb_cardnum, lb_cardpwd, lb_qachoice, lb_qa,
			lb_img;
	JPanel p_title, p_id, p_pwd, p_pwd2, p_name, p_add, p_cardnum, p_cardpwd, p_qa, p_qachoice, p_img, p_bt;
	Choice ch_qa;
	CheckboxGroup chg;
	Checkbox ch_male, ch_female;
	JPasswordField tf_pwd, tf_pwd2;
	JFileChooser chooser;

	public RegistForm() {

		GridLayout gr = new GridLayout(11, 2, 5, 20);
		setLayout(gr);

		// p_title = new JPanel();
		lb_title = new JLabel("회원가입");
		add(lb_title, CENTER_ALIGNMENT);
		// add(p_title);

		lb_tel = new JLabel("안내문의 1588-7800");
		add(lb_tel);

		p_id = new JPanel();
		lb_id = new JLabel("아이디(ID)");
		tf_id = new JTextField(10);
		bt_overlap = new JButton("중복");
		p_id.add(tf_id);
		bt_overlap.setPreferredSize(new Dimension(60,30));
		p_id.add(bt_overlap);
		add(lb_id);
		add(p_id);

		// p_pwd = new JPanel();
		lb_pwd = new JLabel("패스워드(pwd)");
		tf_pwd = new JPasswordField(5);
		add(lb_pwd);
		add(tf_pwd);

		// p_pwd2 = new JPanel();
		lb_pwd2 = new JLabel("패스워드 확인");
		tf_pwd2 = new JPasswordField(5);
		add(lb_pwd2);
		add(tf_pwd2);
		// add(p_pwd2);

		// p_qachoice = new JPanel();
		lb_qachoice = new JLabel("pwd 찾기 질문선택");
		ch_qa = new Choice();
		ch_qa.add("선 택 ▼");
		ch_qa.add("아버지 성함은?");
		ch_qa.add("가장 좋아하는 동물은?");
		ch_qa.add("졸업한 초등학교는?");
		add(lb_qachoice);
		add(ch_qa);
		// add(p_qachoice);

		// p_qa = new JPanel();
		lb_qa = new JLabel("질문답");
		tf_qa = new JTextField(10);
		add(lb_qa);
		add(tf_qa);
		// add(p_qa);

		p_add = new JPanel();
		lb_add = new JLabel("주소");
		ta_add = new JTextArea();
		bt_find = new JButton("검색");

		ta_add.setPreferredSize(new Dimension(100, 20));
		
		add(lb_add);
		p_add.add(ta_add);
		p_add.add(bt_find);
		add(p_add);

		p_cardnum = new JPanel();
		lb_cardnum = new JLabel("생년월일");
		tf_cardnum = new JTextField(5);
		chg = new CheckboxGroup();
		ch_male = new Checkbox("남자", true, chg);
		ch_female = new Checkbox("여자", false, chg);
		add(lb_cardnum);
		p_cardnum.add(tf_cardnum);
		p_cardnum.add(ch_male);
		p_cardnum.add(ch_female);
		add(p_cardnum, LEFT_ALIGNMENT);

		// p_name = new JPanel();
		lb_name = new JLabel("성함");
		tf_name = new JTextField(5);
		add(lb_name);
		add(tf_name);
		// add(p_name);

		p_img = new JPanel();
		lb_img = new JLabel("이미지선택");
		tf_img = new JTextField(5);
		bt_img = new JButton("찾기");
		add(lb_img);
		p_img.add(tf_img);
		p_img.add(bt_img);
		add(p_img);

		p_bt = new JPanel();
		bt_enroll = new JButton("등록");
		bt_cancel = new JButton("취소");
		p_bt.add(bt_enroll);
		p_bt.add(bt_cancel);
		add(p_bt);

		bt_overlap.addActionListener(this);
		bt_find.addActionListener(this);
		bt_img.addActionListener(this);

		chooser = new JFileChooser();

		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void OpenFile() {
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();

			tf_img.setText(path);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj.equals(bt_overlap)) {
			JOptionPane.showMessageDialog(this, "사용가능 한 ID 입니다. 계속 진행시 확인을 눌러주세요");
		} else if (obj.equals(bt_find)) {
			AddressFrame sub = new AddressFrame();

		} else if (obj.equals(bt_img)) {
			OpenFile();
		}

	}

	public static void main(String[] args) {
		new RegistForm();
	}

}

class AddressFrame extends JFrame implements ItemListener, ActionListener {
	JButton bt_sub, bt_lay, bt_can;
	Choice ch_city, ch_gu;
	Choice ch_dong;
	String st_dong[];
	JTextField tf_sub;
	JTextArea ta_certify;
	JLabel lb_city, lb_certify, lb_gu, lb_tf;
	RegistForm mp;

	public AddressFrame() {
		// GridLayout gr= new GridLayout(3, 3);
		setLayout(null);
		
		mp=new RegistForm();

		ch_city = new Choice();
		lb_city = new JLabel("시");
		lb_gu = new JLabel("구");
		ch_dong = new Choice();
		lb_tf = new JLabel("상세주소");
		tf_sub = new JTextField();
		bt_sub = new JButton("등록");
		lb_certify = new JLabel("주소확인");
		ta_certify = new JTextArea();
		bt_lay = new JButton("입력");
		bt_can = new JButton("취소");

		ch_city.add("선택▼");
		ch_city.add("서울시");
		ch_city.add("대전광역시");
		ch_city.add("광주광역시");
		ch_city.add("부산시");
		ch_city.add("대구광역시");
		ch_city.add("제주시");

		lb_city.setBounds(20, 10, 30, 30);
		ch_city.setBounds(50, 10, 150, 20);
		lb_gu.setBounds(220, 10, 30, 30);
		ch_dong.setBounds(250, 10, 150, 20);
		lb_tf.setBounds(10, 50, 70, 30);
		tf_sub.setBounds(80, 50, 250, 25);
		bt_sub.setBounds(340, 50, 70, 20);
		lb_certify.setBounds(10, 100, 70, 20);
		ta_certify.setBounds(80, 90, 300, 50);
		bt_lay.setBounds(180, 180, 70, 20);

		add(lb_gu);
		add(lb_city);
		add(ch_city);
		add(lb_tf);
		add(tf_sub);
		add(bt_sub);
		add(lb_certify);
		add(ta_certify);
		add(bt_lay);
		// add(bt_can);

		ch_dong.add("선택▼");
		add(ch_dong);

		ch_city.addItemListener(this);
		bt_sub.addActionListener(this);
		bt_lay.addActionListener(this);

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});

		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setSize(440, 280);
		setVisible(true);

	}

	public void DaeDong() {
		ch_dong.removeAll();
		ch_dong.add("서구");
		ch_dong.add("동구");
		ch_dong.add("중구");
		// add(ch_dong);

	}

	public void SeoulDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("동작구");
		ch_dong.add("노원구");
		ch_dong.add("강남구");
		// add(ch_dong);

	}

	public void DaeguDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("수성구");
		ch_dong.add("달서구");
		ch_dong.add("북구");
		// add(ch_dong);

	}

	public void GwangDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("북구");
		ch_dong.add("동구");
		ch_dong.add("광산구");
		// add(ch_dong);
	}

	public void BuDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("서구");
		ch_dong.add("동구");
		ch_dong.add("중구");
		// add(ch_dong);
	}

	public void JeDong() {
		// ch_dong = new Choice();
		ch_dong.removeAll();
		ch_dong.add("서귀포시");
		ch_dong.add("우도군");
		ch_dong.add("한라시");
		// add(ch_dong);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice ch = (Choice) e.getSource();
		String str = ch.getSelectedItem();

		if (str.equals("서울시")) {
			System.out.println("서울택했어?");
			SeoulDong();

		} else if (str.equals("대전광역시")) {
			System.out.println("대전택했어?");
			DaeDong();
		} else if (str.equals("광주광역시")) {
			System.out.println("광주택했어?");
			GwangDong();
		} else if (str.equals("부산시")) {
			System.out.println("부산택했어?");
			BuDong();
		} else if (str.equals("대구광역시")) {
			System.out.println("대구택했어?");
			DaeguDong();
		} else if (str.equals("제주시")) {
			System.out.println("제주택했어?");
			JeDong();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = ch_city.getSelectedItem();
		String str1 = ch_dong.getSelectedItem();
		Object obj = e.getSource();

		if (obj.equals(bt_sub)) {
			String msg = tf_sub.getText();
			System.out.println(str);
			ta_certify.append(str+"  "+str1+"  "+ msg );
			
			
		} else if (obj.equals(bt_lay)) {
			System.out.println("입력눌렀어?");
			String msg = ta_certify.getText();
			mp.ta_add.append(msg);
			this.dispose();
		}

	}

}
