<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>회원가입</title>
  </head>
  <body>
    <h2>Step3 - 회원가입 완료</h2>
    <p>회원가입을 완료했습니다.</p>
    <p>
      <strong>${forData.name}님</strong>
    </p>
    <a href="<c:url value='/main'/>">[첫 화면으로 이동]</a>
  </body>
</html>