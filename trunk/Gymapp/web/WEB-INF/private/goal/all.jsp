<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <form class="form-actions" method="post" action="/Gymapp/private/goal/allselect.html">
            <legend>Select Goal</legend>
            <table>
                <tr>
                    <td><label >Goal Type</label></td>
                    <td>
                        <select class="input-block-level" name="goal">
                            <option value="">---Select Goal Type---</option>
                            <option value="body">Body Statistic</option>
                            <option value="exercise">Exercise Statistic</option>
                        </select>
                    </td>
                </tr>
                <td colspan="2">
                    <input class="btn" type="submit" value="Submit"/>
                </td>
            </table> 
        </form>
    </table>
</jsp:body>
</t:genericpage>