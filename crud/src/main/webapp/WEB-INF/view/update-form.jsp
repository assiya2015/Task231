<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Save user</title>
</head>
<body>

<h2>Update User</h2>

<form:form action="updateUser" modelAttribute="user" method="POST">
    <!-- need to associate this data with user id -->
    <form:hidden path="id"/>

    <table>
        <tbody>
        <tr>
            <td><label>First name:</label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><label>Last name:</label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td><label>Email:</label></td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Update" class="update" /></td>
        </tr>

        </tbody>
    </table>

</form:form>

<p>
    <a href="${pageContext.request.contextPath}/list">Back to list</a>
</p>
</body>
</html>