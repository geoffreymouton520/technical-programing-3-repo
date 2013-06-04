<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <form class="form-actions" method="post" action="update.html">
            <legend>Edit Workout</legend>
            <table>
                <tr>
                    <td><label >Total Calories Burned</label></td>
                    <td><input class="input-block-level" name="totalCaloriesBurned" value="${workout.totalCaloriesBurned}"/></td>
                </tr>
                <tr>
                    <td><label >Duration in Minutes</label></td>
                    <td><input class="input-block-level"  name="workoutDurationInMins" value="${workout.workoutDurationInMins}"/></td>
                </tr>
                <tr>
                    <td><label >Fitness Level</label></td>
                    <td>
                        <select class="input-block-level" name="fitnessLevel"  >
                            <option value="">---Select Fitness Level---</option>
                            <c:forEach items="${fitnessLevels}" var="option">
                                <option value="${option}">
                                    ${option}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >Exercise</label></td>
                    <td>
                        <select multiple="true" class="input-block-level" name="workoutItemsId" >
                            <option value="">---Select Exercise Type---</option>
                            <c:forEach items="${exercises}" var="option">
                                <option value="${option.id}">
                                    ${option.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <input type="hidden" name="id" value="${workout.id}">
                <td colspan="2">
                    <input class="btn" type="submit" value="Update"/>
                </td>
            </table> 
        </form>
    </jsp:body>
</t:genericpage>
