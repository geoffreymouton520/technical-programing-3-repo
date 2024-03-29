<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
        <div class="well"> 
            <form class="form-horizontal" method="post" action="update.html">
                <legend>Preferences</legend>
                <table>
                    <tr>
                        <td><label class="control-label">Measuring Unit</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-folder-close"></i></span>
                                    <select class="input-xlarge" name="measuringUnit">
                                        <option value="">---Select Measuring Unit---</option>
                                        <c:forEach items="${measuringUnits}" var="option">
                                            <option value="${option}">
                                                ${option}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div></td>

                    </tr>
                    <tr>
                        <td><label class="control-label">Rest Time</label></td>
                        <td>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-folder-close"></i></span>
                                    <input type="text" class="input-xlarge" name="restTimeInSeconds" value="${preferences.restTimeInSeconds}" >
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update" class="btn btn-success"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </jsp:body>
</t:genericpage>
