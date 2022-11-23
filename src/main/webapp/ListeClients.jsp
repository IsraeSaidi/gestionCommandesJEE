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
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:270px">Gestion des clients</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h5 style="text-align:center;font-family:cursive">Nos Clients</h5>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/AjouterClient.jsp" class="btn btn-secondary">Ajouter un nouveau client</a>
			</div>
			<br>
			
			

			<table class="table table-hover">
				<thead>
					<tr class="table-success">
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse</th>
						<th>Tel</th>
						<th>Ville</th>
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="client" items="${listeClients}">

						<tr>
							<td style="width:10%"><c:out value="${client.getIdCli()}" /></td>
							<td style="width:10%"><c:out value="${client.getNomCli()}" /></td>
							<td style="width:10%"><c:out value="${client.getPrenomCli()}" /></td>
							<td style="width:20%"><c:out value="${client.getAdresseCli()}" /></td>
							<td style="width:15%"><c:out value="${client.getTelCli()}" /></td>
							<td style="width:15%"><c:out value="${client.getVilleCli()}" /></td>
						
					
							<td style="width:15%"><a href="Client?action=editClient?id=<c:out value='${client.getIdCli()}' />"><img src="images/editer.png" width=15% style="margin-left:20px"></a>
							<a href="Client?action=supprimerClient?id=<c:out value='${client.getIdCli()}' />"><img src="images/supp.png" width=15% style="margin-left:10px"></a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			
			
			

			

		</div>
	</div>
</body>
</html>