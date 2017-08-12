package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {

	public List<UserInfo> findUserInfo();

	public void saveUserInfo(UserInfo userInfo);

	public List<UserInfo> findManagerList(String userId);

	public void updateUser(UserInfo userInfo);

}
