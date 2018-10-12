package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.RenYuanDao;
import com.pj.entity.Renyuan;
import com.pj.util.DBConnectionUtil;


public class RenYuanDaoImpl implements RenYuanDao {

	@Override
	public List<Renyuan> getRenYuanListByDanYuanCode(String danYuanCode) {
		List<Renyuan> renYuanList = new ArrayList<Renyuan>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from renyuan where danYuanCode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, danYuanCode);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Renyuan renYuan = new Renyuan();
				renYuan.setRenyuanid(rs.getInt("renyuanid"));
				renYuan.setChengshi(rs.getString("chengshi"));
				renYuan.setPinpai(rs.getString("pinpai"));
				renYuan.setZhuangui(rs.getString("zhuangui"));
				renYuan.setName(rs.getString("name"));
				renYuan.setCreatetime(rs.getDate("createtime"));
				renYuan.setZhuangtai(rs.getInt("zhuangtai"));
				renYuanList.add(renYuan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return renYuanList;
	}

}
