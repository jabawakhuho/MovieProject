/*
 * menuItem에 관련된 이벤트는 actionPerformed에서 구현하기
 * */

package com.sds.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar implements ActionListener {
	JMenu[] menu;
	ArrayList<JMenuItem[]> menuItem;
	String[] menuList;
	ArrayList<String[]> menuItemList;

	public MyMenuBar(String[] menuList, ArrayList<String[]> menuItemList) {
		this.menuList = menuList;
		this.menuItemList = menuItemList;
		menu = new JMenu[menuList.length];
		menuItem = new ArrayList<JMenuItem[]>();
		for (int i = 0; i < menuList.length; i++) {
			// menu를 menuList의 text를 넣어 생성한다.
			menu[i] = new JMenu(menuList[i]);
			// menu[i]번째에 menuItem[i]번째 JmenuItem을 붙인다.
			{
				// JMenuItem[]에 menuItemList의[i]번째 String[]을 추가한다.
				JMenuItem[] item = new JMenuItem[menuItemList.get(i).length];
				for (int j = 0; j < menuItemList.get(i).length; j++) {
					// System.out.println(menuItemList.get(i)[j]);
					item[j] = new JMenuItem(menuItemList.get(i)[j]);
					item[j].addActionListener(this);
				}
				menuItem.add(item);
				for (int j = 0; j < menuItem.get(i).length; j++) {
					menu[i].add(menuItem.get(i)[j]);
				}
			}
			// menuBar에 menu붙인다.
			this.add(menu[i]);
		}

	}

	// 메뉴에 따른 이벤트 구현
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(menuItem.get(0)[0])) {
			System.out.println("야호");
		}

	}
}
