package com.pj.entity;

import java.util.Date;

public class Pingjiajilu {
    private Integer pingjiajiluid;

    private String openid;

    private String chengshi;

    private String pinpai;

    private String zhuangui;

    private String phone;

    private Integer renyuanid;

    private String renyuanmc;

    private String jingdu;

    private String weidu;

    private Integer leixing;

    private Date createtime;
    
    

    public Pingjiajilu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pingjiajilu(Integer pingjiajiluid, String openid, String chengshi, String pinpai, String zhuangui,
			String phone, Integer renyuanid, String renyuanmc, String jingdu, String weidu, Integer leixing,
			Date createtime) {
		super();
		this.pingjiajiluid = pingjiajiluid;
		this.openid = openid;
		this.chengshi = chengshi;
		this.pinpai = pinpai;
		this.zhuangui = zhuangui;
		this.phone = phone;
		this.renyuanid = renyuanid;
		this.renyuanmc = renyuanmc;
		this.jingdu = jingdu;
		this.weidu = weidu;
		this.leixing = leixing;
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Pingjiajilu [pingjiajiluid=" + pingjiajiluid + ", openid=" + openid + ", chengshi=" + chengshi
				+ ", pinpai=" + pinpai + ", zhuangui=" + zhuangui + ", phone=" + phone + ", renyuanid=" + renyuanid
				+ ", renyuanmc=" + renyuanmc + ", jingdu=" + jingdu + ", weidu=" + weidu + ", leixing=" + leixing
				+ ", createtime=" + createtime + "]";
	}

	public Integer getPingjiajiluid() {
        return pingjiajiluid;
    }

    public void setPingjiajiluid(Integer pingjiajiluid) {
        this.pingjiajiluid = pingjiajiluid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getChengshi() {
        return chengshi;
    }

    public void setChengshi(String chengshi) {
        this.chengshi = chengshi == null ? null : chengshi.trim();
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai == null ? null : pinpai.trim();
    }

    public String getZhuangui() {
        return zhuangui;
    }

    public void setZhuangui(String zhuangui) {
        this.zhuangui = zhuangui == null ? null : zhuangui.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRenyuanid() {
        return renyuanid;
    }

    public void setRenyuanid(Integer renyuanid) {
        this.renyuanid = renyuanid;
    }

    public String getRenyuanmc() {
        return renyuanmc;
    }

    public void setRenyuanmc(String renyuanmc) {
        this.renyuanmc = renyuanmc == null ? null : renyuanmc.trim();
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu == null ? null : jingdu.trim();
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu == null ? null : weidu.trim();
    }

    public Integer getLeixing() {
        return leixing;
    }

    public void setLeixing(Integer leixing) {
        this.leixing = leixing;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}