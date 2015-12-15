<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>

  <h3>Все студенты:</h3>(<a href="add">добавить</a>)
  <ol>
    <c:forEach items = "${students}" var="student">
      <li>
        ${student.name} ${student.lastName} - ${student.age} <a href="add?edit=${student.id}">редактировать</a> | <a href="delete?id=${student.id}">удалить</a>
      </li>
    </c:forEach>
  </ol>
</body>
</html>
