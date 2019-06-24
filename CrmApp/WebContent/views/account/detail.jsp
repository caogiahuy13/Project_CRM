<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			<img src="<c:url value="/assets/img/avatar1_small.jpg"/>" alt="">
			<span>${account.fullname}</span>
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
	<div class="span6">
		<!-- BEGIN CHART PORTLET-->
		<div class="widget green">
			<div class="widget-title">
				<h4>
					<i class=" icon-bar-chart"></i>
					Thông tin cá nhân
				</h4>
				<span class="tools">
					<a href="javascript:;" class="icon-chevron-down"></a>
					<a href="javascript:;" class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<div class="row-fluid about-us">
					<div class="span4">
						<img src="<c:url value="/assets/img/about-us/img-1.jpg"/>" alt="">
					</div>
					<div class="span8">
						<div class="info terques">
							<h1>${account.fullname}</h1>
							<p style="text-transform: lowercase;">${account.email}</p>
							<div class="social-links">
								<a href="#">
									<i class="icon-facebook"></i>
								</a>
								<a href="#">
									<i class="icon-twitter"></i>
								</a>
								<a href="#">
									<i class="icon-google-plus"></i>
								</a>
								<a href="#">
									<i class="icon-youtube"></i>
								</a>
								<a href="#">
									<i class="icon-pinterest"></i>
								</a>
								<a href="#">
									<i class="icon-linkedin"></i>
								</a>

							</div>
						</div>

					</div>
					<div class="space10"></div>
					<p>Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Donec ut volutpat metus.
						Aliquam tortor lorem, fringilla tempor dignissim at, pretium et
						arcu. Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium.</p>

				</div>
			</div>
		</div>
		<!-- END CHART PORTLET-->
	</div>
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
		<div class="widget blue">
			<div class="widget-title">
				<h4>
					<i class="icon-bar-chart"></i>
					Thống kê công việc
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