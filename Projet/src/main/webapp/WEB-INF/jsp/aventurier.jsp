<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>Aventuriers</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
					crossorigin="anonymous">
				<link rel="stylesheet" href="assets/css/aventurierStyle.css">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
					crossorigin="anonymous"></script>
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
				<script defer src="assets/js/aventurier.js"></script>
			</head>

			<body>
				<header>
					<h1>Aventuriers</h1>
				</header>

				<t:layout argent="${argent}"></t:layout>

				<section>
					<h2>Recruter un aventurier</h2>

					<table class="table table-dark">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Expérience</th>
								<th>Coût</th>
								<th>Compétences</th>
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
											<c:forEach items="${ aventurier.getCompetences() }" var="competence">
												<p>${ competence.nom } (+ ${ competence.bonus })</p>
											</c:forEach>
										</td>
										<td>
											<c:if test="${argent >= aventurier.cout}">
												<a href="recruter-aventurier?id=${ aventurier.id }"
												class="btn btn-info">Recruter</a>
											</c:if>
											<c:if test="${argent <= aventurier.cout}">
												<button class="btn btn-danger">Trop cher</button>
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>

					<h2>Vos aventuriers</h2>

					<table class="table table-dark">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Expérience</th>
								<th>Etat de santé</th>
								<th>Equipement</th>
								<th>Compétences</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${ aventuriers }" var="aventurier">
								<c:if test="${ aventurier.isRecru() }">
									<tr>
										<td>${ aventurier.nom }</td>
										<td>${ aventurier.experience }</td>
										<td>${ aventurier.etat }</td>
										<td id="forEquip">
											<c:forEach items="${ aventurier.equipements }" var="equipement">
												<a href="desequiper-aventurier?equipementId=${equipement.id }"
													class="btn btn-dark" data-nom="${ equipement.recompense.nom }"
													data-bonus="${ equipement.recompense.bonus }"
													data-descr="${ equipement.recompense.description }" />
												<img src="${ equipement.recompense.image }">
												</a>
											</c:forEach>
										</td>
										<td>
											<c:forEach items="${ aventurier.getCompetences() }" var="competence">
												<p>${ competence.nom } (+ ${ competence.bonus })</p>
											</c:forEach>
										</td>
										<td><a href="renvoyer-aventurier?id=${ aventurier.id }"
												class="btn btn-danger">Renvoyer</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</section>
			</body>

			</html>