<%--@elvariable id="singleUser" type="java"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<head>
    <title>Bye Page!</title>
</head>
<body>
<div>PROJECT_JD</div>
</body>
<div>
    <h1>Results:</h1>
</div>
    <table>
        <tr>
            <td>

                <table>
                    <tr><td>
                        <table border="5" style="background-color: aquamarine" style="position:absolute">
                            <caption>USERS</caption>
                            <tr>
                                <td>User Id</td>
                                <td>User Name</td>
                                <td>User Surname</td>
                                <td>Birth date</td>
                                <td>Login</td>
                                <td>Weight</td>
                                <td>Edit</td>
                                <td>Delete</td>
                            </tr>
                            <%--        Show all users from collection of elements by jstl--%>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.surname}</td>
                                    <td>${user.birthDate}</td>
                                    <td>${user.login}</td>
                                    <td>${user.weight}</td>
                                    <td>
                                        <button>Edit</button>
                                    </td>
                                    <td>
                                        <button>Delete</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td></tr>
                </table>
            </td>
            <td>
                <table>
                    <tr><td>
                        <table align="center" border="5" style="background-color: aqua" style="position:absolute; left:50px">
                            <caption>CARS</caption>
                            <tr>
                                <td>Car Id</td>
                                <td>Car Name</td>
                                <td>Car Model</td>
                                <td>Product_date</td>
                                <td>Price</td>
                                <td>Edit</td>
                                <td>Delete</td>
                            </tr>
                            <%--        Show all users from collection of elements by jstl--%>
                            <c:forEach var="car" items="${cars}">
                                <tr>
                                    <td>${car.id}</td>
                                    <td>${car.name}</td>
                                    <td>${car.model}</td>
                                    <td>${car.production_date}</td>
                                    <td>${car.price}</td>
                                    <td>
                                        <button>Edit</button>
                                    </td>
                                    <td>
                                        <button>Delete</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td></tr>
                </table>
            </td>
        </tr>
    </table>

 <div>
    ${singleUser}
</div>
</div>
</html>
