package com.pj.service.impl;

import java.util.List;

import com.pj.dao.DanYuanDao;
import com.pj.dao.impl.DanYuanDaoImpl;
import com.pj.entity.Danyuan;
import com.pj.service.DanYuanService;


public class DanYuanServiceImpl implements DanYuanService {
	private DanYuanDao danYuanDao = new DanYuanDaoImpl();
	
	@Override
	public List<Danyuan> getCityList() {
		return danYuanDao.getCityList();
	}

	@Override
	public List<Danyuan> getDanYuanListByParentCode(String parentCode) {
		return danYuanDao.getDanYuanListByParentCode(parentCode);
	}

}
