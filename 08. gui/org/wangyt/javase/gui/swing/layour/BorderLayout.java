package org.wangyt.javase.gui.swing.layour;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 东西南北中布局，布局都是可以嵌套的。
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-9-2 下午02:00:08
 * 
 */
public class BorderLayout {

  public static void main(String[] args) {
    JFrame jf = new JFrame("BorderLayout");
    jf.setLayout(new java.awt.BorderLayout());
    jf.add(new JButton("东"), java.awt.BorderLayout.EAST);
    // jf.add(new JButton("中"), java.awt.BorderLayout.CENTER);
    jf.add(new JTextArea("中"), java.awt.BorderLayout.CENTER);
    jf.add(new JButton("南"), java.awt.BorderLayout.SOUTH);
    jf.add(new JButton("北"), java.awt.BorderLayout.NORTH);
    jf.add(new JButton("西"), java.awt.BorderLayout.WEST);

    showWindow(jf);
  }

  /**
   * 显示窗体的方法
   * 
   * @param jf
   */
  public static void showWindow(JFrame jf) {
    jf.setSize(800, 500);
    jf.getContentPane().setBackground(new Color(236, 233, 216));

    // 屏幕大小
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = jf.getSize();
    // 设置窗口在屏幕中的位置
    jf.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    // 窗口尺寸是否可变
    jf.setResizable(false);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
  }

}
