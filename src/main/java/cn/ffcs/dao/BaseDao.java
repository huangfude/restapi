package cn.ffcs.dao;

import java.util.List;

/**
 * 通用DAO
 * @author huangmengwei
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
    /**
     * 添加  
     * @param object
     * @param collectionName
     */
    public void insert(T object,String collectionName);    
    
    /**
     * 根据条件查找  
     * @param object
     * @param collectionName
     * @return
     */
    public T findOne(T object,String collectionName);    
    
    /**
     * 查找所有
     * @param collectionName
     * @return
     */
    public List<T> findAll(String collectionName);    
    
    /**
     * 修改
     * @param object
     * @param collectionName
     */
    public void update(T object,String collectionName);   
    
    /**
     * 创建集合  
     * @param collectionName
     */
    public void createCollection(String collectionName);  
    
    /**
     * 根据条件删除  
     * @param object
     * @param collectionName
     */
    public void remove(T object,String collectionName);  
      
}  
