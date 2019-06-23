toastr.options = {
  "closeButton": false,
  "debug": false,
  "newestOnTop": false,
  "progressBar": false,
  "positionClass": "toast-top-right",
  "preventDuplicates": false,
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "5000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
}

function showToastr(type, message){
	toastr[type](message);
}

$(function(){
	if ($('#toastrSuccess').val()){
		showToastr("success", $('#toastrSuccess').val())
	}
	else if ($('#toastrError').val()){
		showToastr("error", $('#toastrError').val())
	}
})