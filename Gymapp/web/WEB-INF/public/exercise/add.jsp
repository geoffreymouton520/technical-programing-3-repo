<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
        <h2>Exercise Manager</h2>
        <form class="form-actions" method="post" action="exercisesave.html">
            <table>
                <tr>
                    <td><label >Calories Burned</label></td>
                    <td><input class="input-block-level" name="caloriesBurned"/></td>
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
    </jsp:body>
</t:genericpage>
