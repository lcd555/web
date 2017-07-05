package cn.zkingsoft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zkingsoft.pojo.Product;
import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.pojo.news;
import cn.zkingsoft.service.NewsService;
import cn.zkingsoft.service.NewsServiceImp;
import cn.zkingsoft.service.UserService;
import cn.zkingsoft.service.UserServiceImpl;

public class NewsManagerServlet extends HttpServlet{

	/**
	 * 
	 */
	private NewsService service = new NewsServiceImp();
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor of the object.
	 */
	public NewsManagerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException, IOException{
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
		int id=Integer.parseInt(request.getParameter("newsID"));
		news n=service.getNews(id);
		request.setAttribute("news", n);
		request.getRequestDispatcher("/behind/updateNews.jsp").forward(request, response);
		
	}
	public void updateSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("newsID"));
		news n=service.getNews(id);
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		String writerDate=request.getParameter("writerDate");
		n.setTitle(title);
		n.setContent(content);
		n.setWriterDate(writerDate);
		
		
		service.updateNews(n);
		PrintWriter out = response.getWriter();
		
		out.print("中国");
		//queryAll(request, response);
		
	}
	public void  save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			String title = request.getParameter("title");
			String content = request.getParameter("content");	
			news news = new news();
			news.setTitle(title);
			news.setContent(content);
			
			service.insertNews(news);
			queryAll(request, response);
		}
	public  void  delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			int newsid = Integer.parseInt(request.getParameter("newsID"));
			service.removeNews(newsid);
			queryAll(request, response);
		}
	public void queryaNew(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("newsID"));
		news n1=service.getaNew(id);
		request.getSession().setAttribute("aNew", n1);
		request.getRequestDispatcher("/front/readaNew.jsp").forward(request, response);
	}
	public void queryIndexNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<news> news=service.getIndexNews(0,(service.getMaxNo(4)-1)*4+1);
		request.getSession().setAttribute("n", news);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public  void  queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = 4;
		int pageNo = 1;
		    //从页面获得页码以及大小，为空表示第一次访问，使用默认的
		   //大小与页面
		String size = request.getParameter("pageSize");
		String no = request.getParameter("pageNo");
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
		request.setAttribute("pageNo", pageNo);
		   //保存最大页码s
		request.setAttribute("maxNo", maxNo);
		  //保存每页条数
		request.setAttribute("pageSize", pageSize);
			List<news>  list = service.queryAllNews( pageSize, pageNo);
			request.getSession().setAttribute("news", list);
			request.getRequestDispatcher("/behind/manageNews.jsp").forward(request, response);
		}
}
