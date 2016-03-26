<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<%@ include file="/include/header.jspf" %>
</head>
<body>
<nav class="navbar navbar-fixed-top header">
  <div class="col-md-12">
    <div class="navbar-header">

      <a href="/" class="navbar-brand">SLiPP</a>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse1">
        <i class="glyphicon glyphicon-search"></i>
      </button>

    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse1">
      <form class="navbar-form pull-left">
        <div class="input-group" style="max-width:470px;">
          <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
          <div class="input-group-btn">
            <button class="btn btn-default btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i></button>
          </div>
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-bell"></i></a>
          <ul class="dropdown-menu">
            <li><a href="https://slipp.net" target="_blank">SLiPP</a></li>
            <li><a href="https://facebook.com" target="_blank">Facebook</a></li>
          </ul>
        </li>
        <li><a href="/users"><i class="glyphicon glyphicon-user"></i></a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="navbar navbar-default" id="subnav">
  <div class="col-md-12">
    <div class="navbar-header">
      <a href="/" style="margin-left:15px;" class="navbar-btn btn btn-default btn-plus dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-home" style="color:#dd1111;"></i> Home <small><i class="glyphicon glyphicon-chevron-down"></i></small></a>
      <c:if test="${not empty sessionScope.user}">
      <ul class="nav dropdown-menu">
        <li><a href="/users/profile?userId=${sessionScope.user.userId}"><i class="glyphicon glyphicon-user" style="color:#1111dd;"></i> Profile</a></li>
        <li class="nav-divider"></li>
        <li><a href="#"><i class="glyphicon glyphicon-cog" style="color:#dd1111;"></i> Settings</a></li>
      </ul>
      </c:if>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse2">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="index.jsp">Posts</a></li>
        <c:choose>
        <c:when test="${not empty sessionScope.user}">
        <li><a href="/users/logout" role="button">로그아웃</a></li>
        <li><a href="/users/updateForm?userId=${sessionScope.user.userId}" role="button">개인정보수정</a></li>
        </c:when>
        <c:otherwise>
        <li><a href="/users/loginForm" role="button">로그인</a></li>
        <li><a href="/users/form" role="button">회원가입</a></li>
        <!--
        <li><a href="#loginModal" role="button" data-toggle="modal">로그인</a></li>
        <li><a href="#registerModal" role="button" data-toggle="modal">회원가입</a></li>
        -->
        </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</div>

<div class="container" id="main">
	<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
		<div class="panel panel-default qna-list">
			<ul class="list">
			<c:forEach items="${questions}" var="question">
				<li>
					<div class="wrap">
						<div class="main">
							<strong class="subject">
								<a href="/qna/show?questionId=${question.questionId}">${question.title}</a>
							</strong>
							<div class="auth-info">
								<i class="icon-add-comment"></i>
								<span class="time"><fmt:formatDate type="date" value="${question.createdDate}" /></span>
								<a href="" class="author">${question.writer}</a>
							</div>
							<div class="reply" title="댓글">
								<i class="icon-reply"></i>
								<span class="point">${question.countOfAnswer}</span>
							</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 text-center">
					<ul class="pagination center-block" style="display:inline-block;">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
				<div class="col-md-3 qna-write">
					<a href="/qna/form" class="btn btn-primary pull-right" role="button">질문하기</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!--login modal-->
<!--
<div id="loginModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h2 class="text-center"><img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"><br>Login</h2>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
              <div class="form-group">
                  <label for="userId">사용자 아이디</label>
                  <input class="form-control" name="userId" placeholder="User ID">
              </div>
              <div class="form-group">
                  <label for="password">비밀번호</label>
                  <input type="password" class="form-control" name="password" placeholder="Password">
              </div>
              <div class="form-group">
                  <button class="btn btn-primary btn-lg btn-block">로그인</button>
                  <span class="pull-right"><a href="#registerModal" role="button" data-toggle="modal">회원가입</a></span>
              </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
      </div>
  </div>
  </div>
</div>
-->

<!--register modal-->
<!--
<div id="registerModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h2 class="text-center"><img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"><br>회원가입</h2>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
              <div class="form-group">
                  <label for="userId">사용자 아이디</label>
                  <input class="form-control" id="userId" name="userId" placeholder="User ID">
              </div>
              <div class="form-group">
                  <label for="password">비밀번호</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password">
              </div>
              <div class="form-group">
                  <label for="name">이름</label>
                  <input class="form-control" id="name" name="name" placeholder="Name">
              </div>
              <div class="form-group">
                  <label for="email">이메일</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="Email">
              </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">회원가입</button>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
      </div>
  </div>
  </div>
</div>
-->

<%@ include file="/include/footer.jspf" %>
</body>
</html>
