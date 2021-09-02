<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="aventurierStyle.css">

<script defer src="aventurier.js"></script>
</head>

<body>
	<header>
		<h1>Aventuriers</h1>
	</header>

	<nav>
		<ul>
			<li><a href="accueil"><img src="assets/img/accueil.svg"
					width="100"> Accueil</a></li>

			<li><a href="equipement"><img src="assets/img/equipement.svg">Equipements</a>
			</li>

			<li><a href="quete"><img src="assets/img/quete.svg">
					Quetes</a></li>
		</ul>
	</nav>

	<form method="POST">
		<h2>Ajouter un aventurier</h2>

		<div>
			<label for="nom">Nom de l'aventurier :</label> <input type="text"
				id="nom" name="nom" />
		</div>

		<div>
			<label for="experience">Exp�rience :</label> <input type="text"
				id="experience" name="experience" />
		</div>

		<div>
			<label for="prix">Prix :</label> <input type="text" id="prix"
				name="prix" />
		</div>

		<div>
			<input type="submit" value="Ajouter"
				onclick="ajouterAventurierRecrutement(); return false;" />
		</div>
	</form>

	<section>
		<h2>Recruter un aventurier</h2>

		<table id="recrutement" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Exp�rience</th>
					<th>Prix</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>

			</tbody>
		</table>

		<h2>Vos aventuriers</h2>

		<table id="guilde" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Exp�rience</th>
					<th>Etat de sant�</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

			</tbody>
		</table>
	</section>
</body>

</html>