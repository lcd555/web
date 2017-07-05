package cn.zkingsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Menus;


public class MenusDaoImpl implements MenusDao {

	@Override
	public boolean addMenus(Menus m) {
		Connection conn = DBHelper.getConnection();
		String sql="insert into Menus(title,url,supId) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getTitle());
			ps.setString(2, m.getUrl());
			ps.setInt(3, m.getSupId());
			int count = ps.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean deleteMenus(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMenus(Menus m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Menus> selectAllMenus() {
		List<Menus> list = new ArrayList<Menus>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from menus";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Menus m = new Menus();
				m.setId(rs.getInt("id"));
				m.setSupId(rs.getInt("supId"));
				m.setTitle(rs.getString("title"));
				m.setUrl(rs.getString("url"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	

	@Override
	public Menus getMenusById(int id) {
		Menus menus = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from users where menusid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				menus = new Menus();
				menus.setId(rs.getInt("id"));
				menus.setSupId(rs.getInt("supId"));
				menus.setTitle(rs.getString("title"));
				menus.setUrl(rs.getString("url"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return menus;
	}

}
