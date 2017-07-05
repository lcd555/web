package cn.zkingsoft.dao;

import java.util.List;

import cn.zkingsoft.pojo.Menus;

public interface MenusDao {
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public boolean addMenus(Menus m);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteMenus(int id);
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public boolean modifyMenus(Menus m);
	/**
	 * 查询�?��用户
	 * @return
	 */
	public List<Menus> selectAllMenus();
	/**
	 * 查询单个用户
	 * @param id
	 * @return
	 */
	public Menus getMenusById(int id);
}