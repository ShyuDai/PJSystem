package com.pj.service;

import java.util.List;

import com.pj.entity.Rizhi;
import com.pj.util.PageBean;

public interface RizhiService {
	
	public List<Rizhi> getAllRizhiList();
	
	public boolean saveRizhi(Rizhi rizhi);
	
	public List<Rizhi> getRizhiListPage(int pageNO,int pageSize);//获取当前分页
	
	public int deleteRizhiByRizhiId(int rizhiid);

}
