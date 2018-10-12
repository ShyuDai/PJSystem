package com.pj.service;

import java.util.List;

import com.pj.entity.GangWei;
import com.pj.entity.Power;

public interface GangweiService {
	public boolean add(GangWei gangwei);
	public boolean delete(int gangweiid);
	public boolean updateName(String gangwei,String bumen,int gangweiid);
	public GangWei gatGangweiById(int gangweiid);
	public List<GangWei> getGangweis();
	
	
	public List<Power> getPowerByGangweiId(int gangweiid);
	public boolean addpower(int gangweiid);
	public boolean updatepower(int gangweiset,String str, int gangweiid);

}
