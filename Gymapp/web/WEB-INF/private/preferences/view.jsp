<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
        <div class="well"> 
            <form class="form-horizontal" method="post" action="edit.html">
                <legend>Preferences</legend>
                <table>
                    <tr>
                        <td><label class="control-label">Measuring Unit</label></td>
                        <td>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-folder-close"></i></span>
                                    <input type="text" class="input-xlarge" name="restTimeInSeconds" value="${preferences.measuringUnit}" disabled="true">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Rest Time</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-folder-close"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${preferences.restTimeInSeconds}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">View Exercise Preference</label></td>
                        <td><div class="control-label"><a class="input-xlarge" href="/Gymapp/private/preferences/exercise/all">View</a></div></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" value="Edit" class="btn btn-success"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </jsp:body>
</t:genericpage>
