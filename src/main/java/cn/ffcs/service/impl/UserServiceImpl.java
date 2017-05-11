package cn.ffcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ffcs.dao.IUserDao;
import cn.ffcs.model.User;
import cn.ffcs.service.IUserService;

/**
 * 用户业务接口实现
 * @author huangmengwei
 *
 */
@Service("userService") 
public class UserServiceImpl implements IUserService {
	
	public static final String COLLECTION = "user";
	
	@Autowired
	private IUserDao userDao;

	@Override
	public void insert(User user) {
		userDao.insert(user, COLLECTION);
	}

	@Override
	public User findOne(User user) {
		return userDao.findOne(user, COLLECTION);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll(COLLECTION);
	}

	@Override
	public void update(User user) {
		userDao.update(user, COLLECTION);
	}

	@Override
	public void createCollection(String collectionName) {
		userDao.createCollection(COLLECTION);
	}

	@Override
	public void remove(User user) {
		userDao.remove(user, COLLECTION);
	}

	
}
