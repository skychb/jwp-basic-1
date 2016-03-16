<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/styles.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="main">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default content-main">
				<form name="update" method="post" action="/user/update">
					<div class="form-group">
						<label for="userId">사용자 아이디</label> <input class="form-control"
							id="userId" name="userId" value="${user.userId}">
					</div>
					<div class="form-group">
						<label for="password">비밀번호</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Password">
					</div>
					<div class="form-group">
						<label for="name">이름</label> <input class="form-control" id="name"
							name="name" value="${user.name}">
					</div>
					<div class="form-group">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" name="email"
							value="${user.email}">
					</div>
					<button type="submit" class="btn btn-success clearfix pull-right">정보수정</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>