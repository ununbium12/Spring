<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><spring:message code="survey.title"/></title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
    <h1>설문조사입니다.</h1>
    <form:form method="post" action="submitSurvey" modelAttribute="survey">
        <p>
            <label for="Q1">1. 당신의 희망 분야는?</label><br>
            <input type="radio" name="Q1" value="서버개발자">서버개발자<br>
            <input type="radio" name="Q1" value="프론트개발자">프론트개발자<br>
            <input type="radio" name="Q1" value="풀스택개발자">풀스택개발자<br>
            <form:errors path="Q1" cssClass="error"/>
        </p>
        <p>
            <label for="Q2">2. 가장 많이 사용하는 개발도구는?</label><br>
            <input type="radio" name="Q2" value="Eclipse">Eclipse<br>
            <input type="radio" name="Q2" value="IntelliJ">IntelliJ<br>
            <input type="radio" name="Q2" value="VSCode">VSCode<br>
            <form:errors path="Q2" cssClass="error"/>
        </p>

        <p>
            <label for="Q3">3. 하고 싶은 말</label><br>
            <input type="text" name="Q3" required>
            <form:errors path="Q3" cssClass="error"/>
        </p>

        <p>
            <label for="RespondentName">이름:</label>
            <input type="text" name="RespondentName" required>
            <form:errors path="RespondentName" cssClass="error"/>
        </p>

        <p>
            <label for="RespondentAge">나이:</label>
            <input type="number" name="RespondentAge" required>
            <form:errors path="RespondentAge" cssClass="error"/>
        </p>

        <p>
            <input type="submit" value="제출">
        </p>

    </form:form>

    <c:if test="${not empty param.submit}">
        <p>제출 완료!</p>
    </c:if>

    </body>
</html>

