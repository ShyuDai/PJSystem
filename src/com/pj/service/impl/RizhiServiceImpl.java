package com.pj.service.impl;

import java.util.List;

import com.pj.dao.RizhiDao;
import com.pj.dao.impl.RizhiDaoImpl;
import com.pj.entity.Rizhi;
import com.pj.service.RizhiService;
import com.pj.util.PageBean;

public class RizhiServiceImpl implements RizhiService{

	private RizhiDao rizhiDao=new RizhiDaoImpl();
	
	@Override
	public List<Rizhi> getAllRizhiList() {
		// TODO Auto-generated method stub
		return rizhiDao.getAllRizhiList();
	}
	
	@Override
	public List<Rizhi> getRizhiListPage(int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		return rizhiDao.getRizhiListPage(pageNO, pageSize);
	}

	@Override
	public int deleteRizhiByRizhiId(int rizhiid) {
		// TODO Auto-generated method stub
		return rizhiDao.deleteRizhiByRizhiId(rizhiid);
	}

	@Override
	public boolean saveRizhi(Rizhi rizhi) {
		// TODO Auto-generated method stub
		return rizhiDao.saveRizhi(rizhi);
	}

}
