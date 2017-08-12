package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	public List<Module> findAll();
	
	public void updateState(@Param("moduleIds") String[] moduleIds, @Param("state")int state);

	public void deleteModule(String[] moduleId);
	@Select("select * from module_p")
	public List<Module> findParent();

	public void saveModule(Module module);

	public Module findOne(String moduleId);

	public void updateModule(Module module);
}
