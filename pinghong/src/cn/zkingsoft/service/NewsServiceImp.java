package cn.zkingsoft.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zkingsoft.dao.NewsDao;
import cn.zkingsoft.dao.NewsDaoImpl;
import cn.zkingsoft.dao.UserDao;
import cn.zkingsoft.dao.UserDaoImpl;
import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Product;
import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.pojo.news;

public class NewsServiceImp implements NewsService {
	private NewsDao dao = new NewsDaoImpl();
	@Override
	public boolean insertNews(news n) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			
			conn.setAutoCommit(false);
			flag = dao.addNews(n, conn);
			
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
		return flag;
	}

	@Override
	public boolean updateNews(news u) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.modifyNews(u);
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
	public boolean removeNews(int id) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.deleteNews(id, conn);
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
	public List<news> queryAllNews(int pageSize,int pageNo) {
		Connection conn = DBHelper.getConnection();
		List<news> list = null;
		try {
			conn.setAutoCommit(false);
			list = dao.selectAllNews(conn, pageSize, pageNo);
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

	@Override
	public news getNews(int id) {
		Connection conn = DBHelper.getConnection();
		news n = null;
		try {
			conn.setAutoCommit(false);
			n = dao.getNewsById(id);
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
		return n;
	}

	@Override
	public int getMaxNo(int pageSize) {
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
public news getaNew(int id){
	return dao.getNewsById(id);
}
	@Override
	public List<news> getIndexNews(int a, int b) {
		List <news> list=null;
		list=dao.indexNews(a, b);
		return list;
	}
	
}
