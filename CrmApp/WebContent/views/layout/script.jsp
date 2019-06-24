<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- BEGIN JAVASCRIPTS -->
<script src="<c:url value="/assets/js/jquery-1.8.3.min.js" />"></script>
<script src="<c:url value="/assets/js/jquery.nicescroll.js" />" type="text/javascript"></script>
<script src="https://unpkg.com/popper.js"></script>
<script src="<c:url value="/assets/plugins/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/assets/js/jquery.blockui.js" />"></script>
<script src="<c:url value="/assets/js/jquery.validate.min.js" />"></script>
<script src="<c:url value="/assets/plugins/chart-master/Chart.js" />"></script>
<script src="<c:url value="/assets/plugins/toastr/toastr.min.js" />"></script>
<!-- ie8 fixes -->
<!--[if lt IE 9]>
<script src="js/excanvas.js"></script>
<script src="js/respond.js"></script>
<![endif]-->
<script type="text/javascript" src="<c:url value="/assets/plugins/uniform/jquery.uniform.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/plugins/data-tables/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/plugins/data-tables/DT_bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/plugins/chosen-bootstrap/chosen/chosen.jquery.min.js" />"></script>
<!--script for this page only-->
<script src="<c:url value="/assets/js/dynamic-table.js" />"></script>
<script src="<c:url value="/assets/js/chartjs2.js"/>"></script>
<script src="<c:url value="/assets/js/common-scripts.js"/>"></script>

<script type="text/javascript" src="<c:url value="plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"/>"></script>
<script type="text/javascript" src="<c:url value="plugins/bootstrap-daterangepicker/date.js"/>"></script>
<script type="text/javascript" src="<c:url value="plugins/bootstrap-daterangepicker/daterangepicker.js"/>"></script>
<script src="<c:url value="js/custom.js"/>"></script>

    
<script>
/*   	$.ajax({
  		url: "http://localhost:8080/CrmApp/json", 
  		type: "GET",
  		dataType: "json"
  	})
  	.done(function(data) {
	var tbody = $('#tbody');
	
	var html = '';
	
	for(var i = 0; i < data.length; i++){
		console.log(data[i].fullname)
		html += `
			<tr>
				<td>${ i + 1 }</td>
				<td>${ data[i].fullname }</td>
				<td>${ data[i].email }</td>
				<td>${ data[i].phone }</td>
				<td>${ data[i].address }</td>
				<td>
					<a class="btn btn-primary btn-account-edit"> <i
							class="icon-pencil"></i>
					</a>
					<a class="btn btn-danger">
						<i class="icon-trash "></i>
					</a>
					<a class="btn btn-success"
						href="#"> 
						<i class="icon-ok"></i>
					</a> 
				</td>
			<tr>
		`;
	}
	
	tbody.html(html);
	})
	.fail(function(err) {
		console.log(err);
	}) */
</script>
    