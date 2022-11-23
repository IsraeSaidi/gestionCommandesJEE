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
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Gestion lignes commandes</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		

		<div class="container">
			<h5 class="text-center" style="font-family:cursive">Les lignes de commandes</h5>
			<hr>
			<form action="Commande?action=nouvelleLigneCommande" method="post">
				<input type = "submit" value="Ajouter ligne de commande" class="btn btn-secondary">
				</form>
			<br>
			
			

			<table class="table table-hover">
				<thead>
					<tr class="table-success">
						<th>ID</th>
						<th>Qte</th>
						<th>idCommande</th>
						<th>Nom Produit</th>
					
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="ligneCommande" items="${ligneCommandes}">
           
						<tr>
							<td style="width:10%"><c:out value="${ligneCommande.getIdLigneCmd()}" /></td>
							<td style="width:10%"><c:out value="${ligneCommande.getQteProd()}" /></td>
							<td style="width:10%"><c:out value="${ligneCommande.getCommande().getIdCmd()}" /></td>
							<td style="width:20%"><c:out value="${ligneCommande.getProduit().getNomProd()}" /></td>
							
							<td style="width:20%"><a href="Commande?action=editLigneCom?id=<c:out value='${ligneCommande.getIdLigneCmd()}' />" ><img src="images/editer.png" width=8% style="margin-left:20px"></a>
							<a  href="Commande?action=supprimerLigneCommande?id=<c:out value='${ligneCommande.getIdLigneCmd()}' />"><img src="images/supp.png" width=8% style="margin-left:20px"></a></td>
						
					
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			
			
			

			

		</div>
	</div>
</body>
</html>