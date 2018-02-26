package org.wangyt.javase.atm.server;

import java.io.Serializable;

/**
 * 对数据格式的封装,以下是数据格式的数据结构
 * 
 * 头信息:帐户:密码:存款数额:取款数额:转帐号码:转帐金额:退出标记:用户名:身份证号码:家庭住址:联系电话:其他人联系电话:
 * 
 * 如:
 * msg:01001001189:12345678:1000:2000:01001001189:1000:0:Tom:1234567890:济南市山大路:5520336:5523716
 */

public class Account implements Serializable {
	
	private static final long serialVersionUID = 3733205033964499862L;

	private String headMsg = ""; // 头信息
	private String accounts = ""; // 账户
	private String passWord = ""; // 密码
	private String depositMoney = ""; // 余额
	private String withdrawMoney = ""; // 取款金额
	private String transferId = ""; // 转账账户
	private String transferMoney = ""; // 转账金额
	private String exitTag = ""; // 退出标记

	private String userName = ""; // 用户名
	private String cardID = ""; // 身份证号
	private String address = ""; // 家庭住址
	private String selfPhone = ""; // 联系电话
	private String othersPhone = ""; // 其他联系方式

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getCardID() {
		return cardID;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setSelfPhone(String selfPhone) {
		this.selfPhone = selfPhone;
	}

	public String getSelfPhone() {
		return selfPhone;
	}

	public void setOthersPhone(String othersPhone) {
		this.othersPhone = othersPhone;
	}

	public String getOthersPhone() {
		return othersPhone;
	}

	public String getHeadMsg() {
		return headMsg;
	}

	public void setHeadMsg(String headMsg) {
		this.headMsg = headMsg;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(String depositMoney) {
		this.depositMoney = depositMoney;
	}

	public String getExitTag() {
		return exitTag;
	}

	public void setExitTag(String exitTag) {
		this.exitTag = exitTag;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getTransferMoney() {
		return transferMoney;
	}

	public void setTransferMoney(String transferMoney) {
		this.transferMoney = transferMoney;
	}

	public String getWithdrawMoney() {
		return withdrawMoney;
	}

	public void setWithdrawMoney(String withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	@Override
	public String toString() {
		/**
		 * login:username:password:::::::::::::; =====>ATMUtil.
		 */
		return headMsg + ":" + accounts + ":" + passWord + ":" + depositMoney + ":" + withdrawMoney + ":" + transferId
				+ ":" + transferMoney + ":" + exitTag + ":" + userName + ":" + cardID + ":" + address + ":" + selfPhone
				+ ":" + othersPhone;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		Account acc1 = (Account) obj;
		if ((acc1.getAccounts()).equals(this.getAccounts())) // 指定：如果两个Account对象账号相等，就是一个对象。
			return true;
		else
			return false;
	}
	
}