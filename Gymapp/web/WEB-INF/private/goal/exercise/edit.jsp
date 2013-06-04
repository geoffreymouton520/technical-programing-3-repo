<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <form class="form-actions" method="post" action="update.html">
            <legend>Edit Exercise Goal</legend>
            <table>
                <tr>
                    <td><label >Exercise</label></td>
                    <td>
                        <select class="input-block-level" name="exerciseID" >
                            <option value="">---Select Exercise Type---</option>
                            <c:forEach items="${exercises}" var="option">
                                <option value="${option.id}">
                                    ${option.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Set</label></td>
                    <td><input class="input-block-level" name="exerciseSets" value="${exerciseGoal.exerciseSets}"/></td>
                </tr>
                <tr>
                    <td><label>Weight</label></td>
                    <td><input class="input-block-level" name="weight" value="${exerciseGoal.weight}"/></td>
                </tr>
                <input type="hidden" name="id" value="${exerciseGoal.id}">
                <td colspan="2">
                    <input class="btn" type="submit" value="Update Goal"/>
                </td>
            </table> 
            
        </form>
    </jsp:body>
</t:genericpage>
