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
        <form class="form-signin" method="post" action="save.html">
                    <h3>Register</h3>
                    <table>
                        <tr>
                            <td><label>User Name</label></td>
                            <td><input  required="true" class="input-block-level" /></td>
                        </tr>
                        <tr>
                            <td><label>First Name</label></td>
                            <td><input class="input-block-level" name="firstName"/></td>
                        </tr>
                        <tr>
                            <td><label >Middle Name</label></td>
                            <td><input class="input-block-level"  name="middleName"/></td>
                        </tr>
                        <tr>
                            <td><label >Last Name</label></td>
                            <td><input class="input-block-level" name="lastName"/></td>
                        </tr>
                        <tr>
                            <td><label >Date Of Birth</label></td>
                            <td><input class="input-block-level date-picker" name="dateOfBirth"/></td>
                        </tr>
                        <tr>
                            <td><label >Gender</label></td>
                            <td>
                                <select class="input-block-level" name="gender">
                                    <option value="">---Select Gender---</option>
                                    <c:forEach items="${genders}" var="option">
                                        <option value="${option}">
                                            ${option}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Password</label></td>
                            <td><input type="password"  required="true" class="input-block-level" /></td>
                        </tr>
                        <tr>
                            <td><label for="retype">Retype Password</label></td>
                            <td><input type="password" required id="retype" class="input-block-level" path="password"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Register" class="btn-success"/>
                            </td>
                        </tr>
                    </table>
        </form>
        <script>
            $(function() {
                $('.date-picker').datepicker({dateFormat: "dd-mm-yy", firstDay: 1, changeYear: true, yearRange: '1900:+0'});
            });
        </script>
    </jsp:body>
</t:genericpage>
