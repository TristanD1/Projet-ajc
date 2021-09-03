<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>ADMIN - Création / Modification des quêtes</title>

<meta name="description" content="Choisissez votre quête !" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="assets/css/creationQueteStyle.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>

</head>

<body>
	<header>
		<h1>Quêtes</h1>
	</header>

	<t:layout></t:layout>

	<form method="POST">
		<h2>Ajouter une quête</h2>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="intitule" class="form-label">Intitulé :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="intitule"
					name="intitule" value="${ quete.intitule }" />
			</div>
		</div>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="difficulte" class="form-label">Difficulté :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="difficulte"
					name="difficulte" value="${ quete.difficulte }" />
			</div>
		</div>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="description" class="form-label">Description :</label>
			</div>

			<div class="col-10">
				<input class="form-control" type="text" id="description"
					name="description" value="${ quete.description }" />
			</div>
		</div>

		<div class="row">
			<div class="col-2 col-form-label">
				<label for="recompenses" class="form-label">Recompense :</label>
			</div>

			<div class="col-10">
				<select class="form-select" name="recompense.id">
					<c:forEach items="${ recompenses }" var="recompense">
						<option value="${ recompense.id }">${ recompense.nom }</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="row">
			<c:if test="${ quete == null }">
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</c:if>

			<c:if test="${ quete != null }">
				<input type="submit" class="btn btn-warning" value="Modifier" />
			</c:if>
		</div>
	</form>

	<section>
		<h2>Quêtes</h2>

		<table class="table table-striped table-hover" id="tableauQuete">
			<thead>
				<tr>
					<th>Intitulé</th>
					<th>Difficulté</th>
					<th>Description</th>
					<th>Recompense</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>${ quete.intitule }</td>
					<td>${ quete.difficulte }</td>
					<td>${ quete.description }</td>
					<td>${ quete.recompense.nom }</td>
					<td><a href="modifier-quete?id=${ quete.id }"
						class="btn btn-warning">Modifier</a> <a
						href="supprimer-quete?id=${ quete.id }" class="btn btn-danger">Supprimer</a></td>
				</tr>
			</tbody>
		</table>
	</section>
</body>
</html>