package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public void deleteRole(String[] roleId) {
		roleMapper.deleteRole(roleId);
	}

	@Override
	public void saveRole(Role role) {
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		roleMapper.saveRole(role);
	}

	@Override
	public Role findOne(String roleId) {
		
		return roleMapper.findOne(roleId);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public List<String> findRoleIdByUserId(String userId) {
		return roleMapper.findRoleIdByUserId(userId);
	}
	
	
}
