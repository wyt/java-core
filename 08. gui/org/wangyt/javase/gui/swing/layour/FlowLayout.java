package org.wangyt.javase.gui.swing.layour;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * FlowLayout 從左向右順序排列
 * 
 * @author 王永涛
 * 
 * @since 2012-9-2 下午02:08:54
 * 
 */
public class FlowLayout {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("FlowLayout");
		jf.setLayout(new java.awt.FlowLayout());
		for (int i = 0; i < 10; i++) {
			jf.add(new JButton(i + ""));
		}

		showWindow(jf);
	}

	/**
	 * 显示窗体的方法
	 * 
	 * @param jf
	 */
	public static void showWindow(JFrame jf) {
		jf.setSize(500, 300);
		jf.getContentPane().setBackground(new Color(236, 233, 216));

		// 屏幕大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = jf.getSize();
		// 设置窗口在屏幕中的位置
		jf.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		// 窗口尺寸是否可变
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
}