package com.pj.dao;

import java.util.List;

import com.pj.entity.Danyuan;
import com.pj.entity.Renyuan;

public interface DanYuanDao {
	public List<Danyuan> getCityList();
	public List<Danyuan> getDanYuanListByParentCode(String parentCode);


}
