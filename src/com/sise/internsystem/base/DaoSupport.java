package com.sise.internsystem.base;

import java.util.List;

import com.sise.internsystem.entity.PageBean;
import com.sise.internsystem.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 淇濆瓨瀹炰綋
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 鎸塱d鏌ヨ
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * 鎸塱d鏌ヨ
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 鏌ヨ鎵�湁
	 * 
	 * @return
	 */
	List<T> findAll();
	
	
	
	@Deprecated
	PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);

	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL语句与参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
	/**
	 * 判断是否重复
	 */
	boolean checkName(String name);
	 boolean checkNo(String name);
	
	
}
