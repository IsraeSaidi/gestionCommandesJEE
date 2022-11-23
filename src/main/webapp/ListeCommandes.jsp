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
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
	
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #D8D8D8">
			<div style="display:block">
				<a href="http://localhost:8080/gestionCommandes/" class="navbar-brand"> <img src="images/logo.png" width="25%"> </a>
				
			</div>
			<ul class="navbar-nav" >
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Gestion des commandes</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>
	
	
	
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h5 style="text-align:center;font-family:cursive">Nos Commandes</h5>
			<hr>
			<div class="container text-left">

				<form action="Commande?action=nouvelleCommande" method="post">
				<input type = "submit" value="Ajouter une nouvelle commande" class="btn btn-secondary">
				</form>
			</div>
			<br>
			
			

			<table class="table table-hover">
				<thead>
					<tr class="table-success">
						<th>ID</th>
						<th>date</th>
						<th>client</th>
					
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="commande" items="${listeCommandes}">

						<tr>
							<td style="width:10%"><c:out value="${commande.getIdCmd()}" /></td>
							<td style="width:20%"><c:out value="${commande.getDateCmd()}" /></td>
							<td style="width:20%"><c:out value="${commande.getClient().getNomCli()}" /></td>
							
					
							<td style="width:30%">
                            <a href="Commande?action=editCommande?id=<c:out value='${commande.getIdCmd()}' />" ><img src="images/editer.png" width=6% style="margin-left:10px"></a>
							<a href="Commande?action=supprimerCommande?id=<c:out value='${commande.getIdCmd()}' />" ><img src="images/supp.png" width=6% style="margin-left:10px"></a>
							
							<a href="Commande?action=ligneCommandes?id=<c:out value='${commande.getIdCmd()}' />"  ><img src="images/file.png" width=6% style="margin-left:10px"></a></td>
						</tr>
						
	
						
						
						
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			
								
								
			
    			
			
			

			

		</div>
	</div>
</body>
</html>





