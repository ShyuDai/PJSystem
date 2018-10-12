package com.pj.dao;

import java.util.List;

import com.pj.entity.GangWei;

public interface GangweiDao {
	public boolean add(GangWei gangwei);
	public boolean delete(int gangweiid);
	public boolean updateName(String gangwei,String bumen,int gangweiid);
	public GangWei gatGangweiById(int gangweiid);
	public List<GangWei> getGangweis();

}
