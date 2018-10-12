package com.pj.dao;

import java.util.List;

import com.pj.entity.Renyuan;


public interface RenYuanDao {
	
	public List<Renyuan> getRenYuanListByDanYuanCode(String danYuanCode);
	
}
