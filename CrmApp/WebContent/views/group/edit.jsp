<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title text-center">
			<span>CẬP NHẬT NHÓM VIỆC</span>
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<br>
<!-- END PAGE HEADER-->
<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
	<div class="span2"></div>
	<div class="span8">
		<!-- BEGIN EXAMPLE TABLE widget-->
		<div class="widget orange">
			<div class="widget-title">
				<h4>
					<i class="icon-list-ul"></i> Cập nhật nhóm việc
				</h4>
				<span class="tools"> <a href="javascript:;"
					class="icon-chevron-down"></a> <a href="javascript:;"
					class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<p class="text-center" style="color:red;">${ message }</p>
				<form action='<c:url value="/group/edit"/>' method="post">
					<div class="row-fluid">
						<div class="span12s">
						
							<input type="hidden" name="id" value="${group.groupId}">
							
							<div class="control-group">
								<label class="control-label">Tên nhóm việc</label>
								<div class="controls">
									<input type="text" class="span12" id="groupName" name="groupName" value="${group.groupName}">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Mô tả</label>
								<div class="controls">
									<input type="text" class="span12" id="description" name="description" value="${group.description}">
								</div>
							</div>
						</div>
						<div class="span12">
							<button class="btn btn-success">
								<i class="icon-ok icon-white"></i> Lưu lại
							</button>
							<a href='<c:url value="/group" />' class="btn btn-secondary">
								<i class="icon-ban-circle icon-white"></i> Quay lại
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- END EXAMPLE TABLE widget-->
	</div>
</div>
<!-- END ADVANCED TABLE widget-->