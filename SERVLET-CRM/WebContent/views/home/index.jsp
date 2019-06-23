<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- BEGIN PAGE HEADER-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                        <h3 class="page-title">
                            <span>THÀNH VIÊN</span>
                            <button class="btn btn-success pull-right" data-toggle="modal" data-target="#account-modal">
                                <i class="icon-plus icon-white"></i> Thêm mới
                            </button>
                        </h3>
                        <!-- END PAGE TITLE & BREADCRUMB-->
                    </div>
                </div>
                <!-- END PAGE HEADER-->
                <!-- BEGIN ADVANCED TABLE widget-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN EXAMPLE TABLE widget-->
                        <div class="widget orange">
                            <div class="widget-title">
                                <h4>
                                    <i class="icon-list-ul"></i> Danh sách thành viên
                                </h4>
                                <span class="tools"> <a href="javascript:;" class="icon-chevron-down"></a> <a
                                        href="javascript:;" class="icon-remove"></a>
                                </span>
                            </div>
                            <div class="widget-body">
                                <table class="table table-striped table-bordered" id="sample_1">
                                    <thead>
                                        <tr>
                                            <th>Họ tên</th>
                                            <th class="hidden-phone">Email</th>
                                            <th class="hidden-phone">Điện thoại</th>
                                            <th class="hidden-phone">Địa chỉ</th>
                                            <th class="hidden-phone">Acction</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td>Nguyễn Văn A</td>
                                            <td class="hidden-phone">nguyenvana@gmail.com</td>
                                            <td class="hidden-phone">012345678</td>
                                            <td class="center hidden-phone">02 Mạc Đĩnh Chi - Đa Kao - Q.1 - Tp.HCM</td>
                                            <td class="hidden-phone">
                                                <a class="btn btn-success" href="thong-ke-thanh-vien.html">
                                                    <i class="icon-ok"></i>
                                                </a>
                                                <a href="chi-tiet-thanh-vien.html"
                                                    class="btn btn-primary btn-account-edit">
                                                    <i class="icon-pencil"></i>
                                                </a>

                                                <button type="button"
                                                    class="btn btn-danger btn-account-delete">
                                                    <i class="icon-trash "></i>
                                                </button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END EXAMPLE TABLE widget-->
                    </div>
                </div>
                <!-- END ADVANCED TABLE widget-->

                <!-- MY MODAL -->
                <div class="my-modal" id="account-modal">
                    <div class="modal-content modal-4">
                        <div class="widget orange">
                            <div class="widget-title">
                                <h4>Thêm thành viên</h4>
                                <span class="tools"> <a href="javascript:;" data-dismiss="modal"
                                        class="icon-resize-small modal-close"></a>
                                </span>
                            </div>
                            <div class="widget-body">
                                <form action="" method="post" id="frmAccount">
                                    <div class="row-fluid">
                                        <div class="span12">

                                            <input type="hidden" class="span12" id="account_id" name="account_id">

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
                                                    <input type="password" class="span12" id="c" name="confirm">
                                                </div>
                                            </div>
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
                                    </div>
                                    <div class="widget-footer">
                                        <button type="button" class="btn modal-close" data-dismiss="modal">
                                            <i class="icon-ban-circle icon-white"></i> Hủy
                                        </button>
                                        <button class="btn btn-success">
                                            <i class="icon-ok icon-white"></i> Lưu lại
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- END MY MODAL -->

</body>
</html>