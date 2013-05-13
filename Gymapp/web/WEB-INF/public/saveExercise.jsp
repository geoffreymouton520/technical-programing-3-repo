<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head >
        <title>Ares Gym</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    </head>
    <body>
        <div id="navigationbar">
            Exercise
        </div>
        <div class="span2">
            <a href="addExercise.html" class="sidenavigationlink" >Add Exercise</a>
            <a href="contacts.html" class="sidenavigationlink" >Add Contact</a>
        </div>
        <div class="container-fluid">
            <h2>Exercise Manager</h2>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Muscle Group</th>
                    <th>Description</th>
                    <th>Equipment</th>
                    <th>Instructions</th>
                </tr>
                <c:forEach items="${exercises}" var="exercise">
                    <tr>
                        <td>${exercise.name}</td>
                        <td>${exercise.muscleGroup}</td>
                        <td>${exercise.description}</td>
                        <td>${exercise.equipment}</td>
                        <td>${exercise.instructions}</td>
                    </tr>
                </c:forEach>
            </table>	
        </div>
        <div id="pagefooter">
            &copy:AresGym.com
        </div>
    </body>
</html>
