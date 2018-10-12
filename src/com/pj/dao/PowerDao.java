package com.pj.dao;

import java.util.List;

import com.pj.entity.Power;

public interface PowerDao {
	public List<Power> getPowerByGangweiId(int gangweiid);
	public boolean addpower(int gangweiid);
	public boolean updatepower(int gangweiset,String str, int gangweiid);

}
