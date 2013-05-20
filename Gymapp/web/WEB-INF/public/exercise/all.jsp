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
            <th>Name</th>
            <th>Muscle Group</th>
            <th>Description</th>
            <th>Equipment</th>
            <th>Instructions</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${exercises}" var="exercise">
                <tr>
                    <td>${exercise.name}</td>
                    <td>${exercise.muscleGroup}</td>
                    <td>${exercise.description}</td>
                    <td>${exercise.equipment}</td>
                    <td>${exercise.instructions}</td>
                    <td><a href="exerciseedit?exerciseID=${exercise.id}">Edit</a></td>
                    <td><a href="exercisedelete?exerciseID=${exercise.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>