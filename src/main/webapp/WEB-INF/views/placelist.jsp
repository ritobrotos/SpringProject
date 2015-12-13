<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Place List</title>
	<style type="text/css">
		.placeCard{
			background-color: #ccffcc;
			padding-top: 2px;
			padding-left: 20px;
			padding-bottom: 2px;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="page-header">
				  <h1>Place Lookup <small>- searching made easy!</small></h1>
				</div>
				
				<c:forEach items="${placelist}" var="place">
					<div class="placeCard">
					  	<h3>${place.name} <small> Rating: ${place.rating} </small></h3>
						<p>
							Category: ${place.category} | <a>Locate on Map</a>
						</p>
					</div>
				</c:forEach>
				
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>
