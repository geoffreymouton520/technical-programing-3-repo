
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <h2>Person Manager</h2>
        <form class="form-actions" method="post" action="save.html">
            <table>
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
                    <td><input class="input-block-level" name="gender"/></td>
                </tr>
                <td colspan="2">
                    <input class="btn" type="submit" value="Add Person"/>
                </td>
            </table> 
        </form>
        <script>
            $(function() {
                $('.date-picker').datepicker({ dateFormat: "dd-mm-yy", firstDay: 1, changeYear: true, yearRange: '1900:+0'});
            });
        </script>
    </jsp:body>
</t:genericpage>
