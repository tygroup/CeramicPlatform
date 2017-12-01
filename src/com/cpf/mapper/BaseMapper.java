package com.cpf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T, PK>{

	public T save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void delete(Class<T> entityClass, PK id);
	
	public T findById(String id);

	/**
	 * 分页查询符合查询条件的记录
	 * 
	 * @param entityClass
	 *            entityClass
	 * @param params
	 *            Map<String, Object> 查询参数
	 * @param currentPage
	 *            当前页码
	 * @param pageSize
	 *            页面容量
	 * @return PageListData
	 */
	public List<Class<T>> queryPage(@Param("map")Map<String, Object> params);
	
	public int getTotalCount(@Param("map")Map<String, Object> params);
}
