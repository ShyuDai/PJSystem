package com.pj.entity;

import java.sql.Date;

public class Rizhi {
    private Integer rizhiid;

    private String link;

    private String name;

    private String description;

    private Date createtime;

    private Integer dianmianid;

    private String danyuanmc;

    private Integer caozuoryid;

    private String caozuorymc;
    
    

    public Rizhi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rizhi(Integer rizhiid, String link, String name, String description, Date createtime, Integer dianmianid,
			String danyuanmc, Integer caozuoryid, String caozuorymc) {
		super();
		this.rizhiid = rizhiid;
		this.link = link;
		this.name = name;
		this.description = description;
		this.createtime = createtime;
		this.dianmianid = dianmianid;
		this.danyuanmc = danyuanmc;
		this.caozuoryid = caozuoryid;
		this.caozuorymc = caozuorymc;
	}

	@Override
	public String toString() {
		return "Rizhi [rizhiid=" + rizhiid + ", link=" + link + ", name=" + name + ", description=" + description
				+ ", createtime=" + createtime + ", dianmianid=" + dianmianid + ", danyuanmc=" + danyuanmc
				+ ", caozuoryid=" + caozuoryid + ", caozuorymc=" + caozuorymc + "]";
	}

	public Integer getRizhiid() {
        return rizhiid;
    }

    public void setRizhiid(Integer rizhiid) {
        this.rizhiid = rizhiid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDianmianid() {
        return dianmianid;
    }

    public void setDianmianid(Integer dianmianid) {
        this.dianmianid = dianmianid;
    }

    public String getDanyuanmc() {
        return danyuanmc;
    }

    public void setDanyuanmc(String danyuanmc) {
        this.danyuanmc = danyuanmc == null ? null : danyuanmc.trim();
    }

    public Integer getCaozuoryid() {
        return caozuoryid;
    }

    public void setCaozuoryid(Integer caozuoryid) {
        this.caozuoryid = caozuoryid;
    }

    public String getCaozuorymc() {
        return caozuorymc;
    }

    public void setCaozuorymc(String caozuorymc) {
        this.caozuorymc = caozuorymc == null ? null : caozuorymc.trim();
    }
}