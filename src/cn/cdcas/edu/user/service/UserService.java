package cn.cdcas.edu.user.service;

import cn.cdcas.edu.user.dao.UserDao;
import cn.cdcas.edu.user.vo.User;
import org.springframework.transaction.annotation.Transactional;

import cn.cdcas.edu.utils.MailUitls;
import cn.cdcas.edu.utils.UUIDUtils;


/**
 * 用户名模块业务层代码
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	public void save(User user) {
		user.setState(0); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		MailUitls.sendMail(user.getEmail(), code);
	}

	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	public void update(User existUser) {
		userDao.update(existUser);
	}

	public User login(User user) {
		return userDao.login(user);
	}
}
