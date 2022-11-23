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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
					<form action="Commande?action=modifierLigneCommande" method="post">
					 	<input type="hidden" name="id" value="<c:out value='${ligneCommande.getIdLigneCmd()}' />" />
					 	<input type="hidden" name="idCmd" value="<c:out value='${ligneCommande.getCommande().getIdCmd()}' />" />
				
				
				<caption>
					<h4 style="font-family:cursive;margin-bottom:30px">
					
            			Modifier ligne de commande
            
					</h4>
				</caption>

			
<table>

				
					
					<td><input type="number" name ="qte" value="<c:out value='${ligneCommande.getQteProd()}' />" class="form-control" placeholder="Qte" >
				</td>

				<td>
					
			<select name="idProd" class="custom-select" style="width:200px;margin-left:20px">

			<c:forEach var="produit" items="${listeProduits}">
	
			<option value="${produit.getIdProd()}">${produit.getNomProd()}</option>
			</c:forEach>
							
</select>
				</td>
				</table>
				<button type="submit" class="btn btn-success" style="margin-top:20px">Enregistrer</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
