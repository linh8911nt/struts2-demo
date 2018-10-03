<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Register</title>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

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

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#username").blur(function() {
		var userName = $("#username").val();
		if (userName.length >= 4 && userName.length <= 30) {
			$("#span-username").html("");
		} else {
			$("#span-username").html("Username length from 4 to 30!!!");
		}
		
	});
	
	$('#form-register input[name="email"]').keyup(function() {
		var email = $(this).val();
		var regex = /[A-Z0-9._%+-]{4,}@[A-Z0-9.-]{4,8}.[A-Z]{2,4}/igm;
		
		var flag = false;
		if (regex.test(email)) {
			$.ajax({
				type : "get",
				url : "json",
				success : function(data) {
					$.each(data.members, function() {
						if (email == this.email) {
							flag = true;
						}
					});
					if (flag) {
						$("#span-email").html("Username existed!!!");
					} else {
						$("#span-email").html("");
					}
				}
			});
		} else {
			$("#form-register span:eq(1)").html("Email example example@gmail.com!");
		}
	});
	$('#form-register input[name="password"]').keyup(function() {
		var password = $(this).val();
		
		if (password.length >= 8 && password.length <= 30) {
			$("#form-register span:eq(2)").text("").show();
		} else {
			$("#form-register span:eq(2)").text("Password length from 8 to 30!").show();
		}
	});
	$('#form-register input[name="repassword"]').keyup(function() {
		var repassword = $(this).val();
		var password = $("#password").val();
		
		if (repassword === password) {
			$("#form-register span:eq(3)").text("").show();
		} else {
			$("#form-register span:eq(3)").text("Re Password doesn't matches!").show();
		}
	});
	
	$('#form-register button[type="submit"]').click(function(event){
		if($("#form-register span:eq(0)").text() != ""){
			event.preventDefault();
		}
		if($("#form-register span:eq(1)").text() != ""){
			event.preventDefault();
		}
		if($("#form-register span:eq(2)").text() != ""){
			event.preventDefault();
		}
		if($("#form-register span:eq(3)").text() != ""){
			event.preventDefault();
		}
	});
})
	
</script>
</head>

<body>
	<div class="cotainer">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Register</h3>
					</div>
					<div class="panel-body">
						<form id="form-register" role="form" action="ProcessRegister"
							method="POST">
							<fieldset>
								<div class="form-group row">
									<div class="col-md-12">
										<input type="text" id="username" class="form-control"
											name="userName" placeholder="Username" required> <span
											id="span-username"></span>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<input type="text" id="email" class="form-control"
											name="email" placeholder="E-mail" required> <span
											id="span-email"></span>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<input type="password" id="password" class="form-control"
											name="password" placeholder="Password" required> <span
											id="span-password"></span>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<input type="password" id="repassword" class="form-control"
											name="rePassword" placeholder="Re Password" required>
										<span id="span-repassword"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<button onclick="registerMember();" type="submit" class="btn btn-success btn-lg btn-block">
											Register</button>
									</div>
								</div>
								<div class="text-center" id="resp" style="margin-top: 14px;"></div>
								<br>
								<div class="row">
									<a href="Login" class="btn btn-link"> Click here to Login </a>
								</div>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<footer> </footer>

</html>