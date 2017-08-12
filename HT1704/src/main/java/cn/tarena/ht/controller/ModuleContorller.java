package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleContorller {
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Module> moduleList=moduleService.findAll();
		model.addAttribute("moduleList",moduleList);
		return "/sysadmin/module/jModuleList";
		
	}
	@RequestMapping("start")
	public String toStart(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		int state=1;
		moduleService.updateState(moduleIds,state);
		return "redirect:/sysadmin/module/list";		
	}
	@RequestMapping("stop")
	public String toStop(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		int state=0;
		moduleService.updateState(moduleIds,state);
		return "redirect:/sysadmin/module/list";		
	}
	@RequestMapping("delete")
	public String delete(String [] moduleId){
		moduleService.deleteModule(moduleId);
		return "redirect:/sysadmin/module/list";
		
	}
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		List<Module> moduleList=moduleService.findParent();
		model.addAttribute("moduleList",moduleList);
		return "/sysadmin/module/jModuleCreat";
	}
	@RequestMapping("save")
	public String save(Module module){
		moduleService.saveModule(module);
		return "redirect:/sysadmin/module/list";
	}
	//转向修改页面
	@RequestMapping("toupdate")
	public String toUpdate(String moduleId,Model model){
			List<Module> moduleList=moduleService.findParent();			
			Module module=moduleService.findOne(moduleId);
			System.out.println(module);
			model.addAttribute("moduleList", moduleList);
			model.addAttribute("module", module);
			
			return "/sysadmin/module/jModuleUpdate";
	}
	@RequestMapping("update")
	public String updateModule(Module module){
		moduleService.updateModule(module);
		
		return "redirect:/sysadmin/module/list";
	}
	@RequestMapping("toview")
	public String ViewModule(String moduleId,Model model){
		Module module=moduleService.findOne(moduleId);
		model.addAttribute("module", module);
		return "/sysadmin/module/jModuleView";
	}
}
