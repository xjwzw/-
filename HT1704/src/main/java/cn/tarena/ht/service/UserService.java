package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserService {

	//查询用户列表信息
		public List<User> findAll();
	//更改用户状态
	public void updateState(String[] userIds, int state);
	//批量删除
	public void deleteUser(String[] userId);
	
	public List<UserInfo> findUserInfo();
	//新增用户
	public void saveUser(User user);
	//查询上级领导
	public List<UserInfo> findManagerList(String userId);
	//根据id查询信息
	public User findOne(String userId);
	//更新用户
	public void updateUser(User user);
	
	public void saveRoleUser(String userId, String[] roleIds);
}
