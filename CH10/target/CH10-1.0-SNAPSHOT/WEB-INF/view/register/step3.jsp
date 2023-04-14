<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
</head>
<body>
<h2>Step3 - 회원가입 완료</h2>
<p>
  <strong><spring:message code="register.done" arguments="${registerRequest.name}"/></strong>
</p>
<a href="<c:url value='/main'/>">[<spring:message code="go.main"/>]</a>
</body>
</html>