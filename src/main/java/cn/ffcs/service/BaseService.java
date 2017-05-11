package cn.ffcs.service;

import java.util.List;


/**
 * 通用Service
 * @author huangmengwei
 *
 * @param <T>
 */
public interface BaseService<T> {

	/**
	 * 添加  
	 * @param object
	 */
    public void insert(T object);    
    
    /**
     * 根据条件查找  
     * @param object
     * @return
     */
    public T findOne(T object);    
    
    /**
     * 查找所有  
     * @return
     */
    public List<T> findAll();    
    
    /**
     * 修改  
     * @param object
     */
    public void update(T object);   
    
    /**
     * 创建集合  
     * @param collectionName
     */
    public void createCollection(String collectionName);  
    
    /**
     * 根据条件删除  
     * @param object
     */
    public void remove(T object);  
    
}
