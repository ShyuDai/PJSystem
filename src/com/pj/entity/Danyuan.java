package com.pj.entity;

public class Danyuan {
	
    private Integer danyuanid;

    private String name;

    private String dizhi;

    private String code;

    private String parentcode;
    
    
    
    

    public Danyuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Danyuan(Integer danyuanid, String name, String dizhi, String code, String parentcode) {
		super();
		this.danyuanid = danyuanid;
		this.name = name;
		this.dizhi = dizhi;
		this.code = code;
		this.parentcode = parentcode;
	}

	@Override
	public String toString() {
		return "Danyuan [danyuanid=" + danyuanid + ", name=" + name + ", dizhi=" + dizhi + ", code=" + code
				+ ", parentcode=" + parentcode + "]";
	}

	public Integer getDanyuanid() {
        return danyuanid;
    }

    public void setDanyuanid(Integer danyuanid) {
        this.danyuanid = danyuanid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode == null ? null : parentcode.trim();
    }
}