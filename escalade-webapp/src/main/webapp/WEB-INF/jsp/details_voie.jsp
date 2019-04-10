<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="include/taglibs.jsp" %>
<html>
<%@include file="include/head.jsp" %>
<body>
<%@include file="include/header.jsp" %>

<%@include file="include/menu.jsp" %>
<h1> Voie: ${voie.nom} </h1>
<div class="container-fluid">




        <table  id="table" class="table table-striped ">
            <thead>
            <tr class="row">
                <th >Numéro</th>
                <th >Description</th>
                <th >Cotation</th>
                <th >Points</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${voie.listLongueur}" var="longueur">
                <tr class="row">
                    <td > ${longueur.numero}</td>
                    <td > ${longueur.description}</td>
                    <td > ${longueur.cotation}</td>
                    <td > ${longueur.nombre_points}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

    <table  id="table" class="table table-striped ">
        <thead>
        <tr class="row">
            <th>Date</th>
            <th>Pseudo</th>
            <th>Commentaire</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${voie.listCommentaire}" var="commentaire">
            <tr class="row">
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${commentaire.date}"/></td>
                <td> ${commentaire.utilisateur.pseudo}</td>
                <td> ${commentaire.texte}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
<form:form action="details_voie" method="post" modelAttribute="commentaire">

    <label>
        <form:textarea path="texte"  id="texte" placeholder="Commenter..." class="form-control" rows="3"/>
    </label>
    <input name="voie_id" type="hidden" value="${voie.voie_id}"/>
    <input type="submit" value="Valider" class="btn btn-info btn-block">
</form:form>



</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
