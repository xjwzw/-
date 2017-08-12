package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;

@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleMapper moduleMapper;
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}
	@Override
	public void updateState(String[] moduleIds, int state) {
		moduleMapper.updateState(moduleIds,state);
	}
	@Override
	public void deleteModule(String[] moduleId) {
		moduleMapper.deleteModule(moduleId);
	}
	
	@Override
	public void saveModule(Module module) {
		module.setModuleId(UUID.randomUUID().toString());		
		moduleMapper.saveModule(module);
	}
	@Override
	public List<Module> findParent() {
		return moduleMapper.findParent();
	}
	@Override
	public Module findOne(String moduleId) {
		return moduleMapper.findOne(moduleId);
	}
	@Override
	public void updateModule(Module module) {
		Date date=new Date();
		module.setUpdateTime(date);
		moduleMapper.updateModule(module);
	}
	
	
}
