/**
 * 
 */
package com.pj.dao;

import java.util.List;

import com.pj.entity.Rizhi;

/**
 * @author MarviyZoern
 *
 */
public interface RizhiDao {
	
	public boolean saveRizhi(Rizhi rizhi);
	
	public List<Rizhi> getAllRizhiList();
	
	public List<Rizhi> getRizhiListPage(int pageNO,int pageSize);//获取当前分页
	
	public int deleteRizhiByRizhiId(int rizhiid);
 }
