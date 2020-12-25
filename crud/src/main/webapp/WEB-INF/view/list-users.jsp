<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html>

<head>
    <title>List Users</title>
</head>

<body>
<h1>User</h1>

        <input type="button" value="Add user"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />

<br/>
        <table border="1">

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempUser" items="${users}">

                <c:url var="updateLink" value="/showFormForUpdate">
                    <c:param name="userId" value="${tempUser.getId()}"/>
                </c:url>

                <c:url var="deleteLink" value="/delete">
                    <c:param name="userId" value="${tempUser.id}"/>
                </c:url>

                <tr>
                    <td> ${tempUser.firstName} </td>
                    <td> ${tempUser.lastName} </td>
                    <td> ${tempUser.email} </td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |

                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

</body>

</html>
