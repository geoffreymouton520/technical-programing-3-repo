
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
                            <li><a href="exercises">Exercise</a></li>
                            <li><a href="persons">Person</a></li>
                            <li><a href="users">User</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header">Crud</li>
                            <li><a href="">Home</a></li>
                            <li><a href="addExercise.html">Add Exercise</a></li>
                            <li><a href="persons">Person</a></li>
                            <li><a href="users">User</a></li>

                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <h1>Exercise Manager</h1>
                        <form class="form-actions" method="post" action="saveExercise.html">
                            <table>
                                <tr>
                                    <td><label >Calories Burned</label></td>
                                    <td><input class="input-block-level" name="caloriesBurned"/>${exercise.caloriesBurned}</td>
                                </tr>
                                <tr>
                                    <td><label >Description</label></td>
                                    <td><input class="input-block-level"  name="description"/></td>
                                </tr>
                                <tr>
                                    <td><label >Equipment</label></td>
                                    <td><input class="input-block-level" name="equipment"/></td>
                                </tr>
                                <tr>
                                    <td><label >Instructions</label></td>
                                    <td><input class="input-block-level" name="instructions"/></td>
                                </tr>
                                <tr>
                                    <td><label >Name</label></td>
                                    <td><input class="input-block-level" name="name"/></td>
                                </tr>
                                <tr>
                                    <td><label >Muscle Group</label></td>
                                    <td><input class="input-block-level" name="muscleGroup"/></td>
                                </tr>
                                <tr>
                                    <td><label >Repetitions</label></td>
                                    <td><input class="input-block-level" name="repitions"/></td>
                                </tr>
                                <tr>
                                    <td><label >Exercise Sets</label></td>
                                    <td><input class="input-block-level" name="exerciseSets"/></td>
                                </tr>
                                <tr>
                                    <td><label >Weight</label></td>
                                    <td><input class="input-block-level" name="weight"/></td>
                                </tr>
                                <td colspan="2">
                                    <input class="btn" type="submit" value="Add Exercise"/>
                                </td>
                            </table> 
                        </form>
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
