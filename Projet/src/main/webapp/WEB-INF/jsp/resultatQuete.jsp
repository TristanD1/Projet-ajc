<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de la quête</title>
<meta name="description" content="Résultat de la quête" />
<link rel="stylesheet" href="assets/css/resultatStyle.css">
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
</head>


<body>
	<t:layout argent="${argent}"></t:layout>
<header>
<h1>Résultat de la quête :</h1>
</header>

<section>
		<h2>Détails</h2>

		<table class="table table-dark" id="tableauQuete">
			<thead>
				<tr>
					<th>Intitulé de la quête</th>
					<td>${quete.intitule}</td>
					</tr>
					<c:if test='${(quete.etat).equals("achevee")}'>
					<tr>
					<th>Résultat</th>
					<td>Succès</td>
					</tr>
					<tr>
					<th>Expérience Reçu</th>
					<td>${quete.difficulte}</td>
					</tr>
					<tr>
					<th>Récompenses</th>
					<td><c:forEach items="${quete.recompenses}" var="recompense"><p>${recompense.nom}</p></c:forEach></td>
					</tr>
					<tr>
					<th>Etat des aventuriers</th>
					<td>Prêts pour une autre mission</td>
					</tr>
					
					</c:if>
					<c:if test='${(quete.etat).equals("inachevee")}'>
					<tr>
					<th>Résultat</th>
					<td>Echec</td>
					</tr>
					<tr>
					<th>Expérience Reçu</th>
					<td>0 XP</td>
					</tr>
					<tr>
					<th>Récompenses</th>
					<td>Aucune</td>
					</tr>
					<tr>
					<th>Etat des aventuriers</th>
					<td>Necessitent des soins</td>
					</tr>
					</c:if>
					
			</thead>
			</table>
			</section>

</body>
</html>