package com.pj.service;

import java.util.List;

import com.pj.entity.Renyuan;


public interface RenYuanService {
	
	public List<Renyuan> getRenYuanListByDanYuanCode(String danYuanCode);
	
}
