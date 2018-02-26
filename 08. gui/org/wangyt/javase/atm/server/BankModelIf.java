package org.wangyt.javase.atm.server;

//胖服务器端、瘦客户端
public interface BankModelIf {
	
	// 登录验证
	public boolean userLogin(String accounts, String passWord);

	// 存钱操作
	public boolean deposit(String accounts, String money);

	// 取钱操作
	public int withdraw(String accounts, String money);

	// 转帐
	public boolean transfer(String fromAccounts, String toAccounts, String money);

	// 用户注册
	public boolean userRegister(Account account);

	// 修改密码
	public boolean passWordChange(String accounts, String newPassWord);

	// 查询余额
	public String getBalance(String accounts);
	
}