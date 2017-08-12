package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	//查询全部角色信息
	@Select("select * from role_p order by order_no")
	public List<Role> findAll();
	//批量删除
	public void deleteRole(String[] roleId);
	//角色新增
	public void saveRole(Role role);
	@Select("select * from role_p where role_id=#{roleId}")
	public Role findOne(String roleId);
	//角色更新
	public void updateRole(Role role);
	
	@Select("select role_id from role_user_p where user_id=#{userId} ")
	public List<String> findRoleIdByUserId(String userId);
}
