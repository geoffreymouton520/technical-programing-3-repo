<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
        <div class="well"> 
            <form class="form-horizontal" method="post" action="edit.html">
                <legend>Register</legend>
                <table>
                    <tr>
                        <td><label class="control-label">User Name</label></td>
                        <td>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.userName}" disabled="true">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="control-label">First Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.firstName}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Middle Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.middleName}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Last Name</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.lastName}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Date Of Birth</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-calendar"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.dateOfBirth}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Gender</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-user"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="${profile.gender}" disabled="true">
                                </div>
                            </div></td>
                    </tr>
                    <tr>
                        <td><label class="control-label">Password</label></td>
                        <td><div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on"><i class="icon-lock"></i></span>
                                    <input type="text" class="input-xlarge" name="profile" value="*******" disabled="true">
                                </div>
                            </div></td>
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
