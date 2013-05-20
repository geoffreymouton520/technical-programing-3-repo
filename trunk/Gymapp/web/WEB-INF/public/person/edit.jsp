<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>Exercise Manager</h2>
        <form class="form-actions" method="post" action="personupdate">
            <table>
                <tr>
                    <td><label>First Name</label></td>
                    <td><input class="input-block-level" name="firstName" value="${person.firstName}"/></td>
                </tr>
                <tr>
                    <td><label >Middle Name</label></td>
                    <td><input class="input-block-level"  name="middleName" value="${person.middleName}"/></td>
                </tr>
                <tr>
                    <td><label >Last Name</label></td>
                    <td><input class="input-block-level" name="lastName" value="${person.lastName}"/></td>
                </tr>
                <tr>
                    <td><label >Date Of Birth</label></td>
                    <td><input class="input-block-level" name="dateOfBirth" value="${person.dateOfBirth}"/></td>
                </tr>
                <tr>
                    <td><label >Gender</label></td>
                    <td><input class="input-block-level" name="gender" value="${person.gender}"/></td>
                </tr>
                <input type="hidden" name="id" value="${person.id}">
                <td colspan="2">
                    <input class="btn" type="submit" value="Update Person"/>
                </td>
            </table> 
        </form> 
    </jsp:body>
</t:genericpage>
