<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>All People</h2>
        <table class="table table-striped">
            <thead>
            <th>First Name</th>
            <th>Middle Name</th>
            <th>Last Name</th>
            <th>Date Of Birth</th>
            <th>Gender</th>
            <th>Edit</th>
            <th>Delete</th>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td>${person.firstName}</td>
                        <td>${person.middleName}</td>
                        <td>${person.lastName}</td>
                        <td>${person.dateOfBirth}</td>
                        <td>${person.gender}</td>
                        <td><a href="personedit?personID=${person.id}">Edit</a></td>
                        <td><a href="persondelete?personID=${person.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:genericpage>
