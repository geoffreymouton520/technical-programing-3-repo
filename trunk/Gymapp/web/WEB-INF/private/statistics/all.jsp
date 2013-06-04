<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>All Statistics</h2>
        <table class="table table-striped">
            <thead>
            <th>Exercise</th>
            <th>Sets</th>
            <th>Repetitions</th>
            <th>Weight</th>
        </thead>
        <tbody>
            <c:forEach items="${statistics}" var="statistic">
                <tr>
                    <td>${statistic.exercise.name}</td>
                    <td>${statistic.setNumber}</td>
                    <td>${statistic.repitions}</td>
                    <td>${statistic.weight}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>