<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>R�sultat de la qu�te</title>
<meta name="description" content="R�sultat de la qu�te" />
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
<t:layout></t:layout>
<header>
<h1>R�sultat de la qu�te :</h1>
</header>

<section>
		<h2>D�tails</h2>

		<table class="table table-striped table-hover" id="tableauQuete">
			<thead>
				<tr>
					<th>Intitul� de la qu�te</th>
					<td>${quete.intitule}</td>
					</tr>
					<c:if test='${(quete.etat).equals("achevee")}'>
					<tr>
					<th>R�sultat</th>
					<td>Succ�s</td>
					</tr>
					<tr>
					<th>Exp�rience Re�u</th>
					<td>${quete.difficulte}</td>
					</tr>
					<tr>
					<th>R�compenses</th>
					<c:forEach items="${quete.recompenses}" var="recompense">
					<td>${recompense.nom}</td>
					</c:forEach>
					</tr>
					<tr>
					<th>Etat des aventuriers</th>
					<td>Pr�ts pour une autre mission</td>
					</tr>
					
					</c:if>
					<c:if test='${(quete.etat).equals("inachevee")}'>
					<tr>
					<th>R�sultat</th>
					<td>Echec</td>
					</tr>
					<tr>
					<th>Exp�rience Re�u</th>
					<td>0 XP</td>
					</tr>
					<tr>
					<th>R�compenses</th>
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