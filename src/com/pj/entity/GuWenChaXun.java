package com.pj.entity;

public class GuWenChaXun {
	
	private Integer guwenchaxunid;
	private String pinpai;
	private String chengshi;
	private String zhuangui;
	private String renyuanmc;
	private Integer manyi;
	private String openid;
	private Integer bumanyi;
	
	
	public GuWenChaXun(Integer guwenchaxunid, String pinpai, String chengshi, String zhuangui, String renyuanmc,
			Integer manyi, String openid, Integer bumanyi) {
		super();
		this.guwenchaxunid = guwenchaxunid;
		this.pinpai = pinpai;
		this.chengshi = chengshi;
		this.zhuangui = zhuangui;
		this.renyuanmc = renyuanmc;
		this.manyi = manyi;
		this.openid = openid;
		this.bumanyi = bumanyi;
	}
	public GuWenChaXun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getGuwenchaxunid() {
		return guwenchaxunid;
	}
	public void setGuwenchaxunid(Integer guwenchaxunid) {
		this.guwenchaxunid = guwenchaxunid;
	}
	public String getPinpai() {
		return pinpai;
	}
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	public String getChengshi() {
		return chengshi;
	}
	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}
	public String getZhuangui() {
		return zhuangui;
	}
	public void setZhuangui(String zhuangui) {
		this.zhuangui = zhuangui;
	}
	public String getRenyuanmc() {
		return renyuanmc;
	}
	public void setRenyuanmc(String renyuanmc) {
		this.renyuanmc = renyuanmc;
	}
	public Integer getManyi() {
		return manyi;
	}
	public void setManyi(Integer manyi) {
		this.manyi = manyi;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getBumanyi() {
		return bumanyi;
	}
	public void setBumanyi(Integer bumanyi) {
		this.bumanyi = bumanyi;
	}
	@Override
	public String toString() {
		return "GuWenChaXun [guwenchaxunid=" + guwenchaxunid + ", pinpai=" + pinpai + ", chengshi=" + chengshi
				+ ", zhuangui=" + zhuangui + ", renyuanmc=" + renyuanmc + ", manyi=" + manyi + ", openid=" + openid
				+ ", bumanyi=" + bumanyi + "]";
	}
	
	
	
	
	
	
	
	
	

}
