package cn.zkingsoft.dao;

import java.sql.Connection;
import java.util.List;

import cn.zkingsoft.pojo.Users;

public interface UserDao {
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public boolean addUser(Users u,Connection conn);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id,Connection conn);
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public boolean modifyUser(Users u,Connection conn);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Users> selectAllUser(Connection conn,int pSize,int pNo);
	/**
	 * 查询单个用户
	 * @param id
	 * @return
	 */
	public Users getUserById(int id,Connection conn);
	public boolean selectUserByName(String username, Connection conn);
	public int getMaxPageNo(int pageSize,Connection conn);
	public Users login(String uname,String password,Connection conn);
	

}
