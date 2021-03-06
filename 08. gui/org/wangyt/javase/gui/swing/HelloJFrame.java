package org.wangyt.javase.gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * 绘制一个窗口
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-9-1 下午09:13:58
 * 
 */
public class HelloJFrame {

  public static void main(String[] args) {

    JFrame jf = new JFrame("hello swing");
    jf.setSize(600, 400);
    jf.getContentPane().setBackground(new Color(236, 233, 216));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 屏幕大小
    Dimension frameSize = jf.getSize();

    // 设置窗口在屏幕中的位置
    jf.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);

    jf.setResizable(true); // 窗口尺寸是否可变
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
  }

}
