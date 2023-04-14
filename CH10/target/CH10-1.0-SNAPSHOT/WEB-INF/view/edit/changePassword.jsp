<%--
  Created by IntelliJ IDEA.
  User: ununb
  Date: 2023-04-14
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Title</title>
  </head>
  <body>
  <p>
    <label><spring:message code="rememberEmail"/> </label>
    <form:checkbox path="rememberEmail" />
  </p>
  <input type="submit" value="<spring:message code="login.btn"/> " />
  </body>
</html>
