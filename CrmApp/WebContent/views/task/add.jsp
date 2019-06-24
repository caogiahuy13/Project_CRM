<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title text-center">
			<span>THÊM ĐẦU VIỆC</span>
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
					<i class="icon-list-ul"></i> Thêm đầu việc
				</h4>
				<span class="tools"> <a href="javascript:;"
					class="icon-chevron-down"></a> <a href="javascript:;"
					class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<p class="text-center" style="color:red;">${ message }</p>
				<form action='<c:url value="/task/add"/>' method="post">
					<div class="row-fluid">
						<div class="span12s">
							<input type="hidden" name="group_id" value="${group.groupId}">
							<div class="control-group">
								<label class="control-label">Tên công việc</label>
								<div class="controls">
									<input type="text" class="span12" id="name" name="name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Ngày kết thúc</label>
								<div class="controls">
									<input type="text" class="span12" id="end_date" name="end_date">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Người thực hiện</label>
								<div class="controls row-fluid">
									<select class="span12 chzn-select" name="account_id"
										id="account_id" data-placeholder="Chọn người thực hiện"
										tabindex="1">
										<c:forEach items="${accounts}" var="item">
											<option value="${item.id}">${item.fullname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Trạng thái</label>
								<div class="controls row-fluid">
									<select class="span12 chzn-select" name="status_id"
										id="status_id" data-placeholder="Chọn trạng thái" tabindex="1">
										<c:forEach items="${status}" var="item">
											<option value="${item.id}">${item.name}</option>
										</c:forEach>
									</select>
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