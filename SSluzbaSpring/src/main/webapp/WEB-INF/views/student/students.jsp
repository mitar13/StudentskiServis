<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	All students:
	<table id="students">
		<thead>
		<tr>
		<th>Ime</th>
		<th>Prezime</th>
		<th>Pol</th>
		<th>God Rodjenja</th>
		<th>Sport</th>
		<th>Hobi</th>
		<th>Indeks</th>
		
		</tr>
		</thead>
		
		<tbody>
	
	</tbody>
	</table>
	



<form action="/driver/save" method="get">
		<input type="submit" value="insert" name="Submit" />
	</form>
	Quick insert:
	<input type="text" id="quickInsertFN" placeholder="first name" />
	<input type="text" id="quickInsertLN" placeholder="last name" />
	<input type="text" id="quickInsertAG" placeholder="age" />
	<input type="button" value="insert" id="quickInsert" />
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script> 
		jQuery(document).ready(function() {
			var table = $('#students tbody');
			$.ajax({
				type : "GET",
				url : "/api/student/all",
				success : function(students) {
					students.forEach(function(student) {
						table.append(prepareTableData(student));
						prepareDeleteWithJavascript();
						
					});

				},
				failure : function(e) {
					alert("NOT ADDED!");
				},
				contentType : "application/json; charset=utf-8"
			});

 			$("#quickInsert").on('click', function() {
				var data = {
					firstName : $("#quickInsertFN").val(),
					lastName : $("#quickInsertLN").val(),
					age : $("#quickInsertAG").val()
				};

				$.ajax({
					type : "POST",
					url : "/api/driver/saveDriver",
					data : JSON.stringify(data),
					success : function(driver) {
						
						table.append(prepareTableData(driver));
						alert("ADDED!");
						prepareDeleteWithJavascript();
					},
					failure : function(e) {
						alert("NOT ADDED!");
					},
					contentType : "application/json; charset=utf-8"
				});

			});

		});
		function prepareTableData(data) {
			
			console.log(data);
			var html = "<tr>";
			html = html + "<td>" + data.getIme() + "</td>";
			html = html + "<td>" + data.getPrezime() + "</td>";
			html = html + "<td>" + data.getPol() + "</td>";
			html = html + "<td>" + data.getGodRodjenja() + "</td>";
			html = html + "<td>" + data.getSport() + "</td>";
			html = html + "<td>" + data.getHobi() + "</td>";
			html = html + "<td>" + data.getIndeks() + "</td>";
			html = html + "<td>"
//             for(var i in data.licences){
//                 if(i==0){
//                  html = html + data.licences[i].category ;}
//                 else{
//                     html = html + ", " + data.licences[i].category 
//                 }
//             }
//             html +=  "</td>";
//             html = html + "<td>"
//             for(var i in data.rides){
//                 if(i==0){
//                  html = html + data.rides[i].rideId ;}
//                 else{
//                     html = html + ", " + data.rides[i].rideId
//                 }
//             }
            html +=  "</td>";
			html = html
					+ "<td><button type='button' value='" + data.id + "'>Edit</button><td>";
			html = html + "</tr>";
			return html;
		}

		//		function deleteStudent()
		function prepareDeleteWithJavascript() {
			var buttonsForDelete = document.getElementsByTagName('button');
			Array.from(buttonsForDelete).forEach(function(element) {
				element.addEventListener('click', function(){
					var request = new XMLHttpRequest();
					request.open("POST", "http://localhost:8080/api/student/edit/" + element.getAttribute('value'));
					request.send();
					request.onreadystatechange = function(){
						if(request.status === 200) {
						    var selectedElement = document.querySelector('button[value="' + element.getAttribute('value') + '"]')
						    selectedElement.parentElement.parentElement.remove();
						}
					}
				});
				
			});
		}
		
	</script>



</body>
</html>

