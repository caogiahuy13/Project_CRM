<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- BEGIN TOP NAVIGATION BAR -->
<div class="navbar-inner">
	<div class="container-fluid">
		<!-- BEGIN LOGO -->
		<a class="brand" href='<c:url value="/account" />'> <span>C-R-M</span>
		</a>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a class="btn btn-navbar collapsed" id="main_menu_trigger"
			data-toggle="collapse" data-target=".nav-collapse"> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span> <span class="arrow"></span>
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<div id="top_menu" class="nav notify-row">
			<!-- BEGIN NOTIFICATION -->
			<ul class="nav top-menu">
				<!-- BEGIN SETTINGS -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="icon-tasks"></i> <span
						class="badge badge-important">6</span>
				</a></li>
				<!-- END SETTINGS -->
				<!-- BEGIN INBOX DROPDOWN -->
				<li class="dropdown" id="header_inbox_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-envelope-alt"></i> <span class="badge badge-important">5</span>
				</a></li>
				<!-- END INBOX DROPDOWN -->
				<!-- BEGIN NOTIFICATION DROPDOWN -->
				<li class="dropdown" id="header_notification_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-bell-alt"></i> <span class="badge badge-warning">7</span>
				</a></li>
				<!-- END NOTIFICATION DROPDOWN -->

			</ul>
		</div>
		<!-- END  NOTIFICATION -->
		<div class="top-nav ">
			<ul class="nav pull-right top-menu">
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <img src="<c:url value="/assets/img/avatar1_small.jpg"/>"
						alt=""> <span class="username">Cybersoft</span> <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						<li><a href="<c:url value="/account/detail"/>"><i class="icon-user"></i> Thông tin cá
								nhân</a></li>
						<li><a href="#"><i class="icon-cog"></i> Cài đặt</a></li>
						<li><a href='<c:url value="/logout" />'><i class="icon-key"></i> Thoát</a></li>
					</ul></li>
				<!-- END USER LOGIN DROPDOWN -->
			</ul>
			<!-- END TOP NAVIGATION MENU -->
		</div>
	</div>
</div>
<!-- END TOP NAVIGATION BAR -->