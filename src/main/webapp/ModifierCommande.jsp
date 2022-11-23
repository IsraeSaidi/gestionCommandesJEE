<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #D8D8D8">
			<div style="display:block">
				<a href="http://localhost:8080/gestionCommandes/" class="navbar-brand"> <img src="images/logo.png" width="25%"> </a>
				
			</div>
			<ul class="navbar-nav" >
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Gestion des Commandes</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
					<form action="Commande?action=modifierCommande" method="post">
					 	<input type="hidden" name="id" value="<c:out value='${commande.getIdCmd()}' />" />
				
				
				<caption>
					<h4 style="font-family:cursive;margin-bottom:30px">
					
            			Modifier commande
            
					</h4>
				</caption>

			

				<table>
				<td><fieldset class="form-group">
					
					<input  class="form-control" style="width:200px;margin-right:30px" type="date" name ="date" value="<c:out value='${commande.getDateCmd()}'  />">
				</fieldset></td>
				
				<td><fieldset class="form-group">
				
					<select name="idClient" class="custom-select" style="width:250px;">
					<option selected>Choisir Client</option>
					<c:forEach var="client" items="${listeClients}">
	
					<option value="${client.getIdCli()}">${client.getNomCli()}</option>
					</c:forEach>
							
					</select>
				</fieldset></td>
			
				</table>
				

				<button type="submit" class="btn btn-success">Enregistrer</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>