<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <h2>Registration</h2>
        <form class="form-actions" method="post" action="save.html">
            <table>
                <tr>
                    <td><label >Username</label></td>
                    <td><input class="input-block-level" name="userName"/></td>
                </tr>
                <tr>
                    <td><label >Password</label></td>
                    <td><input class="input-block-level" type="password"  name="password"/></td>
                </tr>
                <td colspan="2">
                    <input class="btn" type="submit" value="Register"/>
                </td>
            </table> 
        </form>
    </jsp:body>
</t:genericpage>
