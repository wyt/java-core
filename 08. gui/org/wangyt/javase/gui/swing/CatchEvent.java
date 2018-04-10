package org.wangyt.javase.gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 捕获事件
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-9-2 下午01:26:27
 * 
 */
public class CatchEvent {

  private static JTextField text = new JTextField(10);

  public static void main(String[] args) {

    JFrame jf = new JFrame("Catch Event");
    jf.setLayout(new FlowLayout());

    jf.add(text);
    
    JButton btn = new JButton("click me");
    jf.add(btn);
    
//    btn.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
//        text.setText("按钮被点了!");
//      }
//    });
    
    btn.addActionListener((ActionEvent e) -> {
      System.out.println("Action command: " + e.getActionCommand());
      text.setText("按钮被点了!");
    });

    showWindow(jf);
  }

  /**
   * 显示窗体的方法
   * 
   * @param jf JFrame
   */
  public static void showWindow(JFrame jf) {

    jf.setSize(800, 400);
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
