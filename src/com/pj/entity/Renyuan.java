package com.pj.entity;

import java.util.Date;

public class Renyuan {
	
	private int renyuanid;
	
    private String openid;

    private String name;

    private Integer sex;

    private String phone;

    private String chengshi;

    private String pinpai;

    private String zhuangui;

    private String danyuancode;

    private String danyuanmc;

    
    
    private String username;

    private String password;
    
    private int gangweiId; 
    
    private String gangweimc;

    private Date createtime;

    private Integer zhuangtai;

    private String zhuangtaimc;

    private Integer shanchu;

    private String beizhu;

	public Renyuan(int renyuanid, String openid, String name, Integer sex, String phone, String chengshi, String pinpai,
			String zhuangui, String danyuancode, String danyuanmc, String username, String password, String gangweimc,
			Date createtime, Integer zhuangtai, String zhuangtaimc, Integer shanchu, String beizhu) {
		super();
		this.renyuanid = renyuanid;
		this.openid = openid;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.chengshi = chengshi;
		this.pinpai = pinpai;
		this.zhuangui = zhuangui;
		this.danyuancode = danyuancode;
		this.danyuanmc = danyuanmc;
		this.username = username;
		this.password = password;
		this.gangweimc = gangweimc;
		this.createtime = createtime;
		this.zhuangtai = zhuangtai;
		this.zhuangtaimc = zhuangtaimc;
		this.shanchu = shanchu;
		this.beizhu = beizhu;
	}

	public Renyuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Renyuan [renyuanid=" + renyuanid + ", openid=" + openid + ", name=" + name + ", sex=" + sex + ", phone="
				+ phone + ", chengshi=" + chengshi + ", pinpai=" + pinpai + ", zhuangui=" + zhuangui + ", danyuancode="
				+ danyuancode + ", danyuanmc=" + danyuanmc + ", username=" + username + ", password=" + password
				+ ", gangweimc=" + gangweimc + ", createtime=" + createtime + ", zhuangtai=" + zhuangtai
				+ ", zhuangtaimc=" + zhuangtaimc + ", shanchu=" + shanchu + ", beizhu=" + beizhu + "]";
	}

	public int getRenyuanid() {
		return renyuanid;
	}

	public void setRenyuanid(int renyuanid) {
		this.renyuanid = renyuanid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getChengshi() {
		return chengshi;
	}

	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}

	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	public String getZhuangui() {
		return zhuangui;
	}

	public void setZhuangui(String zhuangui) {
		this.zhuangui = zhuangui;
	}

	public String getDanyuancode() {
		return danyuancode;
	}

	public void setDanyuancode(String danyuancode) {
		this.danyuancode = danyuancode;
	}

	public String getDanyuanmc() {
		return danyuanmc;
	}

	public void setDanyuanmc(String danyuanmc) {
		this.danyuanmc = danyuanmc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGangweimc() {
		return gangweimc;
	}

	public void setGangweimc(String gangweimc) {
		this.gangweimc = gangweimc;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(Integer zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public String getZhuangtaimc() {
		return zhuangtaimc;
	}

	public void setZhuangtaimc(String zhuangtaimc) {
		this.zhuangtaimc = zhuangtaimc;
	}

	public Integer getShanchu() {
		return shanchu;
	}

	public void setShanchu(Integer shanchu) {
		this.shanchu = shanchu;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
    
    

    

	public int getGangweiId() {
		return gangweiId;
	}

	public void setGangweiId(int gangweiId) {
		this.gangweiId = gangweiId;
	}
    
}