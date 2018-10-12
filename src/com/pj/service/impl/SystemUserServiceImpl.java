package com.pj.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pj.dao.LoginDao;
import com.pj.dao.SystemUserDao;
import com.pj.dao.impl.LoginDaoImpl;
import com.pj.dao.impl.SystemUserDaoImpl;
import com.pj.entity.Danyuan;
import com.pj.entity.GuWenChaXun;
import com.pj.entity.PageHelperDataResult;
import com.pj.entity.Pingjiajilu;
import com.pj.entity.Renyuan;
import com.pj.service.SystemUserService;

public class SystemUserServiceImpl implements SystemUserService {

	private SystemUserDao sud = new SystemUserDaoImpl();
	private LoginDao dao=new LoginDaoImpl();

	/**
	 * 顾问明细查询
	 */
	@Override
	public PageHelperDataResult getAllPingjiajiluOfGuWenMingXiChaXun(int page, int rows,String sql) {
		// 分页处理
		List<Pingjiajilu> list = sud.getAllPingjiajiluOfGuWenMingXiChaXun(page, rows,sql);
		List<Pingjiajilu> newlist = new ArrayList<>();
		int start = (page - 1) * rows;
		int end = rows+start;
		if(end>list.size()) {
			end=list.size();
		}
		Pingjiajilu gwcx=new Pingjiajilu();
		for(int i=start;i<end;i++) {
			gwcx=list.get(i);
			newlist.add(gwcx);
		}
		// 创建一个返回值对象
		PageHelperDataResult result = new PageHelperDataResult();
		result.setRows(newlist);
		// 取记录总条数
//		long count = sud.getCountAllPingjiajilu();
		long count = list.size();
//		System.out.println(count);
		result.setTotal(count);
		//当前页
		result.setCurrentPage(page);
		//总计页数
		result.setTotalPage((count+rows-1)/rows);
		//每页数据条数
		result.setPageSize(rows);
		
		return result;

	}

	/**
	 * 顾问查询
	 */
	@Override
	public PageHelperDataResult getAllPingjiajiluOfGuWenChaXun(int page, int rows,String sql) {
		// 分页处理
		List<GuWenChaXun> list = sud.getAllPingjiajiluOfGuWenChaXun(sql);
		List<GuWenChaXun> newlist = new ArrayList<>();
		int start = (page - 1) * rows;
		int end = rows+start;
		if(end>list.size()) {
			end=list.size();
		}
		GuWenChaXun gwcx=new GuWenChaXun();
		for(int i=start;i<end;i++) {
			gwcx=list.get(i);
			String renyuanname = gwcx.getRenyuanmc();//获取柜员名称
			// 满意次数
			Integer manyi = sud.getAllManYiByrenyuanmv(renyuanname, 1);
			gwcx.setManyi(manyi);
			// 不满意次数
			Integer bumanyi = sud.getAllManYiByrenyuanmv(renyuanname, 0);
			gwcx.setBumanyi(bumanyi);
			newlist.add(gwcx);
		}
		// 创建一个返回值对象
		PageHelperDataResult result = new PageHelperDataResult();
//		System.out.println("newlist---"+newlist.size());
		result.setRows(newlist);
		// 取记录总条数
		long count = list.size();
		result.setTotal(count);
		//每页数据条数
		result.setPageSize(rows);
		//当前页
		result.setCurrentPage(page);
		//总计页数
		result.setTotalPage((count+rows-1)/rows);
		return result;
	}

	/**
	 * 顾客查询
	 */
	@Override
	public PageHelperDataResult getAllPingjiajiluOfGuKeChaXun(int page, int rows,String sql) {
		// 分页处理
		List<GuWenChaXun> list = sud.getAllPingjiajiluOfGuKeChaXun(sql);
//		System.out.println("list---"+list.size());
		List<GuWenChaXun> newlist = new ArrayList<>();
		int start = (page - 1) * rows;
		int end = rows+start;
		if(end>list.size()) {
			end=list.size();
		}
		GuWenChaXun gwcx=new GuWenChaXun();
		for(int i=start;i<end;i++) {
			gwcx=list.get(i);
			String openid = gwcx.getOpenid();
			// 满意次数
			Integer manyi = sud.getAllManYiByopenid(openid, 1);
			gwcx.setManyi(manyi);
			// 不满意次数
			Integer bumanyi = sud.getAllManYiByopenid(openid, 0);
			gwcx.setBumanyi(bumanyi);
			newlist.add(gwcx);
		}
			
			// 创建一个返回值对象
			PageHelperDataResult result = new PageHelperDataResult();
			result.setRows(newlist);
			// 取记录总条数
			long count = list.size();
			result.setTotal(count);
			//当前页
			result.setCurrentPage(page);
			//每页数据条数
			result.setPageSize(rows);
			//总计页数
			result.setTotalPage((count+rows-1)/rows);
			return result;
		}

	

	@Override
	public List<Danyuan> AjaxGetChengShi() {
		return sud.AjaxGetChengShi();
	}

	@Override
	public List<Danyuan> AjaxGetPinPai(String method) {
		return sud.AjaxGetPinPai(method);
	}

	@Override
	public List<Danyuan> AjaxGetZhuanGui(String method) {
		return sud.AjaxGetZhuanGui(method);
	}

	@Override
	public String getNameByCode(String codeStr) {
		return sud.getNameByCode(codeStr);
	}


	@Override
	public Renyuan getRenyuanByRenyuanid(String sql) {
		return sud.getRenyuanByRenyuanid(sql);
	}

	@Override
	public int addPingJiaJiLu(String sql2) {
		return sud.addPingJiaJiLu(sql2);
	}

	


	@Override
	public Renyuan getRenYuanByUsernameAndPassword(String username, String password) {
		
		return dao.getRenYuanByUsernameAndPassword(username, password);
	}

}
