package cn.zkingsoft.dao;

import java.sql.Connection;
import java.util.List;

import cn.zkingsoft.pojo.Product;

public interface ProductDao {
	/**
	 * 添加商品
	 * @param u
	 * @return
	 */
	public boolean addProduct(Product p);
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	public boolean deleteProduct(int id);
	/**
	 * 修改商品
	 * @param u
	 * @return
	 */
	public boolean modifyProduct(Product p);
	/**
	 * 查询�?��商品
	 * @return
	 */
	public List<Product> selectAllProduct(int pageSize,int pageNo);
	/**
	 * 查询单个商品
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
	public int getMaxPageNo(int pageSize,Connection conn);
}
