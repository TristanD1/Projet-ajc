<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
		<%@ page pageEncoding="UTF-8" %>
			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>Choisissez votre quête !</title>
				<meta name="description" content="Choisissez votre qu�te !" />
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
					crossorigin="anonymous">
				<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
					crossorigin="anonymous"></script>
				<script defer src="assets/js/quete.js"></script>
				<link rel="stylesheet" href="assets/css/queteStyle.css">
				<link rel="stylesheet"
					href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
			</head>

			<body>
				<t:layout argent="${argent}"></t:layout>
				<header>
					<h1>Quêtes</h1>
				</header>
				<section>
					<h2>Liste des quêtes disponibes</h2>

					<table class="table table-striped table-hover" id="tableauQuete">
						<thead>
							<tr>
								<th>Intitulé de la quête</th>
								<th>Difficulté</th>
								<th>Compétences demandées</th>
								<th>Statut</th>
								<th>Description</th>
								<th>Sélection</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ quetes }" var="quete">
								<tr>
									<td id="intitule">${ quete.intitule }</td>
									<td>${ quete.difficulte }</td>
									<td>
										<c:forEach items="${ quete.getCompetences() }" var="competence">
											<p>${ competence.nom } (+ ${ competence.bonus })</p>
										</c:forEach>
									</td>
									<td>${ quete.etat }</td>
									<td>
										<input type="image" src="assets/img/livre.svg" data-bs-toggle="offcanvas"
											data-bs-target="#offcanvasRight-${ quete.id }"
											aria-controls="offcanvasRight" id="btn-details">
									</td>
									<td>
										<button type="button" class="btn btn-success" data-bs-toggle="modal"
											data-bs-target="#ModalChoix-${ quete.id }" id="btn-choix">Choisir</button>
									</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>

					<c:forEach items="${ quetes }" var="quete">
						<div class="modal fade" id="ModalChoix-${ quete.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h5 id="intituleQueteChoisir">${quete.intitule}</h5>
									</div>
									<div class="modal-body">
										<table class="table table-striped table-hover" id="tableauPopup">
											<thead>
												<tr>
													<th>Aventurier</th>
													<th>Expérience</th>
													<th>Compétences</th>
													<th>Choix de l'équipement</th>
													<th>Equipement sélectionné</th>
													<th>Ajouter</th>
													<th>Statut</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${aventuriers}" var="aventurier">
													<c:if test="${aventurier.isRecru() && !(aventurier.getEtat().toLowerCase().equals('blesse')) }">
														<tr>
															<td>${aventurier.nom}</td>
															<td>${ aventurier.experience }</td>
															<td>
																<c:forEach items="${ aventurier.getCompetences() }"
																	var="competence">
																	<p>${ competence.nom } (+ ${ competence.bonus })</p>
																</c:forEach>
															</td>
															<td><a href="returnEquipement" type="button"
																	class="btn btn-danger">Choisir des
																	équipements</a>
															</td>
															<td>
																<c:forEach items="${equipements}" var="equipement">
																	<c:if
																		test="${equipement.aventurier.id == aventurier.id}">
																		<p>${equipement.recompense.nom}
																		</p>
																	</c:if>
																</c:forEach>
															</td>
															<c:if test="${quete.id != aventurier.quete.id}">
																<td><a data-aventurier="${aventurier.id }"
																		data-quete="${quete.id}" class="btn btn-danger"
																		id="ajout">Ajouter</a></td>
																<td id="statut"><i class="bi bi-person-x-fill"
																		id="imageStatut"></i></td>

															</c:if>
															<c:if test="${quete.id == aventurier.quete.id}">
																<td><a data-aventurier="${aventurier.id }"
																		data-quete="${quete.id}" class="btn btn-danger"
																		id="ajout">Enlever</a></td>
																<td id="statut"><i class="bi bi-person-check-fill"
																		id="imageStatut"></i></td>
															</c:if>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<a type="submit" href="lancer-quete?idQuete=${quete.id}" class="btn btn-danger">
											<i class="bi-flower1"></i> Lancer la quête <i class="bi-flower1"></i>
										</a>
										<button href="quete" type="button" class="btn btn-secondary"
											data-bs-dismiss="modal" id="close">Annuler</button>
									</div>
								</div>
							</div>
						</div>


						<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight-${ quete.id }"
							aria-labelledby="offcanvasRightLabel">
							<div class="offcanvas-header">
								<h5 id="intituleQueteDetails">${quete.intitule}</h5>
								<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
									aria-label="Close"></button>
							</div>
							<div class="offcanvas-body">
								<h6>Description :</h6>

								<p id="description">${ quete.description }</p>

								<footer>
									<button type="button" class="btn btn-success" data-bs-toggle="modal"
										data-bs-target="#ModalChoix-${ quete.id }" id="btn-choix2">Choisir</button>
								</footer>
							</div>
						</div>
					</c:forEach>
				</section>
				<img src="assets/img/FondDeQuete.jpg" id="imageDroite">

			</body>

			</html>