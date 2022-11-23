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
				<li><a href="" class="nav-link"><h1 style="color:black;margin-left:200px">Gestion des clients</h1></a></li>
			
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${cli != null}">
					<form action="Client?action=modifierClient" method="post">
				</c:if>
				<c:if test="${cli == null}">
					<form action="Client?action=ajouterClient" method="post">
				</c:if>

				<caption>
					<h4 style="font-family:cursive;margin-top:10px;margin-bottom:50px">
						<c:if test="${cli != null}">
            			Modifier Client
            		</c:if>
						<c:if test="${cli == null}">
            			Ajouter Nouveau Client
            		</c:if>
					</h4>
				</caption>

				<c:if test="${cli != null}">
					<input type="hidden" name="id" value="<c:out value='${cli.getIdCli()}' />" />
				</c:if>

				<fieldset class="form-group">
				 <input type="text" value="<c:out value='${cli.getNomCli()}'/>"
						 class="form-control"
						name="nom" placeholder="Nom">
				</fieldset>

				<fieldset class="form-group">
					 <input type="text" value="<c:out value='${cli.getPrenomCli()}'/>"
						  class="form-control"
						name="prenom" placeholder="Prénom">
				</fieldset>

				<fieldset class="form-group">
					<input type="text" value="<c:out value='${cli.getAdresseCli()}'/>"
					    class="form-control"
						name="adresse" placeholder="Adresse">
				</fieldset>
				
				<fieldset class="form-group">
					 <input type="text" value="<c:out value='${cli.getTelCli()}'/>"
					    class="form-control"
						name="tel" placeholder="Tel">
				</fieldset>
				
				<fieldset class="form-group">
					<input type="text" value="<c:out value='${cli.getVilleCli()}'/>"
					    class="form-control"
						name="ville" placeholder="Ville">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success mt-2">Enregistrer</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>