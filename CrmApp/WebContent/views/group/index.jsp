<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			<span>NHÓM VIỆC</span>
			<a href='<c:url value="/group/add" />' class="btn btn-success pull-right" >
				<i class="icon-plus icon-white"></i> Thêm mới
			</a>
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN EXAMPLE TABLE widget-->
		<div class="widget orange">
			<div class="widget-title">
				<h4>
					<i class="icon-list-ul"></i>
					Danh sách nhóm việc
				</h4>
				<span class="tools">
					<a href="javascript:;" class="icon-chevron-down"></a>
					<a href="javascript:;" class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<table class="table table-striped table-bordered" id="sample_1">
					<thead>
						<tr>
							<th>Mã nhóm việc</th>
							<th>Tên nhóm việc</th>
							<th>Mô tả</th>
							<th>Acction</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${groups}" var="item" varStatus="loop">
							<tr class="odd gradeX" id="groupRow_${ item.groupId }">
							<td>${item.groupId}</td>
							<td>${item.groupName}</td>
							<td>${item.description}</td>
							<td>
								<a class="btn btn-success" href='<c:url value="/group/task?id=${item.groupId}" />'>
									<i class="icon-ok"></i>
								</a>
								<a href='<c:url value="/group/edit?id=${item.groupId}" />'
									class="btn btn-primary btn-account-edit"> <i
										class="icon-pencil"></i>
								</a>
								<a href='<c:url value="/group/delete?id=${item.groupId}" />'
									class="btn btn-danger">
									<i class="icon-trash "></i>
								</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- END EXAMPLE TABLE widget-->
	</div>
</div>
