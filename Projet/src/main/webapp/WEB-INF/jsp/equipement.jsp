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

<title>Equipement</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/equipementStyle.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script defer src="assets/js/equipement.js"></script>

</head>

<body>
	<t:layout></t:layout>
	<header>
		<h1>Inventaire</h1>
	</header>

	<section>

		<table class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Score d'equipement</th>
					<th>Quantite</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${equipements}" var="equipement">
					<tr>
						<td id="infobulle">
							<button class="btn btn-dark btn-md" data-nom="${ equipement.nom }" data-img="${ equipement.image }" data-descr="${ equipement.description }">${equipement.nom}</button>
						</td>
						<td>${equipement.bonus}</td>
						<td>${equipement.getEquipements().size()}</td>
						<td><button type="button" class="btn btn-success"
								data-bs-toggle="modal"
								data-bs-target="#ModalChoix-${ equipement.id }" id="btn-choix">equiper</button></td>
						<td id="vendre" data-equip="${ equipement.equipements }">
							<a href="vendre-equipement?idRec=${equipement.id}" class="btn btn-danger">Vendre</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:forEach items="${ equipements }" var="equipement">
			<div class="modal fade" id="ModalChoix-${ equipement.id }" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5>${equipement.nom}</h5>
						</div>
						<div class="modal-body">
							<table class="table table-striped table-hover" id="tableauPopup">
								<thead>
									<tr>
										<th>nom</th>
										<th>id</th>
										<th>Aventurier</th>
										<th>Equiper</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${equipement.equipements}" var="equip">
										<c:if test="${equip.aventurier == null }">
											<tr>
												<td>${equipement.nom}</td>
												<td>${equip.id}</td>
												<td>
													<div class="dropdown">
														<button class="btn btn-secondary dropdown-toggle"
															type="button" id="dropdownMenu" data-bs-toggle="dropdown"
															aria-expanded="false">Choisir un aventurier</button>
														<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
															<c:forEach items="${aventuriers}" var="aventurier">
																<li>
																	<a href="associer-equipement?idEquipement=${equip.id}&idAventurier=${aventurier.id }"
																		class="dropdown-item">${aventurier.nom}</a>
																</li>
															</c:forEach>
														</ul>
													</div>
												</td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</section>

</body>

</html>