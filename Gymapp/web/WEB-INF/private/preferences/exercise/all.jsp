<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <LEGEND>All Exercises</LEGEND>
        <table class="table table-striped">
            <thead>
            <th>Exercise</th>
            <th>Repetitions</th>
            <th>Sets</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${exercisePreferences}" var="exercisePreference">
                <tr>
                    <td>${exercisePreference.exercise.name}</td>
                    <td>${exercisePreference.repitions}</td>
                    <td>${exercisePreference.exerciseSets}</td>
                    <td><a href="/Gymapp/private/preferences/exercise/edit?exercisePreferenceID=${exercisePreference.id}">Edit</a></td>
                    <td><a href="/Gymapp/private/preferences/exercise/delete?exercisePreferenceID=${exercisePreference.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="control-label"><a class="input-xlarge" href="/Gymapp/private/preferences/exercise/add">Add Exercise Preference</a></div>    
</jsp:body>
</t:genericpage>