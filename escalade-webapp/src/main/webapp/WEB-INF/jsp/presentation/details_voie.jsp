<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Voie: ${voie.nom} </h1>
<h4> Département: <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${voie.secteur.site.departement.code}"> ${voie.secteur.site.departement.nom} ${voie.secteur.site.departement.code}</a> /
    Site: <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${voie.secteur.site.site_id}"> ${voie.secteur.site.nom} </a></h4>
<div class="container-fluid">
        <table  id="table" class="table table-striped sortTable">
            <thead>
            <tr class="row">
                <th >Numéro</th>
                <th >Description</th>
                <th >Hauteur</th>
                <th >Cotation</th>
                <th >Points</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${voie.listLongueur}" var="longueur">
                <tr class="row">
                    <td > ${longueur.numero}</td>
                    <td > ${longueur.description}</td>
                    <td > ${longueur.hauteur}</td>
                    <td > ${longueur.cotation}</td>
                    <td > ${longueur.nombre_points}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <div class="commentaire">
    <h4>Commentaires</h4>
    <table  id="tableCommentaires" class="table table-striped ">
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
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${commentaire.date}"/></td>
                <td> ${commentaire.utilisateur.pseudo}</td>
                <td> ${commentaire.texte}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row col-xs-offset-2 col-xs-8">
        <form:form action="details_voie" method="post" modelAttribute="commentaire">
            <div class="lg-form amber-textarea active-amber-textarea">
                <textarea id="formComm" name="commentaire" class="md-textarea form-control" rows="3" placeholder="commenter..."></textarea>
            </div>
            <input name="voie_id" type="hidden" value="${voie.voie_id}"/>
            <input type="submit" value="Valider" class="btn btn-info btn-block ">
        </form:form>
    </div>
    </div>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
