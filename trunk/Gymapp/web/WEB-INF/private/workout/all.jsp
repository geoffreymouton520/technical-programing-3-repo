<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>All Workouts</h2>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Total Calories Burned</th>
            <th>Duration in Minutes</th>
            <th>Fitness Level</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Exercises</th>
        </thead>
        <tbody>
            <c:forEach items="${workouts}" var="workout">
                <tr>
                    <td>${workout.id}</td>
                    <td>${workout.totalCaloriesBurned}</td>
                    <td>${workout.workoutDurationInMins}</td>
                    <td>${workout.fitnessLevel}</td>
                    <td><a href="/Gymapp/private/workout/edit?workoutID=${workout.id}">Edit</a></td>
                    <td><a href="/Gymapp/private/workout/delete?workoutID=${workout.id}">Delete</a></td>
                    <td><a href="/Gymapp/private/workout/view?workoutID=${workout.id}">View</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:genericpage>