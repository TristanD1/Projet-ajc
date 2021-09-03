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
<title>Aventuriers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/aventurierStyle.css">
</head>
<body>
	<header>
		<h1>Aventuriers</h1>
	</header>

	<t:layout></t:layout>

	<section>
		<h2>Recruter un aventurier</h2>

		<table id="recrutement" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Expérience</th>
					<th>Coût</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ aventurierRecrutement }" var="aventurier">
					<tr>
						<td>${ aventurier.nom }</td>
						<td>${ aventurier.experience }</td>
						<td>${ aventurier.cout }</td>

						<td><a href="recruter-aventurier?id=${ aventurier.id }"
							class="btn btn-info">Recruter</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Vos aventuriers</h2>

		<table id="guilde" class="table table-dark">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Expérience</th>
					<th>Etat de santé</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ aventurierGuilde }" var="aventurier">
					<tr>
						<td>${ aventurier.nom }</td>
						<td>${ aventurier.experience }</td>
						<td>${ aventurier.etat }</td>

						<td><a href="renvoyer-aventurier?id=${ aventurier.id }"
							class="btn btn-danger">Renvoyer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>