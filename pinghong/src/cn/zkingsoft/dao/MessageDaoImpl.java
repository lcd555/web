package cn.zkingsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.Message;
import cn.zkingsoft.pojo.Revert;
import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.pojo.news;

public class MessageDaoImpl implements MessageDao {

	@Override
	public boolean addMessage(Message me) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMessage(Message me) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Message> selectAllMessage(int pageSize,int pageNo) {
		String sql="select * from message ";
		Connection connection=DBHelper.getConnection();
		List <Message> mgeList=new ArrayList<Message>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setInt(1, (pageNo-1)*pageSize);
//			ps.setInt(2, pageSize);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Message m = new Message();
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCount(rs.getInt("count"));
				m.setMessageID(rs.getInt("messageID"));
				m.setWriterDate(rs.getString("writerDate"));
				m.setWriter(rs.getString("writer"));
				
				mgeList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mgeList;
	}

	@Override
	public Message getMessageById(int id) {
		Message message=null;
		Connection conn=DBHelper.getConnection();
		String sql = "select * from message where messageId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				message = new Message();
				message.setContent(rs.getString("content"));
				message.setTitle(rs.getString("title"));
				message.setMessageID(rs.getInt("messageid"));
				message.setWriter(rs.getString("writer"));
				message.setWriterDate(rs.getString("writerDate"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return message;
	}

	@Override
	public List<Revert> getRevertById(int id) {
		
		List<Revert> list=new ArrayList<Revert>();
		Connection conn=DBHelper.getConnection();
		String sql = "select * from revert where messageId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Revert r = new Revert();
				r.setContent(rs.getString("content"));
				r.setRevertID(rs.getInt("revertID"));
				r.setMessageID(rs.getInt("messageid"));
				r.setWriter(rs.getString("writer"));
				r.setWriterDate(rs.getString("writerDate"));
				list.add(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean insert(Message n) {
		Connection conn=DBHelper.getConnection();
		String sql="insert into message(title,content,writerDate,writer) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getContent());
			ps.setString(3, n.getWriterDate());
			ps.setString(4, n.getWriter());
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

	@Override
	public boolean insertRevert(Revert revert) {
		Connection conn=DBHelper.getConnection();
		String sql="insert into revert(content,writerDate,writer,messageid) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, revert.getContent());
			ps.setString(2, revert.getWriterDate());
			ps.setString(3, revert.getWriter());
			ps.setInt(4, revert.getMessageID());
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

}
