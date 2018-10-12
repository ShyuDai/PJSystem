package com.pj.dao;

import java.util.List;

import com.pj.entity.Danyuan;
import com.pj.entity.GuWenChaXun;
import com.pj.entity.Pingjiajilu;
import com.pj.entity.Renyuan;

public interface SystemUserDao {

	List<Pingjiajilu> getAllPingjiajiluOfGuWenMingXiChaXun(int page,int rows,String sql);

	long getCountAllPingjiajilu();

	List<GuWenChaXun> getAllPingjiajiluOfGuWenChaXun(String sql);

	Integer getAllManYiByrenyuanmv(String renyuanname,int leixing);

	long getCountAllrenyuanmc();

	List<GuWenChaXun> getAllPingjiajiluOfGuKeChaXun(String sql);

	Integer getAllManYiByopenid(String openid, int i);

	long getCountAllopenid();

	List<Danyuan> AjaxGetChengShi();

	List<Danyuan> AjaxGetPinPai(String method);

	List<Danyuan> AjaxGetZhuanGui(String method);

	String getNameByCode(String codeStr);

	Renyuan getRenyuanByRenyuanid(String sql);

	int addPingJiaJiLu(String sql2);


}
