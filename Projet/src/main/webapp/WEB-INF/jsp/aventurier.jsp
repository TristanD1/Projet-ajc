<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Aventuriers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/aventurierStyle.css">
<!-- <script defer src="assets/js/aventurier.js"></script> -->
</head>
<body>
	<header>
		<h1>Aventuriers</h1>
	</header>

	<nav>
		<ul>
			<li><a href="accueil"><img src="assets/img/accueil.svg"
					width="100"> Accueil</a></li>

			<li><a href="equipement"><img
					src="assets/img/equipement.svg">Equipements</a></li>

			<li><a href="quete"><img src="assets/img/quete.svg">
					Quetes</a></li>
		</ul>
	</nav>

	<form method="POST">
		<h2>Ajouter un aventurier</h2>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="nom" class="form-label">Nom de l'aventurier :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="nom" name="nom"
					value="${ aventurier.nom }" />
			</div>
		</div>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="experience" class="form-label">Expérience de
					l'aventurier :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="experience"
					name="experience" value="${ aventurier.experience }" />
			</div>
		</div>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="cout" class="form-label">Cout de l'aventurier :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="cout" name="cout"
					value="${ aventurier.cout }" />
			</div>
		</div>

		<div class="row">
			<input type="submit" class="btn btn-success" value="Ajouter" />
		</div>
	</form>

	<section>
		<h2>Recruter un aventurier</h2>

		<table id="recrutement" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Expérience</th>
					<th>Coût</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ aventurierRecrutement }" var="aventurier">
					<tr>
						<td>${ aventurier.nom }</td>
						<td>${ aventurier.experience }</td>
						<td>${ aventurier.cout }</td>

						<td><a href="recruter-aventurier?id=${ aventurier.id }"
							class="btn btn-info">Recruter</a> <a
							href="supprimer-aventurier?id=${ aventurier.id }"
							class="btn btn-danger">Supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Vos aventuriers</h2>

		<table id="guilde" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Expérience</th>
					<th>Etat de santé</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ aventurierGuilde }" var="aventurier">
					<tr>
						<td>${ aventurier.nom }</td>
						<td>${ aventurier.experience }</td>
						<td>${ aventurier.etat }</td>

						<td><a href="renvoyer-aventurier?id=${ aventurier.id }"
							class="btn btn-danger">Renvoyer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>

</html>