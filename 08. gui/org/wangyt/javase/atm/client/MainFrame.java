package org.wangyt.javase.atm.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * @author 王永涛
 * 
 * @since 2010-12-7
 * 
 */
@SuppressWarnings("all")
class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 6004275122437526592L;

	// ArrayList<String> al; //定义一个集合，用于存取操作信息。
	String caozuoInf = "";
	String guojiTag = "cn"; // "cn"表示当前为中文国际化,"en"表示当前为英文国际化
	static MainFrame mf;
	String serAccount = "";
	InputStream is;
	OutputStream os;
	JTabbedPane jtb;
	MyActionListener ml;
	JTextField userNametf;
	JTextField userIdtf;
	JTextField userAddresstf;
	JTextField userTeltf;
	JTextField otherTeltf;
	JPasswordField password1tf;
	JPasswordField password2tf;
	JTextField userCardtf;
	JTextField userMoneytf;

	JPasswordField passwordjpf;
	JTextField cardnumtf;

	JLabel cardnum_;
	JLabel password_;
	JPanel jp1;
	JPanel jp11;
	JPanel jp111;
	JPanel jp112;
	JPanel jp113;
	JButton button1;
	JButton button2;
	JButton button3;
	JTextField qkjejtf;
	JTextField ckjejtf;
	JTextField jp6jtf1; // 转账账户
	JTextField jp6jtf2; // 转账金额

	JTextField jp7jtf1;
	JTextField jp7jtf2;
	JTextField jp7jtf3;

	JLabel userName;
	JLabel userId;
	JLabel userAddress;
	JLabel userTel;
	JLabel otherTel;
	JLabel password1;
	JLabel password2;
	JLabel userCard;
	JLabel userMoney;
	JButton jp3_btn;
	JLabel qkje;
	JButton qkjebtn;
	JLabel ckje;
	JButton ckjebtn;
	JLabel jp6lb1;
	JLabel jp6lb2;
	JButton jp6btn1;
	JButton jp6btn2;
	JLabel jp7lb1;
	JLabel jp7lb2;
	JLabel jp7lb3;
	JButton jp7btn1;
	JButton jp7btn2;
	JButton jp8_btn1;
	JButton sure;
	JButton cancel;
	JButton jp8_btn2;

	public MainFrame() {
		super("WayCool ATM Client");
		// al = new ArrayList<String>(); //初始化集合
		ml = new MyActionListener();
		jtb = new JTabbedPane(JTabbedPane.TOP);
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1));
		JLabel img = new JLabel(new ImageIcon("atm/com/xiaotao/javase/atm/client/Bank1.jpg"));
		jp1.add(img);

		jp11 = new JPanel();
		jp11.setLayout(new GridLayout(3, 1));
		jp111 = new JPanel();
		cardnum_ = new JLabel("卡号:");
		cardnumtf = new JTextField(15);
		jp111.add(cardnum_);
		jp111.add(cardnumtf);
		jp11.add(jp111);
		jp112 = new JPanel();
		password_ = new JLabel("密码:");
		passwordjpf = new JPasswordField(15);
		passwordjpf.setEchoChar('●');
		jp112.add(password_);
		jp112.add(passwordjpf);
		jp11.add(jp112);
		jp113 = new JPanel();
		button1 = new JButton("确定");
		button1.setActionCommand("确定1");
		button1.addActionListener(ml);
		button2 = new JButton("重置");
		button2.setActionCommand("取消1");
		button2.addActionListener(ml);
		button3 = new JButton("English");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Properties pro = new Properties();
				if (button3.getText().equals("English")) {
					guojiTag = "en";
					button3.setText("中文简体");
					try {
						pro.load(new FileInputStream("atm/com/xiaotao/javase/atm/client/en_US.ini"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					guojiTag = "cn";
					button3.setText("English");
					try {
						pro.load(new FileInputStream("atm/com/xiaotao/javase/atm/client/cn_ZH.ini"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				// 选项卡的国际化
				jtb.setTitleAt(0, pro.getProperty("dengluwin")); // 登录窗口选项卡
				jtb.setTitleAt(1, pro.getProperty("zhucewin")); // 注册窗口选项卡
				jtb.setTitleAt(2, pro.getProperty("chaxunwin")); // 查询窗口选项卡
				jtb.setTitleAt(3, pro.getProperty("qukuanwin")); // 取款窗口选项卡
				jtb.setTitleAt(4, pro.getProperty("cunkuanwin")); // 存款窗口选项卡
				jtb.setTitleAt(5, pro.getProperty("zhuanzhangwin")); // 转账窗口选项卡
				jtb.setTitleAt(6, pro.getProperty("xiugaiwin")); // 修改密码窗口选项卡
				jtb.setTitleAt(7, pro.getProperty("tuichuwin")); // 退出登录窗口选项卡
				// 标签的国际化
				cardnum_.setText(pro.getProperty("kahao")); // 登录窗口卡号标签
				password_.setText(pro.getProperty("mima")); // 登录窗口密码标签
				userName.setText(pro.getProperty("yonghuxingming")); // 注册窗口用户姓名
				userId.setText(pro.getProperty("shenfenzhenghao")); // 注册窗口身份证号
				userAddress.setText(pro.getProperty("zhuzhi")); // 注册窗口家庭住址
				userTel.setText(pro.getProperty("dianhua")); // 注册窗口电话号码
				otherTel.setText(pro.getProperty("qitahaoma")); // 注册窗口其他号码
				password1.setText(pro.getProperty("shurumima")); // 注册窗口输入密码
				password2.setText(pro.getProperty("querenmima")); // 注册窗口确认密码
				userCard.setText(pro.getProperty("yinhangkahao")); // 注册窗口银行卡号
				userMoney.setText(pro.getProperty("jine")); // 注册窗口存入金额
				qkje.setText(pro.getProperty("qukuanjine")); // 取款窗口取款金额
				ckje.setText(pro.getProperty("cunkuanjine")); // 存款窗口存款金额
				jp6lb1.setText(pro.getProperty("duifangzhanghu")); // 转账窗口对方账户
				jp6lb2.setText(pro.getProperty("zhuanzhangjine")); // 转账窗口转账金额
				jp7lb1.setText(pro.getProperty("yuanmima")); // 修改密码窗口 请输入原密码
				jp7lb2.setText(pro.getProperty("xinmima")); // 修改密码窗口 请输入新密码
				jp7lb3.setText(pro.getProperty("querenxin")); // 修改密码窗口 请确认新密码
				// 按钮的国际化
				button1.setText(pro.getProperty("queding")); // 登录窗口确定按钮
				button2.setText(pro.getProperty("chongzhi")); // 登录窗口重置按钮
				sure.setText(pro.getProperty("queding")); // 注册窗口确定按钮
				cancel.setText(pro.getProperty("chongzhi")); // 注册窗口重置按钮
				jp3_btn.setText(pro.getProperty("chaxunyue"));// 查询窗口查询余额按钮
				qkjebtn.setText(pro.getProperty("queding"));// 取款窗口确定按钮
				ckjebtn.setText(pro.getProperty("queding"));// 存款窗口确定按钮
				jp6btn1.setText(pro.getProperty("queding"));// 转账窗口确定按钮
				jp6btn2.setText(pro.getProperty("chongzhi")); // 转账窗口重置按钮
				jp7btn1.setText(pro.getProperty("queding")); // 修改密码窗口确定按钮
				jp7btn2.setText(pro.getProperty("chongzhi")); // 修改密码窗口重置按钮
				jp8_btn1.setText(pro.getProperty("tuichudenglu")); // 退出登录窗口 安全退出按钮
				jp8_btn2.setText(pro.getProperty("dayinxinxi"));// 退出登录窗口 打印信息按钮
			}
		});
		jp113.add(button1);
		jp113.add(button2);
		jp113.add(button3);
		jp11.add(jp113);
		jp1.add(jp11);

		jtb.add("登录窗口", jp1);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(10, 1));
		JPanel jp20 = new JPanel();
		userName = new JLabel("用户姓名:");
		userNametf = new JTextField(15);
		jp20.add(userName);
		jp20.add(userNametf);
		jp2.add(jp20);
		JPanel jp21 = new JPanel();
		userId = new JLabel("身份证号:");
		userIdtf = new JTextField(15);
		jp21.add(userId);
		jp21.add(userIdtf);
		jp2.add(jp21);
		JPanel jp22 = new JPanel();
		userAddress = new JLabel("家庭住址:");
		userAddresstf = new JTextField(15);
		jp22.add(userAddress);
		jp22.add(userAddresstf);
		jp2.add(jp22);
		JPanel jp23 = new JPanel();
		userTel = new JLabel("电话号码:");
		userTeltf = new JTextField(15);
		jp23.add(userTel);
		jp23.add(userTeltf);
		jp2.add(jp23);
		JPanel jp24 = new JPanel();
		otherTel = new JLabel("其他号码:");
		otherTeltf = new JTextField(15);
		jp24.add(otherTel);
		jp24.add(otherTeltf);
		jp2.add(jp24);
		JPanel jp25 = new JPanel();
		password1 = new JLabel("输入密码:");
		password1tf = new JPasswordField(15);
		password1tf.setEchoChar('●');
		jp25.add(password1);
		jp25.add(password1tf);
		jp2.add(jp25);
		JPanel jp26 = new JPanel();
		password2 = new JLabel("确认密码:");
		password2tf = new JPasswordField(15);
		password2tf.setEchoChar('●');
		jp26.add(password2);
		jp26.add(password2tf);
		jp2.add(jp26);
		JPanel jp27 = new JPanel();
		userCard = new JLabel("银行卡号:");
		userCardtf = new JTextField(15);
		jp27.add(userCard);
		jp27.add(userCardtf);
		jp2.add(jp27);
		JPanel jp28 = new JPanel();
		userMoney = new JLabel("存入金额:");
		userMoneytf = new JTextField(15);
		jp28.add(userMoney);
		jp28.add(userMoneytf);
		jp2.add(jp28);

		JPanel jp29 = new JPanel();
		sure = new JButton("确定");
		sure.setActionCommand("确定2");
		sure.addActionListener(ml);
		cancel = new JButton("重置");
		cancel.setActionCommand("重置2");
		cancel.addActionListener(ml);
		jp29.add(sure);
		jp29.add(cancel);
		jp2.add(jp29);

		jtb.add("注册窗口", jp2);

		JPanel jp3 = new JPanel();
		jp3_btn = new JButton("查询余额");
		jp3_btn.setActionCommand("查询余额");
		jp3_btn.addActionListener(ml);
		jp3.add(jp3_btn);
		jtb.add("查询窗口", jp3);

		JPanel jp4 = new JPanel();
		jp4.setLayout(new GridLayout(2, 1));
		JPanel jp41 = new JPanel();
		qkje = new JLabel("取款金额:");
		qkjejtf = new JTextField(10);
		qkjebtn = new JButton("确定");
		qkjebtn.setActionCommand("取款确定");
		qkjebtn.addActionListener(ml);
		jp41.add(qkje);
		jp41.add(qkjejtf);
		jp41.add(qkjebtn);
		jp4.add(jp41);

		jtb.add("取款窗口", jp4);

		JPanel jp5 = new JPanel();
		jp5.setLayout(new GridLayout(2, 1));
		JPanel jp51 = new JPanel();
		ckje = new JLabel("存款金额:");
		ckjejtf = new JTextField(10);
		ckjebtn = new JButton("确定");
		ckjebtn.setActionCommand("存款确定");
		ckjebtn.addActionListener(ml);
		jp51.add(ckje);
		jp51.add(ckjejtf);
		jp51.add(ckjebtn);
		jp5.add(jp51);
		jtb.add("存款窗口", jp5);

		JPanel jp6 = new JPanel();
		jp6.setLayout(new GridLayout(9, 1));
		jp6lb1 = new JLabel("对方账户:");
		jp6lb2 = new JLabel("转账金额:");
		jp6jtf1 = new JTextField(10);
		jp6jtf2 = new JTextField(10);
		jp6btn1 = new JButton("确定");
		jp6btn1.setActionCommand("转账确定");
		jp6btn1.addActionListener(ml);

		jp6btn2 = new JButton("重置");
		jp6btn2.setActionCommand("转账重置");
		jp6btn2.addActionListener(ml);

		JPanel jp6pl1 = new JPanel();
		JPanel jp6pl2 = new JPanel();
		JPanel jp6pl3 = new JPanel();
		jp6pl1.add(jp6btn1);
		jp6pl1.add(jp6btn2);
		jp6pl2.add(jp6lb1);
		jp6pl2.add(jp6jtf1);
		jp6pl3.add(jp6lb2);
		jp6pl3.add(jp6jtf2);
		jp6.add(jp6pl2);
		jp6.add(jp6pl3);
		jp6.add(jp6pl1);
		jtb.add("转账窗口", jp6);

		JPanel jp7 = new JPanel();
		jp7.setLayout(new GridLayout(5, 1));
		JPanel jp71 = new JPanel();
		JPanel jp72 = new JPanel();
		JPanel jp73 = new JPanel();
		JPanel jp74 = new JPanel();
		jp7lb1 = new JLabel("请输入原密码:");
		jp7lb2 = new JLabel("请输入新密码:");
		jp7lb3 = new JLabel("请确认新密码:");
		jp7jtf1 = new JTextField(15);
		jp7jtf2 = new JTextField(15);
		jp7jtf3 = new JTextField(15);
		jp7btn1 = new JButton("确定");
		jp7btn1.setActionCommand("修改密码确定");
		jp7btn1.addActionListener(ml);
		jp7btn2 = new JButton("重置");
		jp7btn2.setActionCommand("修改密码重置");
		jp7btn2.addActionListener(ml);

		jp71.add(jp7lb1);
		jp71.add(jp7jtf1);
		jp72.add(jp7lb2);
		jp72.add(jp7jtf2);
		jp73.add(jp7lb3);
		jp73.add(jp7jtf3);
		jp74.add(jp7btn1);
		jp74.add(jp7btn2);
		jp7.add(jp71);
		jp7.add(jp72);
		jp7.add(jp73);
		jp7.add(jp74);

		jtb.add("修改密码", jp7);

		JPanel jp8 = new JPanel();
		jp8.setLayout(new GridLayout(2, 1));
		JPanel jp81 = new JPanel();
		jp8_btn1 = new JButton("退出登录");
		jp8_btn1.setActionCommand("退出登录");
		jp8_btn1.addActionListener(ml); // 添加监听
		jp8_btn2 = new JButton("打印信息");
		jp8_btn2.setActionCommand("打印信息");
		jp8_btn2.addActionListener(ml);
		jp81.add(jp8_btn2);
		jp81.add(jp8_btn1);
		jp8.add(jp81);
		jtb.add("安全退出", jp8);

		this.add(jtb);

		this.setBounds(10, 10, 650, 500);
		this.getContentPane().setBackground(new Color(236, 233, 216));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 屏幕大小
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 设置窗口在屏幕中的位置
		this.setResizable(false); // 窗口尺寸是否可变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String serAccount = ""; //服务端返回的当前登录账户的卡号，退出登录时要用到。写在这个地方不行，后面return断开整个方法。
			String com = e.getActionCommand();
			String pas1 = "";
			String pas2 = "";
			if ("打印信息".equals(com))/* 打印信息 */
			{
				if (serAccount.equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "当前无登陆账户！");
					} else {
						JOptionPane.showMessageDialog(mf, "Please login first!");
					}
					return;
				}
				JOptionPane.showMessageDialog(mf,
						"中国纬库银行" + "\n" + "操作单" + "\n" + "================================" + "\n" + caozuoInf
								+ "-------------------------------" + "\n" + "您的满意是我们做好的回报!" + "\n"
								+ "================================");
				return;
			}
			if ("修改密码确定".equals(com))/* 修改密码请求 */
			{
				if (serAccount.equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "当前无登陆账户!");
					} else {
						JOptionPane.showMessageDialog(mf, "None accounts now!");
					}
					return;
				}
				if (jp7jtf1.getText().equals("") || jp7jtf2.getText().equals("") || jp7jtf3.getText().equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "不能为空!");
					} else {
						JOptionPane.showMessageDialog(mf, "Don't null");
					}
					return;
				}
				if (!(jp7jtf2.getText().equals(jp7jtf3.getText()))) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "新密码前后输入不一致!");
					} else {
						JOptionPane.showMessageDialog(mf, "The password hasn't equals before!");
					}
					return;
				}
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					clisoc = new Socket("127.0.0.1", 8888);
					os = clisoc.getOutputStream();
					PrintWriter pw = new PrintWriter(os, true);
					pw.println("xgpassword"); // 发送修改密码请求
					pw.println(serAccount + ":" + jp7jtf1.getText() + ":" + jp7jtf3.getText()); // 发送当前要修改密码的账户、原密码、新密码
					is = clisoc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					if (br.readLine().equals("7")) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "原密码错误!");
						} else {
							JOptionPane.showMessageDialog(mf, "The forme password has is false!");
						}
						return;
					}
					// if(br.readLine().equals("8"))
					else {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "密码修改成功!");
						} else {
							JOptionPane.showMessageDialog(mf, "Alter the password have success!");
						}
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if ("转账确定".equals(com))/* 转账请求 */
			{
				if (jp6jtf1.getText().equals("") || jp6jtf2.getText().equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "账户或金额不能为空!");
					} else {
						JOptionPane.showMessageDialog(mf, "Accounts or money have not null!");
					}
					return;
				}
				if (jp6jtf1.getText().equals(serAccount)) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "同一账户不能转账");
					} else {
						JOptionPane.showMessageDialog(mf, "The same account have not transfer!");
					}
					return;
				}
				try {
					double money = Double.valueOf(jp6jtf2.getText());

					if (serAccount.equals("")) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "请先登录!");
						} else {
							JOptionPane.showMessageDialog(mf, "Please login first!");
						}
						return;
					}
				} catch (Exception e2) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "非法字符!");
					} else {
						JOptionPane.showMessageDialog(mf, "Lawlessness chars!");
					}
					return;
				}
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					clisoc = new Socket("127.0.0.1", 8888);
					os = clisoc.getOutputStream();
					PrintWriter pw = new PrintWriter(os, true);
					pw.println("zhuanzhang"); // 发送转账请求
					String duifang = jp6jtf1.getText();
					String zhuanzhangjine = jp6jtf2.getText();
					pw.println(serAccount + ":" + duifang + ":" + zhuanzhangjine); // 发送当前登录账户、对方账户、和转账金额

					is = clisoc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String str = br.readLine(); // 等待读取服务器返回的转账是否成功的信息
					if ("YES".equals(str)) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "转账成功!");
						} else {
							JOptionPane.showMessageDialog(mf, "Transfer success!");
						}
						caozuoInf = caozuoInf + new Date(System.currentTimeMillis()).toString() + " 转入账户" + duifang
								+ " " + zhuanzhangjine + "\n";
						return;
					} else {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "转入账户不存在!");
						} else {
							JOptionPane.showMessageDialog(mf, "The account of in hasn't exist!");
						}
						return;
					}
				} catch (Exception e1) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
					return;
				}
			}
			if ("存款确定".equals(com))/* 存款请求 */
			{
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					long money = Long.valueOf(ckjejtf.getText());
					if (money % 100 != 0) {
						JOptionPane.showMessageDialog(mf, "本行只能接收100元的纸币!");
						return;
					}
					if (serAccount.equals("")) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "请先登录!");
						} else {
							JOptionPane.showMessageDialog(mf, "Please login first!");
						}
						return;
					}
				} catch (Exception e2) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "非法字符!");
					} else {
						JOptionPane.showMessageDialog(mf, "lawlessness chars!");
					}
					return;
				}
				try {
					clisoc = new Socket("127.0.0.1", 8888);
					os = clisoc.getOutputStream();
					PrintWriter pw = new PrintWriter(os, true);
					pw.println("cunkuan"); // 发送存款请求
					String cunkuanjine = ckjejtf.getText();
					pw.println(serAccount + ":" + cunkuanjine); // 发送存款账户和存款金额
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "存款成功!");
					} else {
						JOptionPane.showMessageDialog(mf, "Desposit success!");
					}
					caozuoInf = caozuoInf + new Date(System.currentTimeMillis()).toString() + " 存款" + cunkuanjine
							+ "\n";
					return;
				} catch (Exception e1) {
					// e1.printStackTrace();
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
					return;
				}
			}
			if ("查询余额".equals(com))/* 查询余额请求 */
			{
				if (serAccount.equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "请先登录!");
					} else {
						JOptionPane.showMessageDialog(mf, "Please login first!");
					}
					return;
				}
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					clisoc = new Socket("127.0.0.1", 8888);
					os = clisoc.getOutputStream();
					PrintWriter pw = new PrintWriter(os, true);
					pw.println("chaxun"); // 发送查询请求
					pw.println(serAccount); // 发送账户信息

					is = clisoc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String stryue = br.readLine(); // 读取服务器
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "余额:" + stryue + "元");
					} else {
						JOptionPane.showMessageDialog(mf, "Balance:" + stryue + "YUAN");
					}
					return;
				} catch (Exception em) {
					// em.printStackTrace();
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
				}
			}
			if ("取款确定".equals(com))/* 取款请求 */
			{
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;
				try {
					long money = Long.valueOf(qkjejtf.getText());
					if (money % 100 != 0) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "本行只能提供100元的纸币!");
						} else {
							JOptionPane.showMessageDialog(mf, "we have support the RMB of 100 only");
						}
						return;
					}
					if (serAccount.equals("")) {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "请先登录!");
						} else {
							JOptionPane.showMessageDialog(mf, "Please login first!");
						}
						return;
					}
				} catch (Exception e2) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "非法字符!");
					} else {
						JOptionPane.showMessageDialog(mf, "lawlessness chars!");
					}
					return;
				}
				try {
					clisoc = new Socket("127.0.0.1", 8888);
					PrintWriter pw = new PrintWriter(clisoc.getOutputStream(), true);
					pw.println("qukuan"); // 发送取款请求
					String qukuanjine = qkjejtf.getText();
					pw.println(serAccount + ":" + qukuanjine); // 发送当前登录账户和取款金额
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "请收取30秒内收取现金!");
					} else {
						JOptionPane.showMessageDialog(mf, "Please get the money in 30 seconds!");
					}
					caozuoInf = caozuoInf + new Date(System.currentTimeMillis()).toString() + " 取款" + qukuanjine + "\n";
					return;

				} catch (Exception ae) {
					// ae.printStackTrace();
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
				}
			}
			if ("退出登录".equals(com))/* 退出登录请求 */
			{
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;

				if ("".equals(serAccount)) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "当前无登陆账户!");
					} else {
						JOptionPane.showMessageDialog(mf, "None account now!");
					}
					return;
				}

				try {
					clisoc = new Socket("127.0.0.1", 8888);
					PrintWriter pw = new PrintWriter(clisoc.getOutputStream(), true);

					pw.println("tuichu"); // 发送退出请求
					pw.println(serAccount);// 发送所要退出的账户的卡号
					serAccount = "";
					cardnumtf.setEnabled(true);
					passwordjpf.setEnabled(true);
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "退出成功!");
					} else {
						JOptionPane.showMessageDialog(mf, "Exit success!");
					}
					caozuoInf = "";
					return;

				} catch (Exception e1) {
					// e1.printStackTrace();
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
				}
			}
			if ("确定1".equals(com))/* 登录请求 */
			{
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;

				String cardnum = cardnumtf.getText(); // 得到用户卡号
				String password = passwordjpf.getText(); // 得到卡号密码
				if (cardnum.equals("") || password.equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "不能为空!");
					} else {
						JOptionPane.showMessageDialog(mf, "Don't null!");
					}
					return;
				}
				String cardpass = cardnum + ":" + password;

				try {
					clisoc = new Socket("127.0.0.1", 8888); // 连接客户端socket
					final PrintWriter pw = new PrintWriter(clisoc.getOutputStream(), true);
					pw.println("denglu"); // 发送登录请求
					pw.println(cardpass); // 发送卡号和密码信息

					is = clisoc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String str1 = br.readLine();
					// System.out.println(str1); //测试
					if (str1.charAt(0) == '2') {
						String[] strArray = str1.split(":");
						String username = strArray[1];
						serAccount = strArray[2];
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "欢迎您 " + username + " 先生!");
						} else {
							JOptionPane.showMessageDialog(mf, "welcome to Google bank Mr." + username);
						}
						cardnumtf.setText("");
						passwordjpf.setText("");
						cardnumtf.setEnabled(false);
						passwordjpf.setEnabled(false);
						caozuoInf = caozuoInf + new Date(System.currentTimeMillis()).toString() + " 登录" + "\n";
						return;
					}
					if (str1.charAt(0) == '3') {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "密码错误,或当前账户处于登录状态");
						} else {
							JOptionPane.showMessageDialog(mf, "Password was false or the account on line!");
						}
						return;
					}
				} catch (Exception e1) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
					} else {
						JOptionPane.showMessageDialog(mf, "Not be joined server!");
					}
					return;
				}

			}
			if ("取消1".equals(com))/* 登录窗口重置 */
			{
				passwordjpf.setText("");
				cardnumtf.setText("");
			}
			if ("确定2".equals(com))/* 注册请求 */
			{
				Socket clisoc = null;
				InputStream is = null;
				OutputStream os = null;

				String str1 = userNametf.getText(); // 得到姓名输入框内容
				String str2 = userIdtf.getText(); // 得到身份证号输入框内容
				String str3 = userAddresstf.getText(); // 得到家庭住址输入框的内容
				String str4 = userTeltf.getText(); // 得到电话号码输入框的内容
				String str5 = otherTeltf.getText(); // 得到其他号码输入框的内容
				String str6 = password1tf.getText(); // 得到输入密码文本框的内容
				String str7 = password2tf.getText(); // 得到确认密码文本框的内容
				String str8 = userCardtf.getText(); // 得到银行卡号文本框的内容
				String str9 = userMoneytf.getText(); // 得到输入金额文本框的内容
				if (str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("") || str5.equals("")
						|| str6.equals("") || str7.equals("") || str8.equals("") || str9.equals("")) {
					if (guojiTag.equals("cn")) {
						JOptionPane.showMessageDialog(mf, "文本输入框不能为空!");
					} else {
						JOptionPane.showMessageDialog(mf, "Don't null!");
					}
					return;
				} else {
					if (str6.equals(str7)) // 如果两次输入的密码相同
					{
						try {
							clisoc = new Socket("127.0.0.1", 8888);
							is = clisoc.getInputStream();
							os = clisoc.getOutputStream(); // 得到一个输出流,向客户端socket写数据.
						} catch (Exception ee) {
							if (guojiTag.equals("cn")) {
								JOptionPane.showMessageDialog(mf, "无法与服务器建立连接,请检查网络状况!");
							} else {
								JOptionPane.showMessageDialog(mf, "Not be joined server!");
							}
							return;
						}
						PrintWriter pwzc = new PrintWriter(os, true);
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						pwzc.println("zhuce");
						/*
						 * write-1*向服务端发送注册请求，服务器接收到注册请求后，调用userRegister()方法。
						 * //向服务器发送注册请求要在客户端检测信息无误后，再发送注册请求。
						 */
						String str = str1 + ":" + str2 + ":" + str3 + ":" + str4 + ":" + str5 + ":" + str6 + ":" + str8
								+ ":" + str9;
						pwzc.println(str);/* write-2*向服务器提交注册信息 */

						try {
							if (br.readLine().equals("1")) {
								if (guojiTag.equals("cn")) {
									JOptionPane.showMessageDialog(mf, "注册成功!");
								} else {
									JOptionPane.showMessageDialog(mf, "Register success!");
								}
								br.close();
								return;
							} else {
								if (guojiTag.equals("cn")) {
									JOptionPane.showMessageDialog(mf, "该账户已存在!");
								} else {
									JOptionPane.showMessageDialog(mf, "The account had exist!");
								}
								br.close();
								return;
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else {
						if (guojiTag.equals("cn")) {
							JOptionPane.showMessageDialog(mf, "前后密码输入不一致!");
						} else {
							JOptionPane.showMessageDialog(mf, "The password hasn't equals before!");
						}
						return;
					}
				}
			}
			if ("转账重置".equals(com))/* 转账窗口重置 */
			{
				jp6jtf1.setText("");
				jp6jtf2.setText("");
			}
			if ("修改密码重置".equals(com)) {
				jp7jtf1.setText("");
				jp7jtf2.setText("");
				jp7jtf3.setText("");
			}
			if ("重置2".equals(com)) {
				reset();
			}
		}

		public void reset() {
			userNametf.setText("");
			userIdtf.setText("");
			userAddresstf.setText("");
			userTeltf.setText("");
			otherTeltf.setText("");
			password1tf.setText("");
			password2tf.setText("");
			userCardtf.setText("");
			userMoneytf.setText("");
		}
	}

	public static void main(String[] args) {
		mf = new MainFrame();
	}
	
}