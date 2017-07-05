package cn.zkingsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Users;

public class UserDaoImpl implements UserDao{
	/**
	 * 添加用户
	 */
	public boolean addUser(Users u,Connection conn) {
		String sql="insert into users(username,password,status) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getStatus());
			int count = ps.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 *删除用户
	 */
	public boolean deleteUser(int id,Connection conn) {
		String sql = "delete from users where userid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id获得一个用户
	 */
	public Users getUserById(int id,Connection conn) {
		Users users = null;
		String sql = "select * from users where userid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				users = new Users();
				users.setUserId(rs.getInt("userid"));
				users.setUserName(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 修改用户
	 */
	public boolean modifyUser(Users u,Connection conn) {
		String sql = "update users set username=?,password=?,status=? where userid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getStatus());
			ps.setInt(4, u.getUserId());
			int count = ps.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询所有用户
	 */
	public List<Users> selectAllUser(Connection conn,int pSixe,int pNo) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from users limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pNo-1)*pSixe);
			ps.setInt(2, pSixe);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Users u = new Users();
				u.setUserId(rs.getInt("userid"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setStatus(rs.getInt("status"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean selectUserByName(String username, Connection conn) {
		String sql = "select * from users where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int getMaxPageNo(int pageSize, Connection conn) {
		String sql = "select count(*) from users";
		int totalCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (totalCount-1)/pageSize+1;
//		return totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSiz
	}
	@Override
	public Users login(String uname, String password, Connection conn) {
		Users users = null;
		String sql = "select * from users where username=? and password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				users = new Users();
				users.setUserId(rs.getInt("userid"));
				users.setUserName(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
