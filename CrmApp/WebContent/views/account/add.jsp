<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<!-- BEGIN PAGE HEADER-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title text-center">
			<span>THÊM MỚI THÀNH VIÊN</span>
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<br>
<!-- END PAGE HEADER-->
<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
	<div class="span12">
		<!-- BEGIN EXAMPLE TABLE widget-->
		<div class="widget orange">
			<div class="widget-title">
				<h4>
					<i class="icon-list-ul"></i> Thêm mới thành viên
				</h4>
				<span class="tools"> <a href="javascript:;"
					class="icon-chevron-down"></a> <a href="javascript:;"
					class="icon-remove"></a>
				</span>
			</div>
			<div class="widget-body">
				<form action='<c:url value="/account/add"/>' method="post">
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Email</label>
								<div class="controls">
									<input type="text" class="span12" id="email" name="email">
								</div>
							</div>
							<div class="control-group password-group">
								<label class="control-label">Mật khẩu</label>
								<div class="controls">
									<input type="password" class="span12" id="password" name="password">
								</div>
							</div>
							<div class="control-group password-group">
								<label class="control-label">Nhập lại mật khẩu</label>
								<div class="controls">
									<input type="password" class="span12" id="confirm" name="confirm">
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Họ tên</label>
								<div class="controls">
									<input type="text" class="span12" id="fullname" name="fullname">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Số điện thoại</label>
								<div class="controls">
									<input type="text" class="span12" id="phone" name="phone">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa chỉ</label>
								<div class="controls">
									<input type="text" class="span12" id="address" name="address">
								</div>
							</div>
						</div>
						<div class="span12">
							<button class="btn btn-success">
								<i class="icon-ok icon-white"></i> Lưu lại
							</button>
							<a href='<c:url value="/account" />' class="btn btn-secondary">
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