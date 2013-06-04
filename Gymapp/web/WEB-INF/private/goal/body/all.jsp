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
            <th>Statistic Group</th>
            <th>Statistic</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${bodyStatGoals}" var="bodyStatGoal">
                <tr>
                    <td>${bodyStatGoal.statGroup}</td>
                    <td>${bodyStatGoal.statGoal}</td>
                    <td><a href="/Gymapp/private/goal/body/edit?bodyStatGoalID=${bodyStatGoal.id}">Edit</a></td>
                    <td><a href="/Gymapp/private/goal/body/delete?bodyStatGoalID=${bodyStatGoal.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>