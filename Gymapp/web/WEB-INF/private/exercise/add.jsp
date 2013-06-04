<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <h2>Exercise Manager</h2>
        <form class="form-actions" method="post" action="save.html">
            <table>
                <tr>
                    <td><label >Calories Burned</label></td>
                    <td><input class="input-block-level" name="caloriesBurned"/><label class="error">${errormessage}</label></td>
                </tr>
                <tr>
                    <td><label >Description</label></td>
                    <td><input class="input-block-level"  name="description"/></td>
                </tr>
                <tr>
                    <td><label >Equipment</label></td>
                    <td><input class="input-block-level" name="equipment"/></td>
                </tr>
                <tr>
                    <td><label >Instructions</label></td>
                    <td><input class="input-block-level" name="instructions"/></td>
                </tr>
                <tr>
                    <td><label >Name</label></td>
                    <td><input class="input-block-level" name="name"/></td>
                </tr>
                <tr>
                    <td><label >Muscle Group</label></td>
                    <td>
                        <select class="input-block-level" name="muscleGroup">
                            <option value="">---Select Muscle Group---</option>
                            <c:forEach items="${muscleGroups}" var="option">
                                <option value="${option}">
                                    ${option}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >Repetitions</label></td>
                    <td><input class="input-block-level" name="repitions"/></td>
                </tr>
                <tr>
                    <td><label >Exercise Sets</label></td>
                    <td><input class="input-block-level" name="exerciseSets"/></td>
                </tr>
                <tr>
                    <td><label >Weight</label></td>
                    <td><input class="input-block-level" name="weight"/></td>
                </tr>
                <td colspan="2">
                    <input class="btn" type="submit" value="Add Exercise"/>
                </td>
            </table> 
        </form>
    </jsp:body>
</t:genericpage>
