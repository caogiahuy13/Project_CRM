<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>

<html lang="en" style="overflow: hidden;">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
	<jsp:include page="/views/login-layout/style.jsp"></jsp:include>
	<dec:head/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->

<body>

    <section id="login">
		<div class="login_content">
			<dec:body/>
		</div>
	</section>

    <jsp:include page="/views/login-layout/script.jsp"></jsp:include>
</body>

</html>