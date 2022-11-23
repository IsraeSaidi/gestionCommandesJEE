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
  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href=
"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/577845f6a5.js"
        crossorigin="anonymous">
    </script>
 
    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js">
    </script>
    <script src=
"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js">
    </script>
    <script src=
"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js">
    </script>
	
	
</head>
<body>



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #D8D8D8">
			<div style="display: block">
				<a href="http://localhost:8080/gestionCommandes/"
					class="navbar-brand"> <img src="images/logo.png" width="25%">
				</a>

			</div>
			<ul class="navbar-nav">
				<li><a href="" class="nav-link">
				<h1 style="color: black; margin-left: 200px">Gestion des commandes</h1></a></li>

			</ul>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		
		<div class="card">
		<h5 style="margin-top:30px;font-family:cursive;margin-left:20px" >Ajouter commande</h5>
			<div class="card-body">
		
				<form action="Commande?action=ajouterCommande" method="post">


					<select name="idClient" class="custom-select" style="width:350px;" >
						<option selected>Choisir Client</option>
						<c:forEach var="client" items="${listeClients}">

							<option value="${client.getIdCli()}">${client.getNomCli()}</option>
						</c:forEach>

					</select>
					
					
					
					<input type="button" id="add" value="ligne Cmd" class="btn btn-warning" style="margin-left:20px"> 
					<h5 style="margin-top:30px;font-family:cursive" >Ajouter lignes de commandes</h5>
					<br> 
					
					<table>
					<td><input type="number" name="qte[]" class="form-control" placeholder="Qte" > </td>
					<td><select name="idProduit[]" style="width: 250px;" class="custom-select">
						<option selected>Choisir Produit</option>
						<c:forEach var="produit" items="${listeProduits}">

							<option value="${produit.getIdProd()}">${produit.getNomProd()}</option>
						</c:forEach>

					</select></td>
					</table>
					
						
						

					<div id="ajouterLC"></div>

					<input type="submit" class="btn btn-success mt-2" value="Enregistrer">

				</form>
			</div>

		</div>
	</div>
</body>
</html>

<script type="text/javascript">

var i = 1;
$("#add").click(function(){
++i;
$("#ajouterLC").append(`<hr>
		<table>
		<td><input type="number" name ="qte[${i}]"  class="form-control" placeholder="Qte" ></td>
		
		<td><select name="idProduit[${i}]" style="width: 250px;" class="custom-select">
		<option selected>Choisir Produit</option>
		<c:forEach var="produit" items="${listeProduits}">
			
		<option value="${produit.getIdProd()}">${produit.getNomProd()}</option>
		</c:forEach>
									
		</select></td> </table>`);
		

});



</script>



