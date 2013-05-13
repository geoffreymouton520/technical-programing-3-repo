<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head >
        <title>Ares Gym</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="master.css" />" />
    </head>
    <body>
        <div id="navigationbar">
            Exercise
        </div>
        <div id="sidenavigation">
            <a href="addExercise.html" class="sidenavigationlink" >Add Exercise</a>
            <a href="contacts.html" class="sidenavigationlink" >Add Contact</a>
        </div>
        <div id="content">
            <h2>Contact Manager</h2>
            <form:form method="post" action="addContact.html"> 
                <table>
                    <tr>
                        <td><form:label path="firstname">First Name</form:label></td>
                        <td><form:input path="firstname"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="lastname">Last Name</form:label></td>
                        <td><form:input path="lastname"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="email">Email</form:label></td>
                        <td><form:input path="email"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:label path="telephone">Telephone</form:label></td>
                        <td><form:input path="telephone"></form:input></td>
                    </tr>
                </table>  
                <br/>
                <input type="submit" value="Add Contact" />
        </div>
        <div id="pagefooter">
            &copy:AresGym.com
        </div>
    </body>
</html>
