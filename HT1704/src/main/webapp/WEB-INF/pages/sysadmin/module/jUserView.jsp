<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户查看</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick=" window.history.go(-1);">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户查看
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >	
	<tr class="odd">
		<td>用户编号：</td>
		<td>${user.userId}</td>
		<td>用户名称：</td>
		<td>${user.username}</td>
	</tr>
	<tr class="odd">
		<td>所属部门：</td>
		<td>${user.userInfo.name}</td>
		<td>真实姓名：</td>
		<td>${user.dept.deptName}</td>
	</tr>
	<tr class="odd">
		<td>身份证号：</td>
		<td>${user.userInfo.cardNo}</td>
		<td>上级领导：</td>
		<td>${user.userInfo.manager.name}</td>
	</tr>	
	<tr class="odd">
		<td>入职日期：</td>
		<td>					   		
	      <fmt:formatDate value="${user.userInfo.joinDate }" pattern="yyyy-MM-dd"/>	 
		</td>
		<td>薪资：</td>
		<td>${user.userInfo.salary}</td>
	</tr>
	<tr class="odd">
		<td>出生日期：</td>		
		<td>
	   	<fmt:formatDate value="${user.userInfo.birthday }" pattern="yyyy-MM-dd"/>
		</td>
		<td>性别：</td>
		<td>			
			<c:if test="${user.userInfo.gender=='男'}">男</c:if>
			<c:if test="${user.userInfo.gender=='女'}">女</c:if>
		</td>		
	</tr>
	<tr class="odd">
		<td>岗位描述：</td>
		<td>${user.userInfo.station}</td>
		<td>电话号码：</td>
		<td>${user.userInfo.telephone}</td>		
	</tr>	
	<tr class="odd">
		<td>用户级别：</td>
		<td>						
			<c:if test="${user.userInfo.userLevel==4 }">普通用户</c:if>
			<c:if test="${user.userInfo.userLevel==1 }">总经理</c:if>
			<c:if test="${user.userInfo.userLevel==2 }">副总经理</c:if>
			<c:if test="${user.userInfo.userLevel==3 }">部门经理</c:if>
		</td>
		<td>排序号：</td>
		<td>${user.userInfo.orderNo} </td>		
	</tr>
	<tr class="odd">
		<td>状态：</td>
		<td>
			<c:if test="${user.state==1 }">启用</c:if>
			<c:if test="${user.state==0 }">停用</c:if>
		</td><tr class="odd">
		<td>备注信息：</td>
		<td>
			${user.userInfo.remark}		
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

