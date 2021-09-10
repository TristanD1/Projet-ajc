<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>ADMIN - Création / Modification des compétences</title>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="assets/css/competenceStyle.css">

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
                    crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

            </head>

            <body>
                <header>
                    <h1>Compétences</h1>
                </header>

                <t:layout argent="${argent}"></t:layout>

                <form method="POST">
                    <h2>Ajouter une compétence</h2>

                    <div class="row">
                        <div class="col-2 col-form-label">
                            <label for="nom" class="form-label">Nom :</label>
                        </div>

                        <div class="col-10">
                            <input class="form-control" type="text" id="nom" name="nom" value="${ competence.nom }" />
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-2 col-form-label">
                            <label for="experience" class="form-label">Bonus :</label>
                        </div>

                        <div class="col-10">
                            <input class="form-control" type="text" id="bonus" name="bonus"
                                value="${ competence.bonus }" />
                        </div>
                    </div>

                    <div class="row">
                        <c:if test="${ competence == null }">
                            <input type="submit" class="btn btn-success" value="Ajouter" />
                        </c:if>

                        <c:if test="${ competence != null }">
                            <input type="submit" class="btn btn-warning" value="Modifier" />
                        </c:if>
                    </div>
                </form>

                <section>
                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Bonus</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ competences }" var="competence">
                                <tr>
                                    <td>${ competence.nom }</td>
                                    <td>${ competence.bonus }</td>
                                    <td><a href="modifier-competence?id=${ competence.id }"
                                            class="btn btn-warning">Modifier</a> <a
                                            href="supprimer-competence?id=${ competence.id }"
                                            class="btn btn-danger">Supprimer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </body>

            </html>