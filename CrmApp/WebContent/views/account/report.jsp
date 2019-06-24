<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12" style="margin-top: 20px;">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3>
			<span class="icon-user"></span>
			<span>${account.fullname}</span>
			</h1>
			<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<div class="bs-docs-example">
	<div class="row-fluid">
		<div class="span6">
			<c:forEach items="${statusCounts}" var="statusCount">
				<c:choose>
					<c:when test="${statusCount.statusId == 1}">
						<input type="hidden" id="countNonProcess" value="${statusCount.count}"/>
					</c:when>
					<c:when test="${statusCount.statusId == 2}">
						<input type="hidden" id="countProcess" value="${statusCount.count}"/>
					</c:when>
					<c:otherwise>
						<input type="hidden" id="countSuccess" value="${statusCount.count}"/>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- BEGIN CHART PORTLET-->
			<div class="widget green">
				<div class="widget-title">
					<h4>
						<i class=" icon-bar-chart"></i>
						Biểu đồ hình tròn
					</h4>
					<span class="tools">
						<a href="javascript:;" class="icon-chevron-down"></a>
						<a href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body">
					<div class="text-center">
						<canvas id="pie" height="300" width="400"
							style="width: 400px; height: 300px;"></canvas>
					</div>
				</div>
			</div>
			<!-- END CHART PORTLET-->
		</div>
		<div class="span6">
			<!-- BEGIN CHART PORTLET-->
			<div class="widget blue">
				<div class="widget-title">
					<h4>
						<i class="icon-bar-chart"></i>
						Biểu đồ cột
					</h4>
					<span class="tools">
						<a href="javascript:;" class="icon-chevron-down"></a>
						<a href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body">
					<div class="text-center">
						<canvas id="bar" height="300" width="500"
							style="width: 500px; height: 300px;"></canvas>
					</div>
				</div>
			</div>
			<!-- END CHART PORTLET-->
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12" style="margin-bottom: 10px">
			<!-- BEGIN PAGE TITLE & BREADCRUMB-->
			<h3 style="display: inline-block;">
				<img src="<c:url value="/assets/img/avatar1_small.jpg"/>" alt="">
				<span>${account.fullname}</span>
			</h3>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<!-- BEGIN BLANK PAGE PORTLET-->
			<div class="widget blue">
				<div class="widget-title">
					<h4>
						<i class="icon-legal"></i>
						Chưa thực hiện
					</h4>
					<span class="tools">
						<a href="javascript:;" class="icon-chevron-down"></a>
						<a href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body">
					<c:forEach items="${groupTask.tasks}" var="task">
						<c:if test="${task.statusId == 1}">
							<div class="alert alert-block alert-custom">
								<h5>${task.name}</h5>
								<div class="row-fluid">
									<span class="span6">
										<i class="icon-calendar"></i>
										${task.endDate}
									</span>
									<span class="span6">
										<i class="icon-user"></i>
										${account.fullname}
									</span>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!-- END BLANK PAGE PORTLET-->
		</div>
		<div class="span4">
			<!-- BEGIN BLANK PAGE PORTLET-->
			<div class="widget green">
				<div class="widget-title">
					<h4>
						<i class="icon-refresh"></i>
						Đang thực hiện
					</h4>
					<span class="tools">
						<a href="javascript:;" class="icon-chevron-down"></a>
						<a href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body">
					<c:forEach items="${groupTask.tasks}" var="task">
						<c:if test="${task.statusId == 2}">
							<div class="alert alert-block alert-success alert-custom">
								<h5>${task.name}</h5>
								<div class="row-fluid">
									<span class="span6">
										<i class="icon-calendar"></i>
										${task.endDate}
									</span>
									<span class="span6">
										<i class="icon-user"></i>
										${account.fullname}
									</span>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!-- END BLANK PAGE PORTLET-->
		</div>
		<div class="span4">
			<!-- BEGIN BLANK PAGE PORTLET-->
			<div class="widget orange">
				<div class="widget-title">
					<h4>
						<i class="icon-ok"></i>
						Hoàn thành
					</h4>
					<span class="tools">
						<a href="javascript:;" class="icon-chevron-down"></a>
						<a href="javascript:;" class="icon-remove"></a>
					</span>
				</div>
				<div class="widget-body">
					<c:forEach items="${groupTask.tasks}" var="task">
						<c:if test="${task.statusId == 3}">
							<div class="alert alert-block alert-primary alert-custom">
								<h5>${task.name}</h5>
								<div class="row-fluid">
									<span class="span6">
										<i class="icon-calendar"></i>
										${task.endDate}
									</span>
									<span class="span6">
										<i class="icon-user"></i>
										${account.fullname}
									</span>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!-- END BLANK PAGE PORTLET-->
		</div>
	</div>
</div>
