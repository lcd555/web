package cn.zkingsoft.dao;

import java.util.List;

import cn.zkingsoft.pojo.Message;
import cn.zkingsoft.pojo.Revert;

public interface MessageDao {
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public boolean addMessage(Message me);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteMessage(int id);
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public boolean modifyMessage(Message me);
	/**
	 * 查询�?��用户
	 * @return
	 */
	public List<Message> selectAllMessage(int pageSize,int pageNo);
	/**
	 * 查询单个用户
	 * @param id
	 * @return
	 */
	public boolean insert(Message n);
	public boolean insertRevert(Revert revert);
	public List<Revert> getRevertById(int id);
	public Message getMessageById(int id);
}