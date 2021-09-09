<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

			<!DOCTYPE html>
			<html lang="en">

			<head>

				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">

				<title>ADMIN - Création / Modification des aventuriers</title>

				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
					crossorigin="anonymous">
				<link rel="stylesheet" href="assets/css/creationAventurierStyle.css">

			</head>

			<body>
				<header>
					<h1>Aventuriers</h1>
				</header>

				<t:layout></t:layout>

				<form method="POST">
					<h2>Ajouter un aventurier</h2>

					<div class="row">
						<div class="col-2 col-form-label">
							<label for="nom" class="form-label">Nom de l'aventurier :</label>
						</div>

						<div class="col-10">
							<input class="form-control" type="text" id="nom" name="nom" value="${ aventurier.nom }" />
						</div>
					</div>

					<div class="row">
						<div class="col-2 col-form-label">
							<label for="experience" class="form-label">Expérience de
								l'aventurier :</label>
						</div>

						<div class="col-10">
							<input class="form-control" type="text" id="experience" name="experience"
								value="${ aventurier.experience }" />
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

						<div class="col-1">
							<label class="form-label">Recruter :</label>
						</div>

						<div class="col-2">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" name="isRecru"
									id="flexCheckDefault">
							</div>
						</div>
					</div>

					<div class="row">
						<c:if test="${ aventurier == null }">
							<input type="submit" class="btn btn-success" value="Ajouter" />
						</c:if>

						<c:if test="${ aventurier != null }">
							<input type="submit" class="btn btn-warning" value="Modifier" />
						</c:if>
					</div>
				</form>

				<section>
					<h2>Aventuriers en recrutement</h2>

					<table class="table table-dark">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Expérience</th>
								<th>Coût</th>
								<th>Competences</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${ aventuriers }" var="aventurier">
								<c:if test="${ !aventurier.isRecru() }">
									<tr>
										<td>${ aventurier.nom }</td>
										<td>${ aventurier.experience }</td>
										<td>${ aventurier.cout }</td>
										<td>
											<c:forEach items="${ aventurier.competences }" var="competence">
												<p>${ competence.nom } (+${ competence.bonus })</p>
											</c:forEach>
										</td>
										<td><a href="modifier-aventurier?id=${ aventurier.id }"
												class="btn btn-warning">Modifier</a> <a
												href="supprimer-aventurier?id=${ aventurier.id }"
												class="btn btn-danger">Supprimer</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>

					<h2>Aventuriers en guilde</h2>

					<table class="table table-dark">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Expérience</th>
								<th>Compétences</th>
								<th>Etat de santé</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${ aventuriers }" var="aventurier">
								<c:if test="${ aventurier.isRecru() }">
									<tr>
										<td>${ aventurier.nom }</td>
										<td>${ aventurier.experience }</td>
										<td>
											<c:forEach items="${ aventurier.competences }" var="competence">
												<p>${ competence.nom } (+${ competence.bonus })</p>
											</c:forEach>
										</td>
										<td>${ aventurier.etat }</td>
										<td><a href="modifier-aventurier?id=${ aventurier.id }"
												class="btn btn-warning">Modifier</a> <a
												href="supprimer-aventurier?id=${ aventurier.id }"
												class="btn btn-danger">Supprimer</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</section>
			</body>

			</html>