package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.GangweiDao;
import com.pj.entity.GangWei;
import com.pj.util.DBConnectionUtil;

public class GangweiDaoImpl implements GangweiDao {

	@Override
	public boolean add(GangWei gangwei) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "INSERT into gangweiinfo (gangwei,bumen) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gangwei.getGangwei());
			ps.setString(2, gangwei.getBumen());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return flag;
	}

	@Override
	public boolean delete(int gangweiid) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "delete from gangweiinfo where gangweiid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gangweiid);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return flag;
	}

	@Override
	public boolean updateName(String gangwei, String bumen, int gangweiid) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "update gangweiinfo set gangwei=?,bumen=? where gangweiid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gangwei);
			ps.setString(2, bumen);
			ps.setInt(3, gangweiid);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return flag;
	}

	@Override
	public GangWei gatGangweiById(int gangweiid) {
		GangWei gangWei=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from gangweiinfo where gangweiid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gangweiid);
			// 执行一个sql 语句返回结果集
			rs = ps.executeQuery();
			if (rs.next()) {
				gangWei =new GangWei();
				gangWei.setGangweiid(rs.getInt("gangweiid"));
				gangWei.setGangwei(rs.getString("gangwei"));
				gangWei.setBumen(rs.getString("bumen"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}

		return gangWei;
	}

	@Override
	public List<GangWei> getGangweis() {
		List<GangWei> gangWeis=new ArrayList<GangWei>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from gangweiinfo";
			ps = conn.prepareStatement(sql);
			// 执行一个sql 语句返回结果集
			rs = ps.executeQuery();
			while (rs.next()) {
				GangWei gangWei =new GangWei();
				gangWei.setGangweiid(rs.getInt("gangweiid"));
				gangWei.setGangwei(rs.getString("gangwei"));
				gangWei.setBumen(rs.getString("bumen"));
				gangWeis.add(gangWei);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		
		return gangWeis;
	}

	
}






