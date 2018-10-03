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

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="ProcessLogin" method="POST">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" name="email"
										type="text" required>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" required>
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me"> Remember Me
									</label>
								</div>
								<div class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-success btn-lg btn-block">
											Login</button>
									</div>
									<div class="col-md-12">
										<span style="color: red;">
											${mesg}
										</span>
									</div>
								</div>

								<br>
								<div>
									<a href="Register"> Click here to Register </a>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>