
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Ares Gym</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
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

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="index">Ares Gym</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="index">Home</a></li>
                            <li class="active"><a href="exercises">Exercise</a></li>
                            <li><a href="persons">Person</a></li>
                            <li><a href="users">User</a></li>
                        </ul>
                    </div><
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header">Crud</li>
                            <li><a href="index">Home</a></li>
                            <li><a href="addExercise.html">Add Exercise</a></li>
                            <li><a href="persons">Add Person</a></li>
                            <li><a href="users">Add User</a></li>
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <h2>All Exercises</h2>
                        <table class="table table-striped">
                            <thead>
                            <th>Name</th>
                            <th>Muscle Group</th>
                            <th>Description</th>
                            <th>Equipment</th>
                            <th>Instructions</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${exercises}" var="exercise">
                                    <tr>
                                        <td>${exercise.name}</td>
                                        <td>${exercise.muscleGroup}</td>
                                        <td>${exercise.description}</td>
                                        <td>${exercise.equipment}</td>
                                        <td>${exercise.instructions}</td>
                                        <td><a href="editExercise.html">Edit</a></td>
                                        <td><a href="deleteExercise.html">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row-fluid">
                    </div><!--/row-->
                    <div class="row-fluid">
                    </div><!--/row-->
                </div><!--/span-->
            </div><!--/row-->

            <hr>

            <footer>
                <p>&copy; Company 2013</p>
            </footer>

        </div>

    </body>
</html>
