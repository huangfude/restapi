package cn.ffcs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.ffcs.model.User;
import cn.ffcs.service.IUserService;

/**
 * 用户请求
 * @author huangmengwei
 *
 */
@RestController
@RequestMapping("/user/")
public class UserRestController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findOne", method=RequestMethod.POST)
	public ResponseEntity<User> findOne(User user){
        user = userService.findOne(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * 插入
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(User user){
		userService.insert(user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 更新
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Void> update(User user){
		userService.update(user);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(User user) {
		userService.remove(user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
 
}
