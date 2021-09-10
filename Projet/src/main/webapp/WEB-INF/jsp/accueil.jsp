<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Projet</title>
		<meta name="description" content="Gérez votre guilde d'aventuriers !" />
		<link rel="stylesheet" href="assets/css/accueilStyle.css">
	</head>

	<t:layout argent="${argent}"></t:layout>

	<body>
		<header>
			<h1>Accueil</h1>
		</header>

		<t:layout></t:layout>

		<section>
			<div>
				<h2>Bienvenue à l'auberge du sanglier assoiffé, celle-ci servira
					de quartier général aux opérations de votre guilde d'aventuriers.</h2>
				<h3>Voici quelques conseils pour bien commencer en tant que
					maître de guilde :</h3>
				<p id="intro">
					- Dans l'onglet <i>Aventuriers</i>, vous avez accès aux différents
					membres de votre guilde ainsi qu'à leurs statistiques. <br> <br>
					- Les différents objets que vous avez acheté ou gagné lors de vos
					aventures sont accessibles dans l'onglet <i>Equipement</i>. <br>
					<br> - Les quêtes disponibles sont accessibles dans l'onglet <i>Quête</i>.<br>
					<br> - Pour lancer une mission, vous devrez tout d'abord
					choisir la quête. Vous pourrez ensuite sélectionner les aventuriers
					que vous voulez voir participer à cette aventure ainsi que leur
					leurs équipements.<br>
				</p>
				<h3>Vous êtes maintenant prêt. Bonne chance !</h3>
				<br>
			</div>
		</section>
	</body>

	</html>