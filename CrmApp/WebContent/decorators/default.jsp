<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title><dec:title /></title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <jsp:include page="/views/layout/style.jsp"></jsp:include>
    <dec:head />
</head>

<body class="fixed-top">
    <div id="header" class="navbar navbar-inverse navbar-fixed-top">
        <jsp:include page="/views/layout/navbar.jsp"></jsp:include>
    </div>
    <!-- BEGIN CONTAINER -->
    <div id="container" class="row-fluid">
        <!-- BEGIN SIDEBAR -->
        <div class="sidebar-scroll">
            <jsp:include page="/views/layout/sidebar.jsp"></jsp:include>
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN PAGE -->
        <div id="main-content">
            <!-- BEGIN PAGE CONTAINER-->
            <div class="container-fluid">
                <dec:body />
            </div>
            <!-- END ADVANCED TABLE widget-->
        </div>
    </div>
    <!-- END PAGE CONTAINER-->

    <!-- BEGIN FOOTER -->
    <div id="footer">2019 &copy; Cybersoft CRM.</div>
    <!-- END FOOTER -->

    <!-- BEGIN JAVASCRIPTS -->
    <jsp:include page="/views/layout/script.jsp"></jsp:include>

</body>

</html>