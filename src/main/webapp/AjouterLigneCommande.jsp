<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commande</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
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
				<h5 style="margin-top:30px;font-family:cursive;margin-left:20px" >Ajouter ligne de commande</h5>
			<div class="card-body">
				<form action="Commande?action=ajouterLigneCommande" method="post">
					<input type="hidden" name="idCmd"
						value="<c:out value='${commande.getIdCmd()}' />" /> 
						
						<table>
						 <td><input type="number" name="qte" class="form-control" placeholder="Qte" style="margin-right:30px"> </td>
						
						<td><select name="idProduit" class="custom-select" style="width:250px">
						<option selected>Choisir Produit</option>
						<c:forEach var="produit" items="${listeProduits}">

							<option value="${produit.getIdProd()}">${produit.getNomProd()}</option>
						</c:forEach>

					</select></td>
					</table>

					<div id="ajouterLC"></div>

					<input type="submit" class="btn btn-success" value="Enregistrer" style="margin-top:20px">

				</form>
			</div>

		</div>
	</div>
</body>
</html>





