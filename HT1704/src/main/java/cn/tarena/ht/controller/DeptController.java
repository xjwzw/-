package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Dept> deptList=deptService.findAll();
		model.addAttribute("deptList", deptList);
		return "sysadmin/dept/jDeptList";
	}
	
	//修改状态,状态停用
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="deptId",defaultValue="-1")String[] deptIds){
		//状态的修改 state=0
		int state=0;
		deptService.updateState(deptIds,state);
		return "redirect:/sysadmin/dept/list";
	}
	
	//修改状态,状态启用
		@RequestMapping("/start")
		public String toStart(@RequestParam(value="deptId",defaultValue="-1")String[] deptIds){
			//状态的修改 state=0
			int state=1;
			deptService.updateState(deptIds,state);
			return "redirect:/sysadmin/dept/list";
		}
		
	//批量删除
		@RequestMapping("delete")
		public String deleteDept(String[] deptId){
			deptService.deleteDept(deptId);
			
			return "redirect:/sysadmin/dept/list";
		}
	//跳转到新增页面
		@RequestMapping("tocreate")
		public String toCreat(Model model){
			//准备上级部门数据
			List<Dept> deptList=deptService.findParent();
			model.addAttribute("deptList", deptList);
			return "/sysadmin/dept/jDeptCreat";
		}
		
	//新增部门
		@RequestMapping("save")
		public String saveDept(Dept dept){
			deptService.saveDept(dept);
			
			return "redirect:/sysadmin/dept/list";
		}
	//部门查看
		@RequestMapping("toview")
		public String findOne(String deptId,Model model){
			Dept dept=deptService.findOne(deptId);
			model.addAttribute("dept", dept);
			
			return "sysadmin/dept/jDeptView";
		}
		
	//部门修改	
		@RequestMapping("toupdate")
		public String toUpdate(String deptId,Model model){
			//准备上级部门
			List<Dept> deptList=deptService.findParent();
			
			Dept dept=deptService.findOne(deptId);
			
			model.addAttribute("deptList", deptList);
			model.addAttribute("dept",dept);
			
			return "sysadmin/dept/jDeptUpdate";
		}
		@RequestMapping("update")
		public String UpdateDept(Dept dept){
			deptService.updateDept(dept);
			return "redirect:/sysadmin/dept/list";			
		}
}
