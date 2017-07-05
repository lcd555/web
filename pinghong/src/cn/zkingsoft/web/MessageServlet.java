package cn.zkingsoft.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zkingsoft.dao.MessageDao;
import cn.zkingsoft.dao.MessageDaoImpl;
import cn.zkingsoft.pojo.Message;
import cn.zkingsoft.pojo.Revert;

public class MessageServlet extends HttpServlet {
	
	MessageDao service=new MessageDaoImpl();

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
	public void addMessage(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		String yn=request.getParameter("yn");
		
		if("revert".equals(yn)){
			int messageID=Integer.parseInt(request.getParameter("messageID"));
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");
			Revert revert=new Revert();
			revert.setContent(content);
			revert.setWriter(writer);
			revert.setMessageID(messageID);
			service.insertRevert(revert);
			queryaMessage(request, response);
		}else if("message".equals(yn)){
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");
			String writerDate=request.getParameter("writer");
			String title=request.getParameter("title");
			Message message=new Message();
			message.setContent(content);
			message.setTitle(title);
			message.setWriter(writer);
			message.setWriterDate(writerDate);
			service.insert(message);
			queryAll(request, response);
		}
		
	}
	public void queryaMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//int rId=Integer.parseInt(request.getParameter("rId"));
		int id=Integer.parseInt(request.getParameter("messageID"));
		Message message=service.getMessageById(id);
		List<Revert> revert=service.getRevertById(id);
		request.getSession().setAttribute("revert", revert);
		request.getSession().setAttribute("amessage", message);
		response.sendRedirect("/pinghong/front/revertMessage.jsp");
		
	}
	public  void  queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//初始值
				int pageSize = 4;
				int pageNo = 1;
					
			List<Message>  list = service.selectAllMessage( pageSize, pageNo);
			request.getSession().setAttribute("messageList", list);
			response.sendRedirect("/pinghong/front/messageBoard.jsp");	
	
			}
	
	
}