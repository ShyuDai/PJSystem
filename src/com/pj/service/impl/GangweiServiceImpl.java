package com.pj.service.impl;

import java.util.List;

import com.pj.dao.GangweiDao;
import com.pj.dao.PowerDao;
import com.pj.dao.impl.GangweiDaoImpl;
import com.pj.dao.impl.PowerDaoImpl;
import com.pj.entity.GangWei;
import com.pj.entity.Power;
import com.pj.service.GangweiService;

public class GangweiServiceImpl implements GangweiService {
	GangweiDao dao = new GangweiDaoImpl();
	PowerDao pdao=new PowerDaoImpl();

	@Override
	public boolean add(GangWei gangwei) {
		return dao.add(gangwei);
	}

	@Override
	public boolean delete(int gangweiid) {
		return dao.delete(gangweiid);
	}

	@Override
	public List<GangWei> getGangweis() {
		return dao.getGangweis();
	}

	

	@Override
	public boolean updateName(String gangwei, String bumen, int gangweiid) {
		return dao.updateName(gangwei, bumen, gangweiid);
	}

	@Override
	public GangWei gatGangweiById(int gangweiid) {
		return dao.gatGangweiById(gangweiid);
	}

	@Override
	public List<Power> getPowerByGangweiId(int gangweiid) {
		return pdao.getPowerByGangweiId(gangweiid);
	}

	@Override
	public boolean addpower(int gangweiid) {
		return pdao.addpower(gangweiid);
	}

	@Override
	public boolean updatepower(int gangweiset, String str, int gangweiid) {
		return pdao.updatepower(gangweiset, str, gangweiid);
	}

	



}
