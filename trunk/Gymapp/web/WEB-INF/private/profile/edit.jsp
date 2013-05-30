<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <div class="well"> 
            <form class="form-horizontal" method="post" action="update.html">
                <legend>Register</legend>
                <table>
                    <tr>
                        <td><label class="control-label">User Name</label></td>
                        <td>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="userName" value="${profile.userName}"  enabled="false">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="control-label">First Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="firstName" value="${profile.firstName}" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Middle Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="middleName" value="${profile.middleName}" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Last Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="lastName" value="${profile.lastName}" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Date Of Birth</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-calendar"></i></span>
                                    <input type="text" class="input-xlarge date-picker" name="dateOfBirth" value="${profile.dateOfBirth}" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Gender</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <select class="input-xlarge" name="gender">
                                        <option value="">---Select Gender---</option>
                                        <c:forEach items="${genders}" var="option">
                                            <option value="${option}">
                                                ${option}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Password</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-lock"></i></span>
                                    <input type="text" class="input-xlarge" name="password" placeholder="*******" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Retype Password</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-lock"></i></span>
                                    <input type="text" class="input-xlarge" name="passwordRetype" placeholder="*******" >
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Update" class="btn btn-success"/>
                        </td>
                    </tr>
                </table>
            </form>
            <script>
            $(function() {
            $('.date-picker').datepicker({dateFormat: "dd-mm-yy", firstDay: 1, changeYear: true, yearRange: '1900:+0'});
            });
            </script>
        </div>
    </jsp:body>
</t:genericpage>
