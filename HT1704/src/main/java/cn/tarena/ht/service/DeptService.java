package cn.tarena.ht.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.User;

public interface DeptService {
	//查询全部部门信息
	public List<Dept> findAll();
	//状态更改
	public void updateState(String[] deptId, int state);
	//批量删除
	public void deleteDept(String[] deptId);
	//查询上级部门信息
	public List<Dept> findParent();
	//新增部门
	public void saveDept(Dept dept);
	//查看部门
	public Dept findOne(String deptId);
	//修改部门
	public void updateDept(Dept dept);
	
	
}
