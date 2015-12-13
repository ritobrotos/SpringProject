<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Place Details</title>
<style>
#mapView {
	width: 500px;
	height: 380px;
}
</style>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
	function initialize() {
		var myLatLng = new google.maps.LatLng(${placeInfo.latitude}, ${placeInfo.longitude});
		  var mapProp = {
		    center:myLatLng,
		    zoom:13,
		    mapTypeId:google.maps.MapTypeId.ROADMAP
		  };
		  var map=new google.maps.Map(document.getElementById("mapView"),mapProp);
		  
		  var marker = new google.maps.Marker({
			    position: myLatLng,
			    map: map,
			    title: '${placeInfo.name}'
			  });
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="page-header">
					<h1>${placeInfo.name}
						<small>- Detailed Info</small>
					</h1>
					<p>Category: ${placeInfo.category}</p>
					<p>Rating: ${placeInfo.rating}</p>
				</div>

				<div id="mapView"></div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>