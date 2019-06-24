<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Đăng nhập</h2>
<p style="color:red;">${ message }</p>
<form method="POST" action='<c:url value="/login" />' id="frmLogin">
	<div class="control-group ">
		<label class="control-label">Email</label>
		<div class="controls">
			<input type="email" id="email" name="email">
		</div>
	</div>
	<div class="control-group ">
		<label class="control-label">Mật khẩu</label>
		<div class="controls">
			<input type="password" id="password" name="password">
		</div>
	</div>
	<div class="form-actions">
		<button class="btn btn-success" type="submit">Đăng nhập</button>
	</div>
</form>