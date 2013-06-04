<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>All Exercises</h2>
        <table class="table table-striped">
            <thead>
            <th>Exercise</th>
            <th>Weight</th>
            <th>Set</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${exerciseGoals}" var="exerciseGoal">
                <tr>
                    <td>${exerciseGoal.exercise.name}</td>
                    <td>${exerciseGoal.weight}</td>
                    <td>${exerciseGoal.exerciseSets}</td>
                    <td><a href="/Gymapp/private/goal/exercise/edit?exerciseGoalID=${exerciseGoal.id}">Edit</a></td>
                    <td><a href="/Gymapp/private/goal/exercise/delete?exerciseGoalID=${exerciseGoal.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>