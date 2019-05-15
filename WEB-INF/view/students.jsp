<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Hello World!</h2>

        <h3> Max score: ${maxStudent.name}</h3>
        <h3> Min score: ${minStudent.name}</h3>

        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>score</th>
                </tr>
            </thead>
            <c:forEach var="student" items="${students.content}">
                <tr>
                    <td align="center">${student.id}</td>
                    <td align="center">${student.name}</td>
                    <td align="center">${student.score}</td>
                </tr>
            </c:forEach>
        </table>
        <c:choose>
            <c:when test="${!students.last}">
                    <a href="?page=${students.number + 1}">Next &rarr;</a>
            </c:when>
            <c:when test="${students.last}">
                    <a href="?page=${students.number - 1}">Previous &larr;</a>
            </c:when>
            <c:otherwise>
                    <a href="?page=${students.number + 1}">Next &rarr;</a>
                    <a href="?page=${students.number - 1}">Previous &larr;</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>