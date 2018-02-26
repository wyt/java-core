package org.wangyt.javase.atm.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 
 * @author 王永涛
 * 
 * @date 2010-12-7
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
class ClientATMThread extends Thread implements BankModelIf
{
    Socket sersoc;
    InputStream is;
    OutputStream os;

    public ClientATMThread(Socket sersoc)
    {
        this.sersoc = sersoc;
    }

    public void run()
    {
        String ask = "";
        BufferedReader br = null;
        PrintWriter pw = null;
        try
        {
            is = sersoc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            os = sersoc.getOutputStream();
            pw = new PrintWriter(os);
            ask = br.readLine(); /* read-1*读取客户端发来的请求 */

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        if ("xgpassword".equals(ask))
        {
            try
            {
                String strcli = br.readLine();
                String[] scArr = strcli.split(":");
                if (!(yanzhengPassword(scArr[0], scArr[1])))
                {
                    // System.out.print("=====");
                    pw.println("7"); // 如果原密码验证失败，发送"7"
                    pw.close();
                    return;
                }
                if (passWordChange(scArr[0], scArr[2]))
                {
                    // System.out.println("~~~~~");
                    pw.println("8");
                    pw.close();
                    return;
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        if ("zhuanzhang".equals(ask))
        {
            try
            {
                String strcli = br.readLine();
                String[] scArr = strcli.split(":");
                // 调用转账方法
                // 参数一次为：转出账户、转入账户、转账金额
                // System.out.println(transfer(scArr[0],scArr[1],scArr[2])); //测试
                if (transfer(scArr[0], scArr[1], scArr[2])) // 如果转账成功,返回YES
                {
                    pw.println("YES");
                    pw.close(); // 记得关闭流，刷新缓冲区
                    return;
                } else
                // 如果转账不成功,返回NO
                {
                    pw.println("NO");
                    pw.close();
                    return;
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if ("cunkuan".equals(ask))
        {
            try
            {
                String strcli = br.readLine(); // 读取客户端发来的账户和存款金额
                String[] scArr = strcli.split(":");
                // 调用存款方法
                deposit(scArr[0], scArr[1]);
                return;
            } catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        if ("chaxun".equals(ask))
        {
            try
            {
                pw.println(getBalance(br.readLine()));
                pw.flush();
                return;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if ("qukuan".equals(ask))/* 客户端取款请求的处理 */
        {
            try
            {
                String strcli = br.readLine();
                String[] scArr = strcli.split(":");
                // long money = Long.valueOf(br.readLine());
                withdraw(scArr[0], scArr[1]); // 更改账户余额
                return;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if ("tuichu".equals(ask))/* 客户端退出请求的处理 */
        {
            try
            {
                String cliAccount = br.readLine(); // 读取客户端发来的需要退出的账户的卡号
                File file = new File("atm/com/xiaotao/javase/atm/db/accounts/" + cliAccount + ".txt");
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Account acc = (Account) ois.readObject();
                acc.setExitTag("");

                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(acc); // 修改后再持久化
                oos.close();
                ois.close();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if ("zhuce".equals(ask))/* 客户端注册请求的处理 */
        {
            try
            {
                Account account = new Account();
                String str = br.readLine();/* read-2*读取客户端发来的注册信息 */

                String[] strArr = str.split(":");
                account.setUserName(strArr[0]); // 用户姓名
                account.setCardID(strArr[1]); // 身份证号
                account.setAddress(strArr[2]); // 家庭住址
                account.setSelfPhone(strArr[3]); // 电话号码
                account.setOthersPhone(strArr[4]); // 其他号码
                account.setPassWord(strArr[5]); // 密码
                account.setAccounts(strArr[6]); // 卡号
                account.setDepositMoney(strArr[7]); // 输入金额
                if (userRegister(account))
                {
                    pw.println("1"); // “1”表示注册成功
                    pw.close();
                    return; // 结束此进程
                } else
                {
                    pw.println("0"); // “0”表示注册失败，卡号已经存在
                    pw.close();
                    return; // 结束此进程
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if ("denglu".equals(ask))/* 客户端登录请求的处理 */
        {
            String str = "";
            Account acc = null;
            try
            {
                str = br.readLine(); // 读取客户端发来的卡号密码信息
                // System.out.println(str); //测试,经测试此处卡号密码可以正常接收
            } catch (Exception e1)
            {
                e1.printStackTrace();
            }
            String[] strArr = str.split(":");
            if (userLogin(strArr[0], strArr[1])) // 如果userLogin()方法返回true，说明卡号密码验证通过
            {
                // 改变账户的退出标记,默认为"";
                File file1 = new File("atm/com/xiaotao/javase/atm/db/accounts/" + strArr[0] + ".txt");
                try
                {
                    FileInputStream fis = new FileInputStream(file1);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    acc = (Account) ois.readObject();

                } catch (Exception e1)
                {
                    e1.printStackTrace();
                }
                acc.setExitTag("zaixian"); // "zaixian" 表示此账户处于登录状态,默认为"";表示该账户处于退出状态。
                // 向客户端返回验证通过信息,用"2"表示。
                /*
                 * 把此账户对象标记为登录状态后,然后持久化,其他方法(例如需要确保账户处于登录状态的方法)
                 * 在调用此对象的时候先去检查该对象的退出标记属性,当用户选择安全退出的时候,改变该对象的退出标记
                 */
                try
                {
                    // 把退出标记修改后的acc再次持久化
                    FileOutputStream fos = new FileOutputStream(file1);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(acc);
                    oos.close();

                } catch (Exception e2)
                {
                    e2.printStackTrace();
                }

                // pw.println("2"+acc.getUserName()); //返回登录成功标记和此账号的用户名还有卡号。
                pw.println("2" + ":" + acc.getUserName() + ":" + acc.getAccounts());
                System.out.println("M");
                pw.close();
                return;
            } else
            // 验证不通过
            {
                // 向客户端返回验证失败信息，用"3"表示。
                pw.println("3");
                pw.close();
                return; // 登录验证失败，则关闭此线程，因为客户端此时已经关闭其线程。
            }

        }
    }

    /* 用户注册 */
    public boolean userRegister(Account account)
    {
        File file = new File("atm/com/xiaotao/javase/atm/db/accounts/");
        File[] fileArray = file.listFiles();
        String str = account.getAccounts() + ".txt"; // 得到对象的账号
        if (fileArray != null)
        {
            for (File f : fileArray)
            {
                if (f.getName().equals(str))
                    return false;
            }
        }
        try
        {
            File file1 = new File("atm/com/xiaotao/javase/atm/db/accounts/" + account.getAccounts() + ".txt");
            FileOutputStream fos = new FileOutputStream(file1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(account);
            oos.close();

            File file2 = new File("atm/com/xiaotao/javase/atm/db/askInformations/" + account.getAccounts() + ".txt");
            FileOutputStream fos1 = new FileOutputStream(file2, true);
            PrintWriter pw = new PrintWriter(fos1, true);
            pw.println("@" + new Date(System.currentTimeMillis()).toString() + " 注册此账户");
            pw.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    /* 登录验证 */
    public boolean userLogin(String accounts, String passWord)
    {
        // 验证卡号
        File file = new File("atm/com/xiaotao/javase/atm/db/accounts/");
        File[] fileArray = file.listFiles();
        String str = accounts + ".txt";
        boolean flag = false;
        if (fileArray != null)
        {
            for (File f : fileArray)
            {
                // System.out.println(f.getName()); //测试,经测试可以正常遍历抽象路径名
                // System.out.println("------");
                // System.out.println(str); //测试,
                // if(!(f.getName().equals(str))) //如果没有此账号返回false,此处出现错误!!
                if (f.getName().equals(str)) // 遍历的时候，如果遍历到相同的,令flag= true，并且断开整个循环
                {
                    // return false;
                    flag = true;
                    break;
                } else
                // 如果没有遍历到相同的，令flag = false
                {
                    flag = false;
                }
            }
        }
        if (flag == false) // 卡号不存在
        {
            return false;
        }
        // 验证密码
        Account acc = null;
        File file1 = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
        try
        {
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();

        } catch (Exception e1)
        {
            e1.printStackTrace();
        }
        if (acc.getExitTag().equals("zaixian"))// 判断账号是否在登录状态
        {
            return false;
        }
        if (!(acc.getPassWord().equals(passWord))) // 如果密码不同
        {
            return false;
        }
        try
        {
            File file2 = new File("atm/com/xiaotao/javase/atm/db/askInformations/" + accounts + ".txt");
            FileOutputStream fos = new FileOutputStream(file2, true);
            PrintWriter pw = new PrintWriter(fos, true);
            pw.println("@" + new Date(System.currentTimeMillis()).toString() + " 登录此账户");
        } catch (Exception e1)
        {
            e1.printStackTrace();
        }

        return true;
    }

    /* 存钱操作 */
    public boolean deposit(String accounts, String money)
    {
        double mon = 0.0;
        Account acc = null;
        try
        {
            File file = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();
            double yue = Double.valueOf(acc.getDepositMoney());
            mon = Double.valueOf(money);
            String dM = String.valueOf(ExactValue.add(yue, mon));
            acc.setDepositMoney(dM); // 至此余额设置完毕

            // 将对象持久化
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acc);
            oos.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    /* 取钱操作 */
    public int withdraw(String accounts, String money)
    {
        Double mon = 0.0;
        Account acc = null;

        try
        {
            mon = Double.valueOf(money);
            File file = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();
            double yue = Double.valueOf(acc.getDepositMoney()); // 账户余额
            String dM = String.valueOf(ExactValue.subtract(yue, mon));
            acc.setDepositMoney(dM); // 设置余额

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acc);
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /* 转帐 */
    public boolean transfer(String fromAccounts, String toAccounts, String money)
    {
        // 先检测转入账户是否存在
        File file = new File("atm/com/xiaotao/javase/atm/db/accounts/");
        File[] fileArray = file.listFiles();
        String toAcctxt = toAccounts + ".txt";
        boolean flag = false;
        if (fileArray != null)
        {
            for (File f : fileArray)
            {
                if (f.getName().equals(toAcctxt))
                {
                    flag = true;
                    break;
                } else
                {
                    flag = false;
                }
            }
        }
        if (!(flag)) // 如果转入账户不存在，则返回false
        {
            return false;
        }
        // 转账操作

        deposit(toAccounts, money); // 转入账户调用存钱方法
        withdraw(fromAccounts, money); // 转出账户调用取钱方法

        return true;
    }

    /* 修改密码 */
    public boolean passWordChange(String accounts, String newPassWord)
    {
        Account acc = null;
        try
        {
            File file = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();
            acc.setPassWord(newPassWord);

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acc);
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    /* 查询余额 */
    public String getBalance(String accounts)
    {
        Account acc = null;
        String yue = "";
        try
        {
            File file = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();
            yue = acc.getDepositMoney();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return yue;
    }

    /* 密码验证 */
    public boolean yanzhengPassword(String accounts, String passWord)
    {
        // 验证密码
        Account acc = null;
        File file1 = new File("atm/com/xiaotao/javase/atm/db/accounts/" + accounts + ".txt");
        try
        {
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();

        } catch (Exception e1)
        {
            e1.printStackTrace();
        }
        if (!(acc.getPassWord().equals(passWord))) // 如果密码不同
        {
            return false;
        }
        return true;
    }
}