package cn.zkingsoft.service;

import java.util.List;
import cn.zkingsoft.pojo.Product;;


public interface ProductService {
	public boolean insertProducts(Product p);
	public boolean updateProducts(Product p);
	public boolean removeProducts(int id);
	
	public List<Product> queryAllProducts(int pageSize,int pageNo);
	public Product getProduct(int id);
	public int getMaxNo(int pageSize);
}
