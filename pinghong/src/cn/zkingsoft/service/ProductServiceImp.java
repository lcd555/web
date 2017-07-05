package cn.zkingsoft.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.zkingsoft.dao.ProductDao;
import cn.zkingsoft.dao.ProductDaoImpl;
import cn.zkingsoft.dao.UserDao;
import cn.zkingsoft.dao.UserDaoImpl;
import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Product;
import cn.zkingsoft.pojo.Users;

public class ProductServiceImp implements ProductService{
	private ProductDao dao = new ProductDaoImpl();
	@Override
	public boolean insertProducts(Product p) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			
			conn.setAutoCommit(false);
			flag = dao.addProduct(p);
			
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
	public boolean updateProducts(Product p) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.modifyProduct(p);
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
	public boolean removeProducts(int id) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			flag = dao.deleteProduct(id);
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
	public List<Product> queryAllProducts(int pageSize,int pageNo) {
		Connection conn = DBHelper.getConnection();
		List<Product> list = null;
		try {
			conn.setAutoCommit(false);
			list = dao.selectAllProduct( pageSize, pageNo);
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
	public Product getProduct(int id) {
		Connection conn = DBHelper.getConnection();
		Product p = null;
		try {
			conn.setAutoCommit(false);
			p = dao.getProductById(id);
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
		return p;
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

	

	
}
