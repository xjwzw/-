package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {

	public List<Dept> findAll();
	//修改状态 通过注解封装为Map
	public void updateState(@Param("deptIds")String[] deptIds, @Param("state")int state);
	
	//批量删除
	public void deleteDept(String[] deptId);
	//查询上级部门
	public List<Dept> findParent();
	//新增用户
	public void saveDept(Dept dept);
	//部门查看
	public Dept findOne(String deptId);
	//部门修改
	public void updateDept(Dept dept);
	
	
}
