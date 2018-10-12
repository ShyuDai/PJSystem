package com.pj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.pj.dao.RizhiDao;
import com.pj.entity.Rizhi;
import com.pj.util.DBConnectionUtil;
import com.pj.util.PageBean;

public class RizhiDaoImpl implements RizhiDao{
	
	@Override
	public boolean saveRizhi(Rizhi rizhi) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="insert into rizhi (rizhiId,link,name,description,createtime,dianmingId,dianyuanMC,caozuoRYId,caozuoRYMC)"
					+ " value (?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rizhi.getRizhiid());
			ps.setString(2, rizhi.getLink());
			ps.setString(3, rizhi.getName());
			ps.setString(4, rizhi.getDescription());
			ps.setDate(5, rizhi.getCreatetime());
			ps.setInt(6, rizhi.getDianmianid());
			ps.setString(7, rizhi.getDanyuanmc());
			ps.setInt(8, rizhi.getCaozuoryid());
			ps.setString(9, rizhi.getCaozuorymc());
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(null, ps, conn);
		}		
		return flag;		
	}

	@Override
	public List<Rizhi> getAllRizhiList() {
		// TODO Auto-generated method stub
		List<Rizhi> rizhiList=new ArrayList<Rizhi>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="SELECT * from rizhi";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Rizhi rizhi=new Rizhi();
				rizhi.setRizhiid(rs.getInt("rizhiId"));
				rizhi.setCreatetime(rs.getDate("createtime"));
				rizhi.setLink(rs.getString("link"));
				rizhi.setName(rs.getString("name"));
				rizhi.setDescription(rs.getString("description"));
				rizhi.setCaozuorymc(rs.getString("caozuorymc"));
				rizhiList.add(rizhi);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		return rizhiList;
	}

	
	@Override
	public List<Rizhi> getRizhiListPage(int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		List<Rizhi> rizhiList=new ArrayList<Rizhi>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="SELECT * from rizhi order by rizhiId asc limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (pageNO-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Rizhi rizhi=new Rizhi();
				rizhi.setRizhiid(rs.getInt("rizhiId"));
				rizhi.setCreatetime(rs.getDate("createtime"));
				rizhi.setLink(rs.getString("link"));
				rizhi.setName(rs.getString("name"));
				rizhi.setDescription(rs.getString("description"));
				rizhi.setCaozuorymc(rs.getString("caozuorymc"));
				rizhiList.add(rizhi);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, ps, conn);
		}
		return rizhiList;
	}

	@Override
	public int deleteRizhiByRizhiId(int rizhiid) {
		// TODO Auto-generated method stub
		int rows=0;
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="delete from rizhi where rizhiid =?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rizhiid);
			rows=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(null, ps, conn);
		}
		
		return rows;
	}

	


}
