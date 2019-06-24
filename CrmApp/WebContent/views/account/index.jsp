<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			<span>QUẢN LÝ THÀNH VIÊN</span><br/>
			<a href='<c:url value="/account/add" />' class="btn btn-success" >
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
					<i class="icon-list-ul"></i> Danh sách thành viên
				</h4>
				<span class="tools"> <a href="javascript:;"
					class="icon-chevron-down"></a> <a href="javascript:;"
					class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<table class="table table-striped table-bordered" id="sample_1">
					<thead>
						<tr>
							<th>STT</th>
							<th>Họ tên</th>
							<th>Email</th>
							<th>Điện thoại</th>
							<th>Địa chỉ</th>
							<th>Acction</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ accounts }" var="item" varStatus="loop">
						<tr class="odd gradeX">
							<td>${ loop.index + 1 }</td>
							<td>${ item.fullname }</td>
							<td>${ item.email }</td>
							<td>${ item.phone }</td>
							<td>${ item.address }</td>
							<td>
								<a href='<c:url value="/account/edit?id=${ item.id }" />'
									class="btn btn-primary btn-account-edit"> <i
										class="icon-pencil"></i>
								</a>
								<a href='<c:url value="/account/delete?id=${ item.id }" />'
									class="btn btn-danger">
									<i class="icon-trash "></i>
								</a>
								<a class="btn btn-success"
									href='<c:url value="/account/report?id=${ item.id }" />'> 
									<i class="icon-ok"></i>
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
<!-- END ADVANCED TABLE widget-->