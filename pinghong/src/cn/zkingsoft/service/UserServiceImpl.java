package cn.zkingsoft.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zkingsoft.dao.UserDao;
import cn.zkingsoft.dao.UserDaoImpl;
import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Users;

public class UserServiceImpl implements UserService{
	//service调用dao层对象
	private UserDao dao = new UserDaoImpl();
	/**
	 * 新增
	 */
	public boolean insertUser(Users u) {
		//获得连接
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.addUser(u, conn);
			//如果dao层没有发生异常，手动提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}
	
	/**
	 * 获得单个
	 */
	public Users getUsers(int id) {
		Connection conn = DBHelper.getConnection();
		Users users = null;
		try {
			conn.setAutoCommit(false);
			users = dao.getUserById(id, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return users;
	}
	/**
	 * 查询所有
	 */
	public List<Users> queryAllUsers(int pSize,int pNo) {
		Connection conn = DBHelper.getConnection();
		List<Users> list = null;
		try {
			conn.setAutoCommit(false);
			list = dao.selectAllUser(conn,pSize,pNo);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}
	/**
	 * 删除
	 */
	public boolean removeUser(int id) {
		//获得连接
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.deleteUser(id, conn);
			//如果dao层没有发生异常，手动提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}
	
	
	/**
	 * 修改
	 */
	public boolean updateUser(Users u) {
		//获得连接
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.modifyUser(u, conn);
			//如果dao层没有发生异常，手动提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}
	/**
	 * 业务层的根据姓名查询方法
	 */
	public boolean getUserByName(String username) {
		//获得连接
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.selectUserByName(username, conn);
			//如果dao层没有发生异常，手动提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public int getMaxNo(int pageSize) {
		//获得连接
				Connection conn = DBHelper.getConnection();
				int max = 0;
				try {
					//设置手动提交
					conn.setAutoCommit(false);
					max = dao.getMaxPageNo(pageSize, conn);
					//如果dao层没有发生异常，手动提交
					conn.commit();
				} catch (Exception e) {
					e.printStackTrace();
					try {
						//回滚
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}finally{
					DBHelper.closeConnection(conn);
				}
				return max;
	}

	@Override
	public Users loginSer(String uname, String password) {
		Connection conn = DBHelper.getConnection();
		Users users = null;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			users = dao.login(uname, password, conn);
			//如果dao层没有发生异常，手动提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return users;
	}

}
