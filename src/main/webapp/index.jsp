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
				<a href="" class="navbar-brand"> <img src="images/logo.png" width="25%"> </a>
				
			</div>
			<ul class="navbar-nav" >
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Application de gestion</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>
	
	
	<table style="margin-left:100px;margin-top:100px">
	<tr>
	<td style="width:33%"><a href="http://localhost:8080/gestionCommandes/Client"><img src="images/clients.png" width=50%><br></a></td>
	<td  style="width:33%"><a href="http://localhost:8080/gestionCommandes/Produit"><img src="images/products.png" width=60%><br></a></td>
	<td style="width:33%"><a  href="http://localhost:8080/gestionCommandes/Commande"><img src="images/commandes.png" width=80%><br></a></td>
	</tr>
	<tr>
	<td style="width:33%;"><a href="http://localhost:8080/gestionCommandes/Client" style="margin-left:40px">Gestion des clients</a></td>
	<td  style="width:33%"><a href="http://localhost:8080/gestionCommandes/Produit" style="margin-left:40px">Gestion des produits</a></td>
	<td style="width:33%"><a  href="http://localhost:8080/gestionCommandes/Commande" style="margin-left:60px">Gestion des commandes</a></td>
	</tr>
	
	
	</table>




</body>
</html>