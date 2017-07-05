package cn.zkingsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.zkingsoft.dbhelper.DBHelper;
import cn.zkingsoft.pojo.news;

public class NewsDaoImpl implements NewsDao {

	/**
	 * 添加用户
	 */
	public boolean addNews(news n,Connection conn) {
		
		String sql="insert into news(title,content,writerDate) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getContent());
			ps.setString(3, n.getWriterDate());
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
	 * 删除用户
	 */
	public boolean deleteNews(int id,Connection conn) {
		String sql = "delete from news where newsid=?";
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
	 * 根据id获得�?��新闻
	 */
	public news getNewsById(int id) {
		news news = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from news where newsid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				news = new news();
				news.setNewsID(rs.getInt("newsID"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setWriterDate(rs.getString("writerDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return news;
	}
	/**
	 * 修改用户
	 */
	public boolean modifyNews(news n) {
		String sql = "update news set title=?,content=?,writerDate=? where newsid=?";
		Connection conn = DBHelper.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,n.getTitle() );
			ps.setString(2, n.getContent());
			ps.setString(3, n.getWriterDate());
			ps.setInt(4, n.getNewsID());
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
	public List<news> selectAllNews(Connection conn,int pageSize,int pageNo) {
		List<news> list = new ArrayList<news>();
		
		//Connection conn = DBHelper.getConnection();
		String sql = "select * from news limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				news n = new news();
				n.setNewsID(rs.getInt("newsID"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWriterDate(rs.getString("writerDate"));
				list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int getMaxPageNo(int pageSize, Connection conn) {
		String sql = "select count(*) from news";
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
	@Override
	public List<news> indexNews(int a, int b) {
		List<news> list = new ArrayList<news>();
		
		int i=0;
		int totalCount = 0;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from news";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement preparedStatement=conn.prepareStatement("select count(*) from news");
			ResultSet rs1 = preparedStatement.executeQuery();
			if(rs1.next()){
				totalCount = rs1.getInt(1);
			}
			ResultSet rs = ps.executeQuery();
			news []bNews=new news[totalCount];
			while(rs.next()){
				news n = new news();
				n.setNewsID(rs.getInt("newsID"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWriterDate(rs.getString("writerDate"));
				bNews[i]=n;
				i++;
				
			}
			for(int i1=bNews.length-1;i1>=bNews.length-7;i1--){
				list.add(bNews[i1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public news getaNew(int a) {
		news aNew=null;
		Connection connection=DBHelper.getConnection();
		String sql="select * from news where newsid=?";
		return aNew;
	}
	

}
