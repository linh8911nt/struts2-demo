<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>View content</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	function report() {
		$.ajax({
			type : "get",
			url : "contentJson",
			success : function(data) {
				var tblData="";
				$.each(data.contents, function() { 
					var date = this.createDate.substring(0,10);
					tblData += "<tr><td>" + this.id + "</td>" + 
					"<td>" + this.title + "</td>" + 
					"<td>" + this.brief + "</td>" + 
					"<td>" + date + "</td>" +
					"<td>"+
					"<button onclick='getOldContent(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
					"</td>"+
					"<td>" + "<button onclick='deleteContent(this);' class='btn btn-sm btn-danger'>Delete</button>"+
					"</td></tr>" ;
				});
				$("#tbody").html(tblData);
			}
		});
	}
	
	function getOldContent(that){
		let id = $(that).closest("tr").find("td:first-child").text();
		$.ajax({
			type : "get",
			url : "getContentJson",
			data : "id=" + id,
			success : function(data) {
				$("#hiddencontentid").val(data.content.id);
				$("#title").val(data.content.title);
				$("#brief").val(data.content.brief);
				$("#content").val(data.content.content); 
			}
		});
	}
	
	function updateNewRecord(){
		$.ajax({
			type : "post",
			url : "updateContentJson",
			data : "id="+$("#hiddencontentid").val()+"&title="+$("#title").val()+"&brief="+$("#brief").val()+
       	 			"&content="+$("#content").val(),
			success : function(data) {
				$("#resp").html(data.message);				
			}
		});
	}

	$(function(){
		$('.normal').autosize();
		$('.animated').autosize({append: "\n"});
	});
</script>
</head>

<body onload="report();">

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">CMS</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="ViewContents"><i class="fa fa-table fa-fw"></i>
								View contents</a></li>
						<li><a href="add-content"><i class="fa fa-edit fa-fw"></i>
								Form content</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">View Content</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">View Content List</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">Title</th>
											<th scope="col">Brief</th>
											<th scope="col">Create Date</th>
											<th scope="col">Update</th>
											<th scope="col">Delete</th>
										</tr>
									</thead>
									<tbody id="tbody">

									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<div class="container" id="updateBlock">
				<div class="modal fade" id="updateModal" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Update New Information</h4>
							</div>
							<div class="modal-body">
									<input type="hidden" id="hiddencontentid"
										name="id">
										
									<div class="form-group">
										<div class="form-group">
										<label>Title</label>
											<input type="text" name="content.title" id="title"
												class="form-control input-sm" placeholder="Title">
										</div>
									</div>
									
								<div class="form-group">
										<div class="form-group">
											<label>Brief</label>
											<textarea name="content.brief" id="brief"
												class="form-control animated" placeholder="Brief">
												</textarea>
										</div>
									</div>
								<div class="form-group">
								<label>Content</label>
									<textarea name="content.content" id="content"
										class="form-control animated" placeholder="Content" rows="4">
										</textarea>
								</div>
								<button onclick="updateNewRecord();" class="btn btn-info btn-block">Update</button>
								<div id="resp" class="text-center" style="margin-top: 13px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/autosize.js"></script>
</body>

</html>