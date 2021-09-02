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
<title>Choisissez votre quête !</title>
<meta name="description" content="Choisissez votre quête !" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<script src="assets/js/quete.js"></script>
<link rel="stylesheet" href="assets/css/queteStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
</head>

<body>
	<t:layout></t:layout>
	<header>
		<h1>Quêtes</h1>
	</header>
	<section>
		<h2>Liste des quêtes disponibes</h2>

		<table class="table table-striped table-hover" id="tableauQuete">
			<thead>
				<tr>
					<th>Intitulé de la quête</th>
					<th>Expérience nécessaire</th>
					<th>Description</th>
					<th>Sélection</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ quetes }" var="quete">
					<tr>
						<td id="intitule">${ quete.intitule }</td>
						<td></td>
						<td><input type="image" src="dev/livre.svg"
							data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
							aria-controls="offcanvasRight" id="btn-details"></td>
						<td><button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#ModalChoix"
								id="btn-choix">Choisir</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="modal fade" id="ModalChoix" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 id="intituleQueteChoisir"></h5>
					</div>
					<div class="modal-body">
						<table class="table table-striped table-hover" id="tableauPopup">
							<thead>
								<tr>
									<th>Aventurier</th>
									<th>Choix de l'équipement</th>
									<th>Ajouter</th>
									<th>Statut</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${aventuriers}" var="aventurier">
									<tr>
										<td>${aventurier.nom}</td>
										<td>
											<div class="dropdown">
												<button class="btn btn-secondary dropdown-toggle"
													type="button" id="dropdownMenu" data-bs-toggle="dropdown"
													aria-expanded="false">Choisir un equipement</button>
												<c:forEach items="${equipements}" var="equipement">
													<ul class="dropdown-menu"
														aria-labelledby="dropdownMenuButton1">
														<li><a class="dropdown-item" href="#" id="eq">${equipement.nom}</a></li>
													</ul>
												</c:forEach>
											</div>
										</td>
										<td><a class="btn btn-danger" id="ajout">Ajouter</a></td>
										<td id="statut"><i class="bi bi-person-x-fill"
											id="imageStatut"></i></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<a class="btn btn-danger"> <i class="bi-flower1"></i> Lancer
							la quête <i class="bi-flower1"></i>
						</a>
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal" id="close">Annuler</button>
					</div>
				</div>
			</div>
		</div>

		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
			aria-labelledby="offcanvasRightLabel">
			<div class="offcanvas-header">
				<h5 id="intituleQueteDetails"></h5>
				<button type="button" class="btn-close text-reset"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<h6>Description :</h6>
				<c:forEach items="${quetes}" var="quete">
					<p id="description">${ quete.description }</p>
				</c:forEach>
				<footer>
					<button type="button" class="btn btn-success"
						data-bs-toggle="modal" data-bs-target="#ModalChoix"
						id="btn-choix2">Choisir</button>
				</footer>
			</div>
		</div>

	</section>
	<img src="assets/img/FondDeQuete.jpg" id="imageDroite">

</body>

</html>