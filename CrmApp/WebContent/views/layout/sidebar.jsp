<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="sidebar" class="nav-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->
	<ul class="sidebar-menu">
		<li class="sub-menu"><a class="#"> <i class="icon-dashboard"></i>
				<span>Dashboard</span>
		</a></li>
		<li class="sub-menu"><a href='<c:url value="/account" />' class=""> <i
				class="icon-book"></i> <span>Thành viên</span>
		</a></li>
		<li class="sub-menu"><a href='<c:url value="/group" />' class=""> <i
				class="icon-tasks"></i> <span>Nhóm việc</span>
		</a></li>
	</ul>
	<!-- END SIDEBAR MENU -->
</div>