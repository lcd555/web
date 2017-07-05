package cn.zkingsoft.service;

import java.util.List;

import cn.zkingsoft.pojo.Product;
import cn.zkingsoft.pojo.Users;
import cn.zkingsoft.pojo.news;

public interface NewsService {
	public boolean insertNews(news u);
	public boolean updateNews(news u);
	public boolean removeNews(int id);
	public news getNews(int id);
	public List<news> queryAllNews(int pageSize,int pageNo);
	public int getMaxNo(int pageSize);
	public List<news> getIndexNews(int a,int b);
	public news getaNew(int id);
}
