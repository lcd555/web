package cn.zkingsoft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.service.UserService;
import cn.zkingsoft.service.UserServiceImpl;

public class UserManagerServlet extends HttpServlet {

	private UserService service = new UserServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public UserManagerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
		
//		if("queryAll".equals(action)){
//			List<Users>  list = service.queryAllUsers();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/behind/showUserList.jsp").forward(request, response);
//		}
//		if("delete".equals(action)){
//			int userid = Integer.parseInt(request.getParameter("userID"));
//			service.removeUser(userid);
//			List<Users>  list = service.queryAllUsers();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/behind/showUserList.jsp").forward(request, response);
//		}
//		if("save".equals(action)){
//			String username = request.getParameter("userName");
//			String password = request.getParameter("password");	
//			Users users = new Users();
//			users.setUserName(username);
//			users.setPassword(password);
//			users.setStatus(1);
//			service.insertUser(users);
//			List<Users>  list = service.queryAllUsers();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/behind/showUserList.jsp").forward(request, response);
//		}
//		if("preupdate".equals(action)){
//			int userid = Integer.parseInt(request.getParameter("userID"));
//			Users users = service.getUsers(userid);
//			request.setAttribute("users", users);
//			request.getRequestDispatcher("/behind/updateManager.jsp").forward(request, response);
//		}
//		if("update".equals(action)){
//			int userid = Integer.parseInt(request.getParameter("userID"));
//			String username = request.getParameter("userName");
//			int status = Integer.parseInt(request.getParameter("status"));
//			Users users = service.getUsers(userid);
//			users.setStatus(status);
//			users.setUserName(username);
//			service.updateUser(users);
//			List<Users>  list = service.queryAllUsers();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/behind/showUserList.jsp").forward(request, response);
//		}
	}
	
	/**
	 * 根据应户名查询（AJAX调用）
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  test(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String username = request.getParameter("username");
		boolean flag = service.getUserByName(username);
		if("".equals(username.trim())){
			flag = true;
		}
		
		PrintWriter out = response.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	}
	
	
	
	
	/**
	 * 修改方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			int userid = Integer.parseInt(request.getParameter("userID"));
			String username = request.getParameter("userName");
			int status = Integer.parseInt(request.getParameter("status"));
			Users users = service.getUsers(userid);
			users.setStatus(status);
			users.setUserName(username);
			service.updateUser(users);
			queryAll(request, response);
	}
	/**
	 * 修改预处理方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  preupdate(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		int userid = Integer.parseInt(request.getParameter("userID"));
		Users users = service.getUsers(userid);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/behind/updateManager.jsp").forward(request, response);
	}
	
	/**
	 * 保存方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  save(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String username = request.getParameter("userName");
		String password = request.getParameter("password");	
		Users users = new Users();
		users.setUserName(username);
		users.setPassword(password);
		users.setStatus(1);
		service.insertUser(users);
		queryAll(request, response);
	}
	
	/**
	 * 删除方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  delete(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		int userid = Integer.parseInt(request.getParameter("userID"));
		service.removeUser(userid);
		queryAll(request, response);
	}
	/**
	 * 查询所有方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void  queryAll(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//初始值
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
				
				//第一个参数是大小，第二个是页码
				List<Users>  list = service.queryAllUsers(pageSize,pageNo);
				request.setAttribute("list", list);
				//保存当前页码
				request.setAttribute("pageNo", pageNo);
				//保存最大页码
				request.setAttribute("maxNo", maxNo);
				//保存每页条数
				request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("/behind/showUserList.jsp").forward(request, response);
	}
	public  void  login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			Users users = service.loginSer(username, password);
			
			//保存
			if(users!=null&&users.getStatus()==1){
				request.getSession().setAttribute("loginName", users);
				response.sendRedirect("/pinghong/behind/index.jsp");
			}else{
				response.sendRedirect("/pinghong/index.jsp");
			}
			
		}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
