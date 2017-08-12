package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserMapper {
	//查询用户列表信息
	public List<User> findAll();
	//状态修改
	public void updateState(@Param("userIds")String[] userIds, @Param("state")int state);
	//批量删除
	public void deleteUser(String[] userId);
	//新增用户
	public void saveUser(User user);
	//根据id查询用户
	public User findOne(String userId);
	//更新用户
	public void updateUser(User user);
	@Insert("insert into role_user_p (role_id,user_id) values(#{roleId},#{userId})")
	public void saveRoleUser(@Param("userId")String userId,@Param("roleId")String roleId);
	@Delete("delete from role_user_p where user_id=#{userId}")
	public void deleteRoleUserByUserId(String userId);
	
}
