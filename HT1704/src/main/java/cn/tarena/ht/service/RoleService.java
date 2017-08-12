package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> findAll();
	//批量删除
	public void deleteRole(String[] roleId);
	//新增角色
	public void saveRole(Role role);
	
	public Role findOne(String roleId);
	
	public void updateRole(Role role);
	
	public List<String> findRoleIdByUserId(String userId);
}
