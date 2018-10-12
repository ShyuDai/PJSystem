package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pj.dao.SystemUserDao;
import com.pj.entity.Danyuan;
import com.pj.entity.GuWenChaXun;
import com.pj.entity.PageHelperDataResult;
import com.pj.entity.Pingjiajilu;
import com.pj.entity.Renyuan;
import com.pj.service.SystemUserService;
import com.pj.service.impl.SystemUserServiceImpl;
import com.pj.util.DBConnectionUtil;

public class SystemUserDaoImpl implements SystemUserDao {
	boolean flag = false;
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	/**
	 * 顾问明细查询
	 */
	@Override
	public List<Pingjiajilu> getAllPingjiajiluOfGuWenMingXiChaXun(int page, int rows, String sql) {
		List<Pingjiajilu> list = new ArrayList<>();
		Pingjiajilu pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			st = conn.prepareStatement(sql);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new Pingjiajilu();
				pjjl.setPingjiajiluid(rs.getInt("pingjiajiluid"));
				pjjl.setChengshi(rs.getString("chengshi"));
				pjjl.setPinpai(rs.getString("pinpai"));
				pjjl.setZhuangui(rs.getString("zhuangui"));
				pjjl.setOpenid(rs.getString("openid"));
				pjjl.setRenyuanmc(rs.getString("renyuanmc"));
				pjjl.setJingdu(rs.getString("jingdu"));
				pjjl.setWeidu(rs.getString("weidu"));
				pjjl.setCreatetime(rs.getDate("createtime"));
				pjjl.setLeixing(rs.getInt("leixing"));// 是否满意：1--满意，0--不满意。
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	@Override
	public long getCountAllPingjiajilu() {
		long count = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select count(*) from pingjiajilu";
			st = conn.prepareStatement(sql);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			/*
			 * while(rs.next()) { count=rs.getInt(1); }
			 */
			rs.next();
			count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return count;
	}

	@Test
	public void syso1() {
		long result = getCountAllPingjiajilu();
//		System.out.println(result);
	}

	/**
	 * 顾问查询 返回 品牌、城市、专柜、柜台顾问
	 */
	@Override
	public List<GuWenChaXun> getAllPingjiajiluOfGuWenChaXun(String sql) {
		List<GuWenChaXun> list = new ArrayList<>();
		GuWenChaXun pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
//			String sql = "select * from pingjiajilu group by renyuanmc";
			st = conn.prepareStatement(sql);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new GuWenChaXun();
				pjjl.setPinpai(rs.getString("pinpai"));
				pjjl.setChengshi(rs.getString("chengshi"));
				pjjl.setZhuangui(rs.getString("zhuangui"));
				pjjl.setRenyuanmc(rs.getString("renyuanmc"));
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	/**
	 * 根据柜台顾问的名字 统计满意的记录数
	 */
	@Override
	public Integer getAllManYiByrenyuanmv(String renyuanname, int leixing) {
		Integer count = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select count(*) from pingjiajilu where renYuanMC=? and leiXing=?";
			st = conn.prepareStatement(sql);
			// 参数赋值
			st.setString(1, renyuanname);
			st.setInt(2, leixing);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return count;
	}

	/**
	 * 统计柜台顾问的人数
	 */
	@Override
	public long getCountAllrenyuanmc() {
		long count = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select count(*) from pingjiajilu group by renYuanMC";
			st = conn.prepareStatement(sql);
			// 参数赋值
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				count = count + 1;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return count;
	}

	/**
	 * 查询所有openid 返回 pinPai,chengShi,zhuanGui,openId
	 */
	@Override
	public List<GuWenChaXun> getAllPingjiajiluOfGuKeChaXun(String sql) {
		List<GuWenChaXun> list = new ArrayList<>();
		GuWenChaXun pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
//			String sql = "select pinPai,chengShi,zhuanGui,openId from pingjiajilu group by openId";
			st = conn.prepareStatement(sql);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new GuWenChaXun();
				pjjl.setPinpai(rs.getString("pinpai"));
				pjjl.setChengshi(rs.getString("chengshi"));
				pjjl.setZhuangui(rs.getString("zhuangui"));
				pjjl.setOpenid(rs.getString("openid"));
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	@Override
	public Integer getAllManYiByopenid(String openid, int i) {
		Integer count = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select count(*) from pingjiajilu where openId=? and leiXing=?";
			st = conn.prepareStatement(sql);
			// 参数赋值
			st.setString(1, openid);
			st.setInt(2, i);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return count;
	}

	/**
	 * 统计openid的个数
	 */
	@Override
	public long getCountAllopenid() {
		long count = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select count(*) from pingjiajilu group by openId";
			st = conn.prepareStatement(sql);
			// 参数赋值
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				count = count + 1;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return count;
	}

	/**
	 * Ajax获取城市名称
	 */
	@Override
	public List<Danyuan> AjaxGetChengShi() {
		List<Danyuan> list = new ArrayList<>();
		Danyuan pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select name,code,parentCode from danyuan where parentCode is null";
			st = conn.prepareStatement(sql);
			// 参数赋值
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new Danyuan();
				pjjl.setCode(rs.getString("code"));
				pjjl.setParentcode(rs.getString("parentcode"));
				pjjl.setName(rs.getString("name"));
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	@Override
	public List<Danyuan> AjaxGetPinPai(String method) {
		List<Danyuan> list = new ArrayList<>();
		Danyuan pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select name,code,parentCode from danyuan where parentCode=?";
			st = conn.prepareStatement(sql);
			// 参数赋值
			st.setString(1, method);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new Danyuan();
				pjjl.setCode(rs.getString("code"));
				pjjl.setParentcode(rs.getString("parentcode"));
				pjjl.setName(rs.getString("name"));
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	@Override
	public List<Danyuan> AjaxGetZhuanGui(String method) {
		List<Danyuan> list = new ArrayList<>();
		Danyuan pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select name,code,parentCode from danyuan where parentCode=?";
			st = conn.prepareStatement(sql);
			// 参数赋值
			st.setString(1, method);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			while (rs.next()) {
				pjjl = new Danyuan();
				pjjl.setCode(rs.getString("code"));
				pjjl.setParentcode(rs.getString("parentcode"));
				pjjl.setName(rs.getString("name"));
				list.add(pjjl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return list;
	}

	/**
	 * 在danyuan表中 根据code返回name
	 */
	@Override
	public String getNameByCode(String codeStr) {
		Danyuan pjjl = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "select name from danyuan where code=?";
			st = conn.prepareStatement(sql);
			// 参数赋值
			st.setString(1, codeStr);
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			int count = 0;
			while (rs.next()) {
				pjjl = new Danyuan();
				pjjl.setName(rs.getString("name"));
				count = count + 1;
			}

			if (count == 0) {
				return null;
			} else {
				return pjjl.getName();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return pjjl.getName();
	}

	@Override
	public Renyuan getRenyuanByRenyuanid(String sql) {
		Renyuan ry = null;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			st = conn.prepareStatement(sql);
			// 参数赋值
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
			// 返回属性：chengShi、pinPai、zhuanGui、renYuanId、renYuanMC
			while (rs.next()) {
				ry = new Renyuan();
				ry.setChengshi(rs.getString("chengshi"));
				ry.setPinpai(rs.getString("pinpai"));
				ry.setZhuangui(rs.getString("zhuangui"));
				ry.setRenyuanid(rs.getInt("renyuanid"));
				ry.setName(rs.getString("name"));
			}
			return ry;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return ry;
	}

	@Override
	public int addPingJiaJiLu(String sql2) {
		int result = 0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			st = conn.prepareStatement(sql2);
			// 4.处理数据库的返回结果
			result = st.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return result;
	}

}
