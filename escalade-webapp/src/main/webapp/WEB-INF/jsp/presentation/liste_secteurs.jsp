<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Secteurs: </h1>
<h4> Département: <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${site.departement.code}"> ${site.departement.nom} ${site.departement.code}</a> /
 Site: <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"> ${site.nom} </a></h4>
<div class="container-fluid">
    <form:form class="form-inline text-center" action="ajouter_secteur" method="post" >
        <label>Ajouter un secteur:</label>
        <div class="form-group ">
            <input type="text" class="form-control" minlength="3" id="nom" name="nom" placeholder="Nom" required>
        </div>
        <input type="text" hidden id="site_id" name="site_id" value="${site.site_id}">
        <button type="submit" class="btn btn-success mb-2">Ajouter</button>
    </form:form>
    <c:forEach items="${site.listSecteur}" var="secteur">
        <h3>Secteur : ${secteur.nom} <a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_secteur?secteur_id=${secteur.secteur_id}"
        ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a></h3>
        <table  id="table" class="table table-striped ">
            <thead>
            <tr >
                <th>Voie</th>
                <th>Détails</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${secteur.listVoie}" var="voie">
                <tr >
                    <td class=> ${voie.nom}</td>
                    <td class=><a href="${pageContext.request.contextPath}/details_voie?voie_id=${voie.voie_id}"
                           class="btn btn-primary">Détails</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
