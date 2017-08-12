package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	@Override
	public void updateState(String[] userIds, int state) {
		userMapper.updateState(userIds,state);
	}
	@Override
	public void deleteUser(String[] userId) {
		userMapper.deleteUser(userId);
	}
	@Override
	public List<UserInfo> findUserInfo() {
		return userInfoMapper.findUserInfo();
	}
	@Override
	public void saveUser(User user) {
		//应该将user表和userinfo表同时入库,如果中间有异常 同时回滚
		Date date=new Date();
		String id=UUID.randomUUID().toString();
		
		user.setUserId(id);
		user.setCreateTime(date);
		UserInfo userInfo=user.getUserInfo();
		userInfo.setUserInfoId(id);
		userInfo.setCreateTime(date);
		userMapper.saveUser(user);
		userInfoMapper.saveUserInfo(userInfo);
		
		
	}
	@Override
	public List<UserInfo> findManagerList(String userId) {
		return userInfoMapper.findManagerList(userId);
	}
	@Override
	public User findOne(String userId) {
		return userMapper.findOne(userId);
	}
	@Override
	public void updateUser(User user) {
		Date date=new Date();
		user.setUpdateTime(date);
		UserInfo userInfo=user.getUserInfo();
		userInfo.setUpdateTime(date);
		userInfo.setUserInfoId(user.getUserId());
		userMapper.updateUser(user);		 
	    userInfoMapper.updateUser(userInfo);
	}
	@Override
	public void saveRoleUser(String userId, String[] roleIds) {
		userMapper.deleteRoleUserByUserId(userId);
		
		for(String roleId:roleIds){
			userMapper.saveRoleUser(userId,roleId);
		}
		
	}
	

}
