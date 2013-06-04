<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>All Routines</h2>
        <table class="table table-striped">
            <thead>
            <th>Name</th>
            <th>Fitness Level</th>
            <th>Routine Type</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Workouts</th>
        </thead>
        <tbody>
            <c:forEach items="${fitnessRoutines}" var="fitnessRoutine">
                <tr>
                    <td>${fitnessRoutine.name}</td>
                    <td>${fitnessRoutine.fitnessLevel}</td>
                    <td>${fitnessRoutine.routineType}</td>
                    <td><a href="/Gymapp/private/fitnessRoutine/edit?fitnessRoutineID=${fitnessRoutine.id}">Edit</a></td>
                    <td><a href="/Gymapp/private/fitnessRoutine/delete?fitnessRoutineID=${fitnessRoutine.id}">Delete</a></td>
                    <td><a href="/Gymapp/private/fitnessRoutine/view?fitnessRoutineID=${fitnessRoutine.id}">View</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>