package cn.zkingsoft.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.DoubleBuffer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zkingsoft.pojo.Product;
import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.pojo.news;
import cn.zkingsoft.service.ProductService;
import cn.zkingsoft.service.ProductServiceImp;
import cn.zkingsoft.service.UserService;
import cn.zkingsoft.service.UserServiceImpl;

public class ProductManagerServlet extends HttpServlet{
	private ProductService service = new ProductServiceImp();
	
	public ProductManagerServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得当前的类对象
		Class c = this.getClass();
		//获得方法名称（action的值就是方法名称）
		String action  = request.getParameter("action");
		try {
			//通过方法名称和参数定位一个方法
			Method m = c.getDeclaredMethod(action, new Class[]{HttpServletRequest.class,HttpServletResponse.class});
			//调用方法
			m.invoke(this, new Object[]{request,response});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void  update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("productID"));
		String adc=request.getParameter("adc");
		Product product=service.getProduct(id);
		request.getSession().setAttribute("pro", product);
		if("bed".equals(adc))
		{
			request.getRequestDispatcher("/behind/updateProduct.jsp").forward(request, response);
		}else if("front".equals(adc)){
			response.sendRedirect("/pinghong/front/detailProduct.jsp");
		}		
				
				
				
		}
	public void updateSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("productID"));
		String brand = request.getParameter("brand");
		String description= request.getParameter("description");
		String name=request.getParameter("name");
		String model=request.getParameter("model");
		String picture=request.getParameter("picture");
		String serialNumber=request.getParameter("serialNumber");
		double price=Double.parseDouble(request.getParameter("price"));
		Product product=service.getProduct(id);
		product.setBrand(brand);
		product.setDescription(description);
		product.setName(name);
		product.setModel(model);
		product.setPicture(picture);
		product.setSerialNumber(serialNumber);
		product.setPrice(price);
		
		service.updateProducts(product);
		queryAll(request, response);
		
	}
	public  void  save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			double price =Integer.parseInt(request.getParameter("price"));
			String picture= request.getParameter("picture");
			String name=request.getParameter("name");
			String serialNumber=request.getParameter("serialNumber");
			String model=request.getParameter("model");
			String brand=request.getParameter("brand");
			String description=request.getParameter("description");
			Product product = new Product();
			product.setPrice(price);
			product.setPicture(picture);
			product.setName(name);
			product.setSerialNumber(serialNumber);
			product.setModel(model);
			product.setBrand(brand);
			product.setDescription(description);
			
			
			service.insertProducts(product);
			queryAll(request, response);
		}
	public  void  delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			int productid = Integer.parseInt(request.getParameter("productID"));
			service.removeProducts(productid);
			queryAll(request, response);
		}
	
	public  void  queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//初始值
				int pageSize = 4;
				int pageNo = 1;
				//从页面获得页码以及大小，为空表示第一次访问，使用默认的
				//大小与页面
				String size = request.getParameter("pageSize");
				String no = request.getParameter("pageNo");
				String adc=request.getParameter("adc");
				if(size!=null){
					pageSize = Integer.parseInt(size);
				}
				
				//计算出我们最大的页码
				int maxNo = service.getMaxNo(pageSize);
				if(no!=null){
					pageNo = Integer.parseInt(no);
					if(pageNo>maxNo){
						pageNo = maxNo;
					}
					if(pageNo<1){
						pageNo = 1;
					}
				}
				request.getSession().setAttribute("pageNo", pageNo);
				//保存最大页码
				request.setAttribute("maxNo", maxNo);
				//保存每页条数
				request.getSession().setAttribute("pageSize", pageSize);
			List<Product>  list = service.queryAllProducts( pageSize, pageNo);
			request.getSession().setAttribute("list", list);
			if("bed".equals(adc)){
			request.getRequestDispatcher("/behind/manageProduct.jsp").forward(request, response);
			}else if("front".equals(adc)){
				response.sendRedirect("/pinghong/front/showProductList.jsp");	
			}
			}
}
