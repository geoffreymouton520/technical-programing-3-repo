<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <form class="form-actions" method="post" action="update.html">
            <legend>Edit Routine</legend>
            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><input class="input-block-level" name="name" value="${fitnessRoutine.name}"/></td>
                </tr>
                <tr>
                    <td><label >Fitness Level</label></td>
                    <td>
                        <select class="input-block-level" name="fitnessLevel">
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
                    <td><label >Routine Type</label></td>
                    <td>
                        <select class="input-block-level" name="routineType">
                            <option value="">---Select Routine Type---</option>
                            <c:forEach items="${routineTypes}" var="option">
                                <option value="${option}">
                                    ${option}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >Workouts</label></td>
                    <td>
                        <select multiple="true" class="input-block-level" name="workoutIDs" >
                            <option value="">---Select Workouts---</option>
                            <c:forEach items="${workouts}" var="option">
                                <option value="${option.id}">
                                    ${option.id}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <input type="hidden" name="id" value="${fitnessRoutine.id}">
                <td colspan="2">
                    <input class="btn" type="submit" value="Update"/>
                </td>
            </table> 
        </form>
    </jsp:body>
</t:genericpage>
