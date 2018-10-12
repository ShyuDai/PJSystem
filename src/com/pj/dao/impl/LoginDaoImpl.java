package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pj.dao.LoginDao;
import com.pj.entity.Renyuan;
import com.pj.util.DBConnectionUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Renyuan getRenYuanByUsernameAndPassword(String username,String password) {
		Renyuan renyuan = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from renyuan where username='"+username+"' and password='"+password+"'";
			ps = conn.prepareStatement(sql);
			// 执行一个sql 语句返回结果集
			rs = ps.executeQuery();
			if (rs.next()) {
				renyuan=new Renyuan();
				renyuan.setUsername(rs.getString("username"));
				renyuan.setPassword(rs.getString("password"));
				renyuan.setGangweiId(rs.getInt("gangWeiId"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		return renyuan;
	}

}
