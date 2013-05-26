<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
    <jsp:body>
        <body>
            <h3>Message : ${message}</h3>	
            <h3>Username : ${username}</h3>	

            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

        </body>
    </jsp:body>
</t:genericpage>
