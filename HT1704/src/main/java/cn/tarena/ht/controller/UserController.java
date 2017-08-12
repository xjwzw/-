package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	//查询用户列表信息
	@RequestMapping("list")
	public String findAll(Model model){
		List<User> userList=userService.findAll();
		model.addAttribute("userList", userList);		
		return "/sysadmin/user/jUserList";
	}
	//状态启用
	@RequestMapping("start")
	public String toStart(@RequestParam(value="userId",required=true)String[] userIds){
		int state=1;
		userService.updateState(userIds,state);		
		return "redirect:/sysadmin/user/list";
	}
	//状态停用
	@RequestMapping("stop")
	public String toStop(@RequestParam(value="userId",required=true)String [] userIds){
		int state=0;
		userService.updateState(userIds,state);		
		return "redirect:/sysadmin/user/list";
	}
	//批量删除
	@RequestMapping("delete")
	public String deleteUser(String [] userId){
		userService.deleteUser(userId);		
		return "redirect:/sysadmin/user/list";
	}
	
	//跳转到新增页面
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		List<UserInfo> userInfoList=userService.findUserInfo();
		List<Dept> deptList=deptService.findParent();		
		model.addAttribute("userInfoList",userInfoList);
		model.addAttribute("deptList", deptList);
		
		return "/sysadmin/user/jUserCreat";
	}
	//新增用户
	@RequestMapping("save")
	public String save(User user){
		System.out.println(user);
			userService.saveUser(user);
		return "redirect:/sysadmin/user/list";
	}
	//跳到修改页面
	@RequestMapping("toupdate")
	public String toUpdate(String userId,Model model){
		//准备上级部门
		List<Dept> deptList=deptService.findParent();
		//准备上级领导
		List<UserInfo> infoList=userService.findManagerList(userId);
		//根据userId，查询信息
		User userMsg=userService.findOne(userId);
		
		UserInfo info=userMsg.getUserInfo();
		model.addAttribute("deptList",deptList);
		model.addAttribute("infoList", infoList);
		model.addAttribute("userMsg", userMsg);
		model.addAttribute("info", info);
		return "/sysadmin/user/jUserUpdate";
		
	}
	@RequestMapping("update")
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("toview")
	public String toView(String userId,Model model){
		User user=userService.findOne(userId);
		System.out.println(user);
		model.addAttribute("user",user);
		return "/sysadmin/user/jUserView";
	}
	
	//转向角色分配页面
	@RequestMapping("role")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		
		List<Role> roleList=roleService.findAll();
		//根据userId查询角色id信息
			List<String> roleIdList=roleService.findRoleIdByUserId(userId);
			for (Role role : roleList) {
				if(roleIdList.contains(role.getRoleId())){
					role.setChecked(true);
				}
			}			
		//将roleList集合转化为jason
		ObjectMapper objectMapper=new ObjectMapper();
		String zTreeJson=objectMapper.writeValueAsString(roleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("userId",userId);
		return "/sysadmin/user/jUserRole";
	}
	@RequestMapping("saveUserRole")
	public String saveRole(String userId,String[] roleIds){
		//System.out.println(userId);
		userService.saveRoleUser(userId,roleIds);
		return "redirect:/sysadmin/user/list";
	}
}
