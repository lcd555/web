package cn.zkingsoft.dao;

import java.sql.Connection;
import java.util.List;

import cn.zkingsoft.pojo.news;

public interface NewsDao {
	/**
	 * 添加新闻
	 * @param u
	 * @return
	 */
	public boolean addNews(news n,Connection conn);
	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	public boolean deleteNews(int id,Connection conn);
	/**
	 * 修改新闻
	 * @param u
	 * @return
	 */
	public boolean modifyNews(news n);
	/**
	 * 查询�?��新闻
	 * @return
	 */
	public List<news> selectAllNews(Connection connint,int pageSize,int pageNo);
	/**
	 * 查询单个新闻
	 * @param id
	 * @return
	 */
	public news getNewsById(int id);
	public int getMaxPageNo(int pageSize,Connection conn);
	public List<news> indexNews(int a,int b);
	public news getaNew(int a);
}

