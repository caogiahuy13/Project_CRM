<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title/></title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="assets/plugins/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet" />
    <link href="assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/style-responsive.css" rel="stylesheet" />
    <link href="assets/css/style-default.css" rel="stylesheet" id="style_color" />
    <link href="assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
    <link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet" />
    <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="assets/plugins/chosen-bootstrap/chosen/chosen.css" />
    <link rel="stylesheet" type="text/css" href="assets/plugins/bootstrap-datepicker/css/datepicker.css" />
    <link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body class="fixed-top">

	<!-- HEADER -->
	<jsp:include page="/views/layout/header.jsp"/>
	
	<div id="container" class="row-fluid">
		<!-- SIDEBAR -->
		<jsp:include page="/views/layout/sidebar.jsp"/>
		
		<!-- BEGIN PAGE -->
        <div id="main-content">
        	<!-- BEGIN PAGE CONTAINER-->
            <div class="container-fluid">
            	<dec:body/>
            </div>
        </div>
	</div>
	
	<!-- FOOTER -->
	<jsp:include page="/views/layout/footer.jsp"/>

    <!-- BEGIN JAVASCRIPTS -->
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="https://unpkg.com/popper.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.blockui.js"></script>
    <script src="assets/js/jquery.validate.min.js"></script>
    <script src="assets/plugins/chart-master/Chart.js"></script>
    <script src="assets/plugins/toastr/toastr.min.js"></script>
    <!-- ie8 fixes -->
    <!--[if lt IE 9]>
   <script src="assets/js/excanvas.js"></script>
   <script src="assets/js/respond.js"></script>
   <![endif]-->
    <script type="text/javascript" src="assets/plugins/uniform/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="assets/plugins/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/plugins/data-tables/DT_bootstrap.js"></script>
    <script type="text/javascript" src="assets/plugins/chosen-bootstrap/chosen/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/custom.js"></script>
    <!--script for this page only-->
    <script src="assets/js/dynamic-table.js"></script>

</body>
</html>