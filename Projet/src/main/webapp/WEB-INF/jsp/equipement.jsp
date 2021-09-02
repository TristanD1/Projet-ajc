<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Equipement</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/equipementStyle.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script defer src="assets/js/equipement.js"></script>

</head>

<body>
	<header>
		<h1>Inventaire</h1>
	</header>

	<nav>
		<ul>
			<li><a href="accueil"><img src="assets/img/accueil.svg"
					width="100"> Accueil</a></li>

			<li><a href="aventurier"><img
					src="assets/img/aventurier.svg"> Aventuriers</a></li>

			<li><a href="quete"><img src="assets/img/quete.svg">
					Quête</a></li>
		</ul>
	</nav>

	<section>

		<table class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Score d'équipement</th>
<!-- 					<th>Quantité</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${equipements}" var="equipement">
					<tr>
						<td>
							<button class="btn btn-success btn-md" id="tooltip">${equipement.recompense.nom}</button>
						</td>
						<td>${equipement.recompense.bonus}</td>
<%-- 						<td>${equipement.recompense.equipements.lenght()}</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

</body>

</html>