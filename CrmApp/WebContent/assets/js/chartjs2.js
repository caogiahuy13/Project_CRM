var Script = function() {
	var countNonProcess = 0;
	var countProcess = 0;
	var countSuccess = 0;
	
	if($('#countNonProcess').val()){
		countNonProcess = Number($('#countNonProcess').val());
	}
	if($('#countProcess').val()){
		countProcess = Number($('#countProcess').val());
	}
	if($('#countSuccess').val()){
		countSuccess = Number($('#countSuccess').val());
	}
	var pieData = [ {
		value : countNonProcess,
		color : "#4A8BC2"
	}, {
		value : countProcess,
		color : "#74B749"
	}, {
		value : countSuccess,
		color : "#F37B53"
	}

	];
	var barChartData = {
		labels : [ "Chưa thực hiện", "Đang thực hiện", "Hoàn thành" ],
		datasets : [ {
			fillColor : "#d5d5d5",
			strokeColor : "rgba(220,220,220,1)",
			data : [ countNonProcess, countProcess, countSuccess ]
		} ]

	};
	new Chart(document.getElementById("bar").getContext("2d"))
			.Bar(barChartData);
	new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);

}();