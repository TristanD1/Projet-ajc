<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script defer src="quete.js"></script>
<link rel="stylesheet" href="css/queteStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
</head>

<body>
	<nav>
		<ul>
			<li><a href="accueil"> <img src="assets/img/accueil.svg"
					width="100"> Accueil
			</a></li>
			<li><a href="aventurier"> <img src="assets/img/aventurier.svg">Aventuriers
			</a></li>
			<li><a href="equipement"> <img src="assets/img/equipement.svg">
					Equipements
			</a></li>
		</ul>
	</nav>
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
				<tr>
					<td id="intitule">N°1</td>
					<td></td>
					<td><input type="image" src="dev/livre.svg"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
						aria-controls="offcanvasRight" id="btn-details"></td>
					<td><button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#ModalChoix"
							id="btn-choix">Choisir</button></td>
				</tr>
				<tr>
					<td id="intitule">N°2</td>
					<td></td>
					<td><input type="image" src="dev/livre.svg"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
						aria-controls="offcanvasRight" id="btn-details"></td>
					<td><button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#ModalChoix"
							id="btn-choix">Choisir</button></td>
				</tr>
				<tr>
					<td id="intitule">N°3</td>
					<td></td>
					<td><input type="image" src="dev/livre.svg"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
						aria-controls="offcanvasRight" id="btn-details"></td>
					<td><button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#ModalChoix"
							id="btn-choix">Choisir</button></td>
				</tr>
			</tbody>
		</table>

		<div class="modal fade" id="ModalChoix" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 id="intituleQueteChoisir">toto</h5>
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
								<tr>
									<td></td>
									<td>
										<div class="dropdown">
											<button class="btn btn-secondary dropdown-toggle"
												type="button" id="dropdownMenu" data-bs-toggle="dropdown"
												aria-expanded="false">Choisir un equipement</button>
											<ul class="dropdown-menu"
												aria-labelledby="dropdownMenuButton1">
												<li><a class="dropdown-item" href="#" id="eq">Action</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Another
														action</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Something
														else here</a></li>
											</ul>
										</div>
									</td>
									<td><a class="btn btn-danger" id="ajout">Ajouter</a></td>
									<td id="statut"><i class="bi bi-person-x-fill"
										id="imageStatut"></i></td>

								</tr>
								<tr>
									<td></td>
									<td>
										<div class="dropdown">
											<button class="btn btn-secondary dropdown-toggle"
												type="button" id="dropdownMenu" data-bs-toggle="dropdown"
												aria-expanded="false">Choisir un equipement</button>
											<ul class="dropdown-menu"
												aria-labelledby="dropdownMenuButton1">
												<li><a class="dropdown-item" href="#" id="eq">Action2</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Another
														action2</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Something
														else here2</a></li>
											</ul>
										</div>
									</td>
									<td><a class="btn btn-danger" id="ajout">Ajouter</a></td>
									<td id="statut"><i class="bi bi-person-x-fill"
										id="imageStatut"></i></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<div class="dropdown">
											<button class="btn btn-secondary dropdown-toggle"
												type="button" id="dropdownMenu" data-bs-toggle="dropdown"
												aria-expanded="false">Choisir un equipement</button>
											<ul class="dropdown-menu"
												aria-labelledby="dropdownMenuButton1">
												<li><a class="dropdown-item" href="#" id="eq">Action</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Another
														action</a></li>
												<li><a class="dropdown-item" href="#" id="eq">Something
														else here</a></li>
											</ul>
										</div>
									</td>
									<td><a class="btn btn-danger" id="ajout">Ajouter</a></td>
									<td id="statut"><i class="bi bi-person-x-fill"
										id="imageStatut"></i></td>
								</tr>
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
				<h5 id="intituleQueteDetails">Intitule</h5>
				<button type="button" class="btn-close text-reset"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<h6>Description :</h6>
				<p id="description">Blablabla</p>
				<footer>
					<button type="button" class="btn btn-success"
						data-bs-toggle="modal" data-bs-target="#ModalChoix"
						id="btn-choix2">Choisir</button>
				</footer>
			</div>
		</div>

	</section>
	<img src="dev/FondDeQuete.jpg" id="imageDroite">
	<!-- <img src="dev/papyrus.jpg" id="papyrus"> -->

</body>

</html>