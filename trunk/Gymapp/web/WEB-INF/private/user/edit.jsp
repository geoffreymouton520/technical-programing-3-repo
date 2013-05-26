<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>Exercise Manager</h2>
        <form class="form-actions" method="post" action="exerciseupdate.html">
            <table>
                <tr>
                    <td><label >Calories Burned</label></td>
                    <td><input class="input-block-level" name="caloriesBurned" value="${exercise.caloriesBurned}"/></td>
                </tr>
                <tr>
                    <td><label >Description</label></td>
                    <td><input class="input-block-level"  name="description" value="${exercise.description}"/></td>
                </tr>
                <tr>
                    <td><label >Equipment</label></td>
                    <td><input class="input-block-level" name="equipment" value="${exercise.equipment}"/></td>
                </tr>
                <tr>
                    <td><label >Instructions</label></td>
                    <td><input class="input-block-level" name="instructions" value="${exercise.instructions}"/></td>
                </tr>
                <tr>
                    <td><label >Name</label></td>
                    <td><input class="input-block-level" name="name" value="${exercise.name}"/></td>
                </tr>
                <tr>
                    <td><label >Muscle Group</label></td>
                    <td><input class="input-block-level" name="muscleGroup" value="${exercise.muscleGroup}"/></td>
                </tr>
                <tr>
                    <td><label >Repetitions</label></td>
                    <td><input class="input-block-level" name="repitions" value="${exercise.repitions}"/></td>
                </tr>
                <tr>
                    <td><label >Exercise Sets</label></td>
                    <td><input class="input-block-level" name="exerciseSets" value="${exercise.exerciseSets}"/></td>
                </tr>
                <tr>
                    <td><label >Weight</label></td>
                    <td><input class="input-block-level" name="weight" value="${exercise.weight}"/></td>
                </tr>
                <input type="hidden" name="id" value="${exercise.id}">
                <td colspan="2">
                    <input class="btn" type="submit" value="Update Exercise"/>
                </td>
            </table> 
            
        </form>
    </jsp:body>
</t:genericpage>
