<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title><spring:message code="survey.title_complete"/></title>
    </head>
    <body>
    <h1>응답</h1>

    <form:form method="POST" action="surveyList" modelAttribute="surveyCommand">
        <p>
            <label><spring:message code="rq1"/></label>
            <c:out value="${surveyCommand.q1}" />
        </p>
        <p>
            <label><spring:message code="rq2"/></label>
            <c:out value="${surveyCommand.q2}" />
        </p>
        <p>
            <label><spring:message code="rq3"/></label>
            <c:out value="${surveyCommand.q3}" />
        </p>
        <p>
            <label><spring:message code="rrespondentName"/></label>
            <c:out value="${surveyCommand.respondentName}" />
        </p>
        <p>
            <label><spring:message code="rrespondentAge"/></label>
            <c:out value="${surveyCommand.respondentAge}" />
        </p>
        <p>
            <a href="<c:url value="/survey/surveyList" />">[응답 리스트 보기]</a>
        </p>
    </form:form>

    </body>
</html>
