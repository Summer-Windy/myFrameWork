package com.xbb.net.core.entityManager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface HibernateUtil {

	/** 
	 * @return 获取会话工厂 
	 */
	public abstract SessionFactory getSessionFactory();

	/** 
	 * @return 获取会话对象 
	 */
	public abstract Session getSession();

	/** 
	 * @param obj 添加数据 
	 * @return 
	 */
	public abstract boolean add(Object obj);

	/** 
	 * @return 更新数据  
	 * 参数为修改的主键id对象 
	 */
	public abstract boolean update(Object object);

	/** 
	 * @param c 
	 * @param obj  查询一条数据根据主键的id号 
	 * @return 
	 */
	public abstract Object get(Class c, int obj);

	/** 
	 * @param obj 
	 * @return 删除数据 
	 */
	public abstract boolean delete(Object obj);

	/** 
	 * @param <T> 查询多条记录 
	 * @param sql  sql语句 
	 * @param param 参数数组 
	 * @return 
	 */
	public abstract <T> List<T> query(String sql, String[] param);

	/** 
	 * @param sql 
	 * @param param 查询单条记录 
	 * @return 
	 */
	public abstract Object queryOne(String sql, String[] param);

	/** 
	 * @param <T> 
	 * @param sql 
	 * @param param 
	 * @param page 
	 * @param size 
	 * @return 实现分页查询 
	 */
	public abstract <T> List<T> queryByPage(String sql, String[] param,
			int page, int size);

	/** 
	 * @param hql 
	 * @param pras 
	 * @return返回数据个数 
	 */
	public abstract int getCount(String hql, String[] pras);
	
	
	/** 
	 * @param hql 
	 * @param pras 
	 * @return返回数据个数 
	 */
	public abstract double getDouble(String hql, String[] pras);

}