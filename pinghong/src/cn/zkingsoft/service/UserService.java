package cn.zkingsoft.service;

import java.util.List;

import cn.zkingsoft.pojo.Users;
/**
 * 业务层调用dao层
 * @author Administrator
 *
 */
public interface UserService {
	public boolean insertUser(Users u);
	public boolean updateUser(Users u);
	public boolean removeUser(int id);
	public List<Users> queryAllUsers(int pSize,int pNo);
	public Users getUsers(int id);
	public int getMaxNo(int pageSize);
	public boolean getUserByName(String username);
	public Users loginSer(String uname,String password);
}
