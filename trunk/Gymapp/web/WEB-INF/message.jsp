<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<title>Login Page</title>
<style>
    .errorblock {
        color: #ff0000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>
<t:genericpage>
    <jsp:body>
        <body onload='document.f.j_username.focus();'>
            <h2 class="form-signin-heading">Please sign in</h2>

            <c:if test="${not empty error}">
                <div class="errorblock">
                    Your login attempt was not successful, try again.<br /> Caused :
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

            <form name='f' class="form-signin" action="<c:url value='j_spring_security_check' />"
                  method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='j_username' class="input-block-level" placeholder="Username">
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='j_password' class="input-block-level" placeholder="Password" />
                        </td>
                    </tr>
                    <tr>
                        <td><input name="submit" type="submit"
                                               value="Login" class="btn" />
                        </td>
                        <td><input name="reset" type="reset" class="btn"/>
                        </td>
                        
                    </tr>
                </table>

            </form>
        </body>
    </jsp:body>
</t:genericpage>
