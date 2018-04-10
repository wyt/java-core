package org.wangyt.javase.gui.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 俄罗斯方块
 * 
 * @author 王永涛
 * 
 * @since 2012-8-30 下午11:15:26
 * 
 */
@SuppressWarnings("all")
public class Travil extends JFrame implements KeyListener {
  private static final long serialVersionUID = -3138573894699408531L;

  private JTextArea[][] grids; // 存放各自的文本域
  private int data[][]; // 对应每个格子的数据，1代表有，0代表无
  private int rect; // 当前下落方块的类型
  private int[] allRect; // 所有的方块类型，由16个字节记录
  private int x, y; // 当前方块的位置，x代表行，y代表列
  private int score; // 得分，每消一层加一分
  private JLabel label; // 显示分数的标签
  private boolean running; // 游戏是否结束

  public Travil() {
    grids = new JTextArea[21][12]; // 最左边、最右边和最下边作为游戏的边框
    data = new int[21][12]; // 与格子对应的数据
    // 所有的方块类型，由16个字节来记录方块占用格子的情况
    allRect = new int[] {0xcc, 0x8888, 0xf, 0xc44, 0x2e, 0x88c, 0xe8, 0xc88, 0xe2, 0x44c, 0x8e,
        0x8c4, 0x6c, 0x4c8, 0xc6, 0x8c8, 0x4e, 0x4c4, 0xe4};
    label = new JLabel("socre:0");
    running = false;
    init(); // 初始化操作
  }

  public void init() {
    JPanel main = new JPanel();
    JPanel right = new JPanel();
    main.setLayout(new GridLayout(21, 12, 1, 1));
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        grids[i][j] = new JTextArea(20, 20);
        grids[i][j].setBackground(Color.WHITE);
        if (j == 0 || j == grids[i].length - 1 || i == grids.length - 1) {
          grids[i][j].setBackground(Color.GREEN);
          grids[i][j].addKeyListener(this);
          data[i][j] = 1;
        }
        grids[i][j].setEditable(false);
        main.add(grids[i][j]);
      }
    }
    right.setLayout(new GridLayout(4, 4, 1, 1));

    right.add(new JLabel(" a : left"));
    right.add(new JLabel(" d : right"));
    right.add(new JLabel(" s : down"));
    right.add(new JLabel(" w : change"));
    right.add(new JLabel(""));
    right.add(new JLabel(""));
    right.add(label);
    this.setLayout(new BorderLayout());
    this.add(main, BorderLayout.CENTER);
    this.add(right, BorderLayout.EAST);
    running = true;
  }

  public void ranRect() // 随即产生方块类型
  {
    rect = allRect[(short) (Math.random() * 19)];
  }

  public void keyPressed(KeyEvent e) {}

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {
    if (e.getKeyChar() == 'a') {
      if (running == false)
        return;
      if (y <= 1)
        return;
      int tmp = 0x8000;
      for (int i = x; i < x + 4; i++) // 2次循环判断是否碰壁
      {
        for (int j = y; j < y + 4; j++) {
          if ((rect & tmp) != 0) {
            if (data[i][j - 1] == 1) {
              return; // 碰壁
            }
            // tmp >>= 1;
          }
          tmp >>= 1;
        }
      }
      clear(x, y); // 清除图像
      y--;
      draw(x, y);
    }
    if (e.getKeyChar() == 'd') {
      if (running == false) {
        return;
      }
      int tmp = 0x8000;
      int num = 7;
      int m = x, n = y;
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          if ((tmp & rect) != 0) {
            if (n > num)
              num = n;
          }
          tmp >>= 1;
          n++;
        }
        m++;
        n -= 4;
      }
      if (num >= 10)
        return;
      tmp = 0x8000;
      for (int i = x; i < x + 4; i++) {
        for (int j = y; j < y + 4; j++) {
          if ((rect & tmp) != 0) {
            if (data[i][j + 1] == 1)
              return;
          }
          tmp >>= 1;
        }
      }
      clear(x, y);
      y++;
      draw(x, y);
    }
    if (e.getKeyChar() == 's') {
      if (running == false)
        return;
      if (canFall(x, y) == false) {
        saveData(x, y);
        return;
      }
      clear(x, y);
      x++;
      draw(x, y);
    }
    if (e.getKeyChar() == 'w') {
      if (running == false)
        return;
      int i = 0;
      for (; i < allRect.length; i++) {
        if (rect == allRect[i])
          break;
      }
      if (i == 0)
        return;
      clear(x, y);
      if (i == 1 || i == 2) {
        rect = allRect[i == 1 ? 2 : 1];
        if (y > 7)
          y = 7;
      }
      if (i >= 3 && i <= 6) {
        rect = allRect[i + 1 > 6 ? 3 : i + 1];
      }
      if (i >= 7 && i <= 10) {
        rect = allRect[i + 1 > 10 ? 7 : i + 1];
      }
      if (i == 11 || i == 12) {
        rect = allRect[i == 11 ? 12 : 11];
      }
      if (i == 13 || i == 14) {
        rect = allRect[i == 13 ? 14 : 13];
      }
      if (i >= 15 && i <= 18) {
        rect = allRect[i + 1 > 18 ? 15 : i + 1];
      }
      if (y > 8)
        y = 8;
      draw(x, y);

    }
  }

  public void fall(int m, int n) {
    if (m > 0)
      clear(m - 1, n);
    draw(m, n);
  }

  public void draw(int m, int n) {
    int tmp = 0x8000;
    for (int j = 0; j < 4; j++) {
      for (int k = 0; k < 4; k++) {
        if ((tmp & rect) != 0) {
          // 变成黑色
          grids[m][n].setBackground(Color.BLACK);
        }
        tmp >>= 1;
        n++;
      }
      m++;
      n -= 4;
    }
  }

  public void clear(int m, int n) {
    int tmp = 0x8000;
    for (int j = 0; j < 4; j++) {
      for (int k = 0; k < 4; k++) {
        if ((tmp & rect) != 0) {
          // 变成白色
          grids[m][n].setBackground(Color.WHITE);
        }
        tmp >>= 1;
        n++;
      }
      m++;
      n -= 4;
    }
  }

  public boolean canFall(int m, int n) {
    int tmp = 0x8000;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if ((tmp & rect) != 0) {
          if (data[m + 1][n] == 1)
            return false;
        }
        tmp >>= 1;
        n++;
      }
      m++;
      n -= 4;
    }
    return true;
  }

  public void saveData(int m, int n) {
    int tmp = 0x8000;
    for (int j = 0; j < 4; j++) {
      for (int k = 0; k < 4; k++) {
        if ((tmp & rect) != 0) {
          data[m][n] = 1;
        }
        tmp >>= 1;
        n++;
      }
      m++;
      n -= 4;
    }
  }

  public void removeRow(int row) {
    for (int i = row; i >= 1; i--) {
      for (int j = 1; j <= 10; j++) {
        data[i][j] = data[i - 1][j];
      }
    }
    reflesh();
    score++;
    label.setText("socre:" + score);
  }

  public void reflesh() {
    for (int i = 1; i < 20; i++) {
      for (int j = 1; j < 11; j++) {
        if (data[i][j] == 1)
          grids[i][j].setBackground(Color.BLACK);
        else
          grids[i][j].setBackground(Color.WHITE);
      }
    }
  }

  public void start() {
    x = 0;
    y = 5;
    for (int i = 0; i < 21; i++) {
      try {
        Thread.sleep(1000);
        if (canFall(x, y) == false) {
          saveData(x, y);
          for (int k = x; k < x + 4; k++) {
            int sum = 0;
            for (int j = 1; j <= 10; j++) {
              if (data[k][j] == 1)
                sum++;
            }
            if (sum == 10)
              removeRow(k);
          }
          for (int j = 1; j <= 10; j++) {
            if (data[3][j] == 1) {
              running = false;
              break;
            }
          }
          break;
        }
        x++;
        fall(x, y);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void showMe() {
    this.setSize(600, 800);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void go() {
    while (true) {
      if (running == false)
        break;
      ranRect();
      start();
    }
    label.setText("Game over");
  }

  public static void main(String[] args) {
    Travil t = new Travil();
    t.showMe();
    t.go();
  }
  
}
