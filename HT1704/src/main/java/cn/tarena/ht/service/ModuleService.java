package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {
	public List<Module> findAll();

	public void updateState(String[] moduleIds, int state);

	public void deleteModule(String[] moduleId);

	public List<Module> findParent();

	public void saveModule(Module module);

	public Module findOne(String moduleId);

	public void updateModule(Module module);
}
