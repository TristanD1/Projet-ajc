<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
	<%@ page pageEncoding="UTF-8" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>

			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>ADMIN - Création / Modification des quêtes</title>

			<meta name="description" content="Choisissez votre quête !" />

			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
				crossorigin="anonymous">
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
			<link rel="stylesheet" href="assets/css/creationQueteStyle.css">

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
				crossorigin="anonymous"></script>

		</head>

		<body>
			<header>
				<h1>Quêtes</h1>
			</header>

			<t:layout argent="${argent}"></t:layout>

			<form method="POST">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
				<c:if test="${ quete == null }">
					<h2>Ajouter une quête</h2>
				</c:if>
				<c:if test="${ quete != null }">
					<h2>Modifier une quête</h2>
				</c:if>

				<div class="row">
					<div class="col-2 col-form-label">
						<label for="intitule" class="form-label">Intitulé :</label>
					</div>

					<div class="col-10">
						<input class="form-control" type="text" id="intitule" name="intitule"
							value="${ quete.intitule }" />
					</div>
				</div>

				<div class="row">
					<div class="col-2 col-form-label">
						<label for="difficulte" class="form-label">Difficulté :</label>
					</div>

					<div class="col-10">
						<input class="form-control" type="text" id="difficulte" name="difficulte"
							value="${ quete.difficulte }" />
					</div>
				</div>

				<div class="row">
					<div class="col-2 col-form-label">
						<label for="description" class="form-label">Description :</label>
					</div>

					<div class="col-10">
						<input class="form-control" type="text" id="description" name="description"
							value="${ quete.description }" />
					</div>
				</div>

				<div class="row">
					<div class="col-2">
						<label for="competences" class="form-label">Compétences :</label>
					</div>

					<div class="col-2">
						<c:forEach items="${ competences }" var="competence">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="${ competence.id }"
									name="competencesId" id="flexCheckDefault">
								<a>${ competence.nom } (+${ competence.bonus })</a>
							</div>
						</c:forEach>
					</div>

					<div class="col-2">
						<label for="recompenses" class="form-label">Recompenses :</label>
					</div>

					<div class="col-2">
						<c:forEach items="${ recompenses }" var="recompense">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="${ recompense.id }"
									name="recompensesId" id="flexCheckDefault">
								<a>${ recompense.nom } (+${ recompense.bonus })</a>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="row">
					<c:if test="${ quete == null }">
						<input type="submit" class="btn btn-success" value="Ajouter" />
					</c:if>

					<c:if test="${ quete != null }">
						<input type="submit" class="btn btn-warning" value="Modifier" />
						<a href="ajouter-quete" type="button">Annuler</a>
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
							<th>Compétences</th>
							<th>Recompenses</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${ quetes }" var="quete">
							<tr>
								<td>${ quete.intitule }</td>
								<td>${ quete.difficulte }</td>
								<td>${ quete.description }</td>
								<td>
									<c:forEach items="${ quete.getCompetences() }" var="competence">
										<p>${ competence.nom } (+${ competence.bonus })</p>
									</c:forEach>
								</td>
								<td>
									<c:forEach items="${ quete.getRecompenses() }" var="recompense">
										<p>${ recompense.nom } (+${ recompense.bonus })</p>
									</c:forEach>
								</td>
								<td><a href="modifier-quete?id=${ quete.id }" class="btn btn-warning">Modifier</a>
									<a href="supprimer-quete?id=${ quete.id }" class="btn btn-danger">Supprimer</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</body>

		</html>