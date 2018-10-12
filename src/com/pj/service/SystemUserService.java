package com.pj.service;


import java.util.List;

import com.pj.entity.Danyuan;
import com.pj.entity.PageHelperDataResult;
import com.pj.entity.Renyuan;

public interface SystemUserService {
	
	//获取评价记录表所有信息，返回每页10条信息，分页显示
	PageHelperDataResult getAllPingjiajiluOfGuWenMingXiChaXun(int page,int rows,String sql);
	
	//获取评价记录表满意与不满意的所有信息，分页显示
	PageHelperDataResult getAllPingjiajiluOfGuWenChaXun(int page, int rows,String sql);

	PageHelperDataResult getAllPingjiajiluOfGuKeChaXun(int page, int rows,String sql);

	List<Danyuan> AjaxGetChengShi();

	List<Danyuan> AjaxGetPinPai(String method);

	List<Danyuan> AjaxGetZhuanGui(String method);

	String getNameByCode(String codeStr);


	Renyuan getRenyuanByRenyuanid(String sql);

	int addPingJiaJiLu(String sql2);


	public Renyuan getRenYuanByUsernameAndPassword(String username,String password);

}
