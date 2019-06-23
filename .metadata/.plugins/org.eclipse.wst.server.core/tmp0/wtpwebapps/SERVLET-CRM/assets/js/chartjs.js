var Script = function() {
	var pieData = [ {
		value : 119,
		color : "#4A8BC2"
	}, {
		value : 215,
		color : "#74B749"
	}, {
		value : 300,
		color : "#F37B53"
	}

	];
	var barChartData = {
		labels : [ "Chưa thực hiện", "Đang thực hiện", "Hoàn thành" ],
		datasets : [ {
			fillColor : "#d5d5d5",
			strokeColor : "rgba(220,220,220,1)",
			data : [ 119, 215, 300 ]
		} ]

	};
	new Chart(document.getElementById("bar").getContext("2d"))
			.Bar(barChartData);
	new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);

}();