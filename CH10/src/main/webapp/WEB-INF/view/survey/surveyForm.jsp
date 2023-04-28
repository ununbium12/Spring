<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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
    <h1>설문조사</h1>
    <form:form action="surveyComplete" method="POST" modelAttribute="surveyCommand">
        <p>
            <label><spring:message code="q1"/></label><br>
            <form:radiobutton path="q1" value="서버" label="서버개발자" />
            <form:radiobutton path="q1" value="프론트" label="프론트개발자" />
            <form:radiobutton path="q1" value="풀스택" label="풀스택개발자" /><br>
            <form:errors path="q1" cssClass="error"/>
        </p>
        <p>
            <label><spring:message code="q2"/></label><br>
            <form:radiobutton path="q2" value="Eclipse" label="Eclipse" />
            <form:radiobutton path="q2" value="IntelliJ" label="IntelliJ" />
            <form:radiobutton path="q2" value="VSCode" label="VSCode" /><br>
            <form:errors path="q2" cssClass="error"/>
        </p>
        <p>
            <label><spring:message code="q3"/></label><br>
            <form:input path="q3" /><br>
            <form:errors path="q3" cssClass="error"/>
        </p>
        <p>
            <label><spring:message code="respondentName"/></label>
            <form:input path="respondentName" /><br>
            <form:errors path="respondentName" cssClass="error"/>
        </p>
        <p>
            <label><spring:message code="respondentAge"/></label>
            <form:input type="number" path="respondentAge" /><br>
            <form:errors path="respondentAge" cssClass="error"/>
        </p>
        <input type="submit" value="<spring:message code="survey.btn"/>">
    </form:form>
    <c:set var="surveyCommand" value="${surveyCommand}" />
    </body>
</html>

