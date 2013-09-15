<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ares Gym</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" />
        <script type='text/javascript' src='http://code.jquery.com/jquery-1.7.1.js'></script>
        <script type='text/javascript' src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script>

            $('.dropdown-toggle').dropdown();

        </script>
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
    </head>
    <body>
        <div id="pageheader">
            <jsp:invoke fragment="header"/>
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="brand" href="/Gymapp/index">Ares Gym</a>
                        <div class="nav-collapse collapse">
                            <c:choose>
                                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                                    <div class="dropdown navbar-text pull-right" id="menu1">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
                                            <c:out value="${pageContext.request.userPrincipal.name}"/>
                                            <b class="caret"></b>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/Gymapp/private/profile/view">Profile</a></li>
                                            <li><a href="/Gymapp/private/preferences/view">Preferences</a></li>
                                            <li><a href="/Gymapp/private/goal/all">Goals</a></li>
                                            <li><a href="/Gymapp/private/statistics/all">Statistics</a></li>
                                            <li class="divider"></li>
                                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout <c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></a></li>
                                        </ul>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <p class="navbar-text pull-right">
                                        <a href="/Gymapp/login">Login</a>
                                        <a href="/Gymapp/register">Register</a>
                                    </p>
                                </c:otherwise>
                            </c:choose>
                            <ul class="nav">
                                <li class="active"><a href="/Gymapp/index">Home</a></li>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li><a href="/Gymapp/private/person/all">Person</a></li>
                                    </sec:authorize>
                                <li><a href="/Gymapp/private/exercise/all">Exercise</a></li>                           
                                <li><a href="/Gymapp/private/fitnessRoutine/all">Routines</a></li>
                                <li><a href="/Gymapp/private/workout/all">Workout</a></li>
                                <li><a href="/Gymapp/private/workout/all">Workout</a></li>
                                <li><a href="/Gymapp/message/">Message</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="body">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span3">
                        <div class="well sidebar-nav">
                            <ul class="nav nav-list">
                                <li class="nav-header">Crud</li>
                                <li class="active"><a href="/Gymapp/index">Home</a></li>
                                        <sec:authorize access="hasRole('ROLE_USER')">
                                        <li><a href="/Gymapp/private/goal/add">Add Goal</a></li>
                                        <li><a href="/Gymapp/private/statistics/add">Add Statistic</a></li>
                                        </sec:authorize>
                                <li><a href="/Gymapp/private/fitnessRoutine/add">Add Routine</a></li>
                                <li><a href="/Gymapp/private/workout/add">Add Workout</a></li>
                                <li><a href="/Gymapp/private/exercise/add">Add Exercise</a></li>
                            </ul>
                        </div><!--/.well -->
                    </div><!--/span-->
                    <div class="span9">
                        <div class="hero-unit">
                            <jsp:doBody/>
                        </div>
                        <div class="row-fluid">
                        </div><!--/row-->
                        <div class="row-fluid">
                        </div><!--/row-->
                    </div><!--/span-->
                </div><!--/row-->


            </div>
            <div id="pagefooter">
                <jsp:invoke fragment="footer"/>
                <p>&copy; Company 2013</p>
            </div>
    </body>
</html>