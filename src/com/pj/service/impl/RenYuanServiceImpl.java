package com.pj.service.impl;

import java.util.List;

import com.pj.dao.RenYuanDao;
import com.pj.dao.impl.RenYuanDaoImpl;
import com.pj.entity.Renyuan;
import com.pj.service.RenYuanService;

public class RenYuanServiceImpl implements RenYuanService {
	private RenYuanDao renYuanDao = new RenYuanDaoImpl();
	
	@Override
	public List<Renyuan> getRenYuanListByDanYuanCode(String danYuanCode) {
		return renYuanDao.getRenYuanListByDanYuanCode(danYuanCode);
	}
	
}
