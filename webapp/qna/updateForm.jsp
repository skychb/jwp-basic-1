<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="/include/header.jspf" %>
</head>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default content-main">
            <form name="question" method="post" action="/qna/update">
                <input type="hidden" name="questionId" value="${questions.questionId}" />
                <div class="form-group">
                    <label>사용자 아이디</label>
                    ${user.userId}
                </div>
                <div class="form-group">
                    <label for="name">제목</label>
                    <input class="form-control" id="title" name="title" placeholder="Title" value="${questions.title}">
                </div>
                <div class="form-group">
                    <label for="email">내용</label>
                    <input type="form-control" class="form-control" id="contents" name="contents" placeholder="Contents" value="${questions.contents}">
                </div>
                <button type="submit" class="btn btn-success clearfix pull-right">질문 수정</button>
                <div class="clearfix" />
            </form>
        </div>
    </div>
</div>

<%@ include file="/include/footer.jspf" %>
</body>
</html>
