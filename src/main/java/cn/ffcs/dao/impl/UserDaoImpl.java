package cn.ffcs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cn.ffcs.dao.IUserDao;
import cn.ffcs.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource  
    private MongoTemplate mongoTemplate;  
  
    @Override  
    public void insert(User user,String collectionName) {  
        mongoTemplate.insert(user, collectionName);  
    }  
  
    @Override  
    public User findOne(User user,String collectionName) {  
         return mongoTemplate.findOne(new Query(Criteria.where("name").is(user.getName())), User.class,collectionName);    
    }  
  
    @Override  
    public List<User> findAll(String collectionName) {  
        List<User> result = mongoTemplate.findAll(User.class,collectionName);  
        return result;  
    }  
  
    @Override  
    public void update(User user,String collectionName) {  
    	Query query = new Query(Criteria.where("name").is(user.getName()));
    	
    	Update update = new Update();
    	update.set("name", user.getName());
    	update.set("password", user.getPassword());
        mongoTemplate.upsert(query, update, User.class,collectionName);  
    }  
  
    @Override  
    public void createCollection(String name) {
        mongoTemplate.createCollection(name);  
    }  
  
  
    @Override
    public void remove(User user,String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("name").is(user.getName())),User.class,collectionName);  
    } 

	
	
}
