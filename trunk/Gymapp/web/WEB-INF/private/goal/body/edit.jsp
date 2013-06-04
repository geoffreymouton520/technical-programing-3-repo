<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <h2>Exercise Manager</h2>
        <form class="form-actions" method="post" action="update.html">
            <legend>Edit Statistic Goal</legend>
            <table>
                <tr>
                    <td><label >Statistic Group</label></td>
                    <td>
                        <select class="input-block-level" name="statGroup" >
                            <option value="">---Select Statistic Group---</option>
                            <c:forEach items="${statsGroups}" var="option">
                                <option value="${option}">
                                    ${option}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Statistic</label></td>
                    <td><input class="input-block-level" name="statGoal" value="${bodyStatGoal.statGoal}"/></td>
                </tr>
                <td colspan="2">
                    <input class="btn" type="submit" value="Update Goal"/>
                </td>
            </table>
        </form>
    </jsp:body>
</t:genericpage>
