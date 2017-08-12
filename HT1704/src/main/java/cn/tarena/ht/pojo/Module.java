package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	private String moduleId;
	private Module parentModule;//一对一关联
	private String name;//模块名称
	private Integer ctype;//模块类型
	private Integer state;//状态
	private Integer orderNo;//排序号
	private String remark;//备注信息
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", parentModule=" + parentModule + ", name=" + name + ", ctype=" + ctype
				+ ", state=" + state + ", orderNo=" + orderNo + ", remark=" + remark + ", getModuleId()="
				+ getModuleId() + ", getParentModule()=" + getParentModule() + ", getName()=" + getName()
				+ ", getCtype()=" + getCtype() + ", getState()=" + getState() + ", getOrderNo()=" + getOrderNo()
				+ ", getRemark()=" + getRemark() + ", getCreateBy()=" + getCreateBy() + ", getCreateDept()="
				+ getCreateDept() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()=" + getUpdateBy()
				+ ", getUpdateTime()=" + getUpdateTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
