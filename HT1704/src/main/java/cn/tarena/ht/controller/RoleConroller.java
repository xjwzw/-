package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("sysadmin/role")
public class RoleConroller {
	@Autowired
	private RoleService roleService;
	//查詢角色列表信息
	@RequestMapping("list")
	public String findAll(Model model){
		List<Role> roleList=roleService.findAll();
		model.addAttribute("roleList",roleList);
		
		return "sysadmin/role/jRoleList";
	}
	@RequestMapping("delete")
	public String deleteRole(String []roleId){
		roleService.deleteRole(roleId);
		
		return "redirect:/sysadmin/role/list";
	}
	//跳转到新增页面
	@RequestMapping("tocreate")
	public String toCreat(){
		
		return "sysadmin/role/jRoleCreat";
	}
	//新增角色
	@RequestMapping("save")
	public String saveRole(Role role){
		roleService.saveRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	//跳转到修改界面
	@RequestMapping("toupdate")
	public String toUpdate(String roleId,Model model){
		Role role=roleService.findOne(roleId);
		System.out.println(role);
		model.addAttribute("role",role);
		return "sysadmin/role/jRoleUpdate";
	}
	@RequestMapping("update")
	public String updateRole(Role role){
		roleService.updateRole(role);
		return "redirect:/sysadmin/role/list";
	}
	@RequestMapping("toview")
	public String toView(String roleId,Model model){
		Role role=roleService.findOne(roleId);
		model.addAttribute(role);		
		return "sysadmin/role/jRoleView";
	}
}
