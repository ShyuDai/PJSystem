package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pj.dao.DanYuanDao;
import com.pj.entity.Danyuan;
import com.pj.entity.Renyuan;
import com.pj.util.DBConnectionUtil;

public class DanYuanDaoImpl implements DanYuanDao {

	@Override
	public List<Danyuan> getCityList() {
		List<Danyuan> danYuanList = new ArrayList<Danyuan>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from danyuan where parentCode is null";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Danyuan danYuan = new Danyuan();
				danYuan.setDanyuanid(rs.getInt("danyuanid"));
				danYuan.setCode(rs.getString("code"));
				danYuan.setDizhi(rs.getString("dizhi"));
				danYuan.setName(rs.getString("name"));
				danYuan.setParentcode(rs.getString("parentcode"));
				danYuanList.add(danYuan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		return danYuanList;
	}

	@Override
	public List<Danyuan> getDanYuanListByParentCode(String parentCode) {
		List<Danyuan> danYuanList = new ArrayList<Danyuan>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from danyuan where parentCode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentCode);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Danyuan danYuan = new Danyuan();
				danYuan.setDanyuanid(rs.getInt("danYuanId"));
				danYuan.setCode(rs.getString("code"));
				danYuan.setDizhi(rs.getString("diZhi"));
				danYuan.setName(rs.getString("name"));
				danYuan.setParentcode(rs.getString("parentCode"));
				danYuanList.add(danYuan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return danYuanList;
	}

	

}
