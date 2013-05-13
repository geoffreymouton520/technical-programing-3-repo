<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <title>Ares Gym</title>
   <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
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
          <a class="brand" href="#">Ares Gym</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#exercise">Exercise</a></li>
              <li><a href="#person">Person</a></li>
              <li><a href="#workout">Workout</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Sidebar</li>
              <li class="active"><a href="#">Crud</a></li>
              <li><a href="addExercise.html">Add Exercise</a></li>
              <li><a href="addPerson.html">Link</a></li>
              <li><a href="addWorkout.html">Link</a></li>
            </ul>
          </div>
        </div>
        <div class="span9">
          <div class="hero-unit">
            <h1>Welcome to Ares Gym</h1>
            <p>An online exercise application.</p>
          </div>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy: AresGym.com</p>
      </footer>

    </div><!--/.fluid-container-->






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head >
        <title>Ares Gym</title
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
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
            <h2>Exercise Manager</h2>
            <form method="post" action="saveExercise.html">
                <table>
                    <tr>
                        <td><label >Calories Burned</label></td>
                        <td><input type="text" name="caloriesBurned"/></td>
                    </tr>
                    <tr>
                        <td><label >Description</label></td>
                        <td><input  name="description"/></td>
                    </tr>
                    <tr>
                        <td><label >Equipment</label></td>
                        <td><input name="equipment"/></td>
                    </tr>
                    <tr>
                        <td><label >Instructions</label></td>
                        <td><input name="instructions"/></td>
                    </tr>
                    <tr>
                        <td><label >Name</label></td>
                        <td><input name="name"/></td>
                    </tr>
                    <tr>
                        <td><label >Muscle Group</label></td>
                        <td><input name="muscleGroup"/></td>
                    </tr>
                    <tr>
                        <td><label >Repetitions</label></td>
                        <td><input name="repitions"/></td>
                    </tr>
                    <tr>
                        <td><label >Exercise Sets</label></td>
                        <td><input name="exerciseSets"/></td>
                    </tr>
                    <tr>
                        <td><label >Weight</label></td>
                        <td><input name="weight"/></td>
                    </tr>
                    <td colspan="2">
                        <input type="submit" value="Add Exercise"/>
                    </td>
                </table> 
            </form>
                
        </div>
        <div id="pagefooter">
            &copy:AresGym.com
        </div>
    </body>
</html>
