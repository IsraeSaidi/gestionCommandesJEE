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
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Gestion des produits</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${prod != null}">
					<form action="Produit?action=modifierProduit" method="post">
				</c:if>
				<c:if test="${prod == null}">
					<form action="Produit?action=ajouterProduit" method="post">
				</c:if>

				<caption>
					<h4 style="font-family:cursive;margin-top:10px;margin-bottom:50px">
						<c:if test="${prod != null}">
            			Modifier produit
            		</c:if>
						<c:if test="${prod == null}">
            			Ajouter Nouveau produit
            		</c:if>
					</h4>
				</caption>

				<c:if test="${prod != null}">
					<input type="hidden" name="id" value="<c:out value='${prod.getIdProd()}' />" />
				</c:if>

				<fieldset style="margin-bottom:15px">
					 <input type="text" value="<c:out value='${prod.getNomProd()}'/>"
						 class="form-control"
						name="nom" placeholder="Nom">
				</fieldset>

				<fieldset style="margin-bottom:15px" >
					 <input type="text" value="<c:out value='${prod.getPrixUnitaire()}'/>"
						  class="form-control"
						name="prix" placeholder="Prix">
				</fieldset>

				<fieldset style="margin-bottom:15px">
					 <input type="text" value="<c:out value='${prod.getQteStock()}'/>"
					    class="form-control"
						name="qte" placeholder="QTE commandée">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>