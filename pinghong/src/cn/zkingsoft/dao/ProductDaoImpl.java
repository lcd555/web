package cn.zkingsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Product;


public class ProductDaoImpl implements ProductDao{
	/**
	 * 添加商品
	 */
	public boolean addProduct(Product p) {
		Connection conn = DBHelper.getConnection();
		String sql="insert into product(serialNumber,name,brand,model,picture,description,price) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getSerialNumber());
			ps.setString(2, p.getName());
			ps.setString(3, p.getBrand());
			ps.setString(4, p.getModel());
			ps.setString(5, p.getPicture());
			ps.setString(6, p.getDescription());
			ps.setDouble(7, p. getPrice());
		
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
	/**
	 * 删除用户
	 */
	public boolean deleteProduct(int id) {
		String sql = "delete from product where productid=?";
		Connection conn = DBHelper.getConnection();
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
	 * 根据id获得�?��商品
	 */
	public Product getProductById(int id) {
		Product product = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from product where productid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				product = new Product();
				product.setProductId(rs.getInt("productid"));
				product.setSerialNumber(rs.getString("serialNumber"));
				product.setName(rs.getString("name"));
				product.setBrand(rs.getString("brand"));
				product.setModel(rs.getString("model"));
				product.setPicture(rs.getString("picture"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return product;
	}
	/**
	 * 修改用户
	 */
	public boolean modifyProduct(Product p) {
		String sql = "update product set name=?,serialNumber=?,brand=?,model=?,description=?,picture=?,price=? where productid=?";
		Connection conn = DBHelper.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getSerialNumber());
			ps.setString(3, p.getBrand());
			ps.setString(4, p.getModel());
			ps.setString(5, p.getDescription());
			ps.setString(6, p.getPicture());
			ps.setDouble(7, p.getPrice());
			ps.setInt(8, p.getProductId());
			
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
	 * 查询�?��用户
	 */
	public List<Product> selectAllProduct(int pageSize,int pageNo) {
		List<Product> list = new ArrayList<Product>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from product limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setProductId(rs.getInt("productid"));
				p.setSerialNumber(rs.getString("serialNumber"));
				p.setName(rs.getString("name"));
				p.setBrand(rs.getString("brand"));
				p.setModel(rs.getString("model"));
				p.setPicture(rs.getString("picture"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}
	@Override
	public int getMaxPageNo(int pageSize, Connection conn) {
		String sql = "select count(*) from product";
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
	}
	
	
	

}
