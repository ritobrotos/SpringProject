<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Place List</title>
</head>
<body>
<h1>
	Place List 
</h1>

<table>
	<c:forEach items="${placelist}" var="place">
		 <tr>
            <td>${place.id}</td>
            <td>${place.name}</td>
            <td>${place.category}</td>
        </tr>
	</c:forEach>
</table>
</body>
</html>
