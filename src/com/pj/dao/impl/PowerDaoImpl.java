package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pj.dao.PowerDao;
import com.pj.entity.GangWei;
import com.pj.entity.Power;
import com.pj.util.DBConnectionUtil;

public class PowerDaoImpl implements PowerDao {

	@Override
	public List<Power> getPowerByGangweiId(int gangweiid) {
		List<Power> powers=new ArrayList<Power>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "select * from powerinfo where gangweiid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gangweiid);
			// 执行一个sql 语句返回结果集
			rs = ps.executeQuery();
			while (rs.next()) {
				Power power =new Power();
				power.setGangweiid(rs.getInt("gangweiid"));
				power.setPower(rs.getString("power"));
				power.setSetpower(rs.getInt("setpower"));
				powers.add(power);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}

		return powers;
	}
	@Override
	public boolean addpower(int gangweiid) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "insert into powerinfo (power,setpower,gangweiid) values ('gangweiset',0,"+gangweiid+"),('renyuanset',0,"+gangweiid+"),('syslog',0,"+gangweiid+"),('gwmxselect',0,"+gangweiid+"),('guwenselect',0,"+gangweiid+"),('customerselect',0,"+gangweiid+")";
			ps = conn.prepareStatement(sql);
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
	public boolean updatepower(int gangweiset,String str, int gangweiid) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.getConnection();
			String sql = "update powerinfo set setpower="+gangweiset+" where gangweiid="+gangweiid+" and power='"+str+"'";
			ps = conn.prepareStatement(sql);

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


}
