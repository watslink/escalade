<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>
<%@include file="../include/menu.jsp" %>
<h1> Mes emprunts:</h1>
<div class="container">
    <table class="table table-striped sortTable">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Propriétaire</th>
            <th>Date retour</th>
            <th class="nosort">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${utilisateurConnecte.listToposEmprunter}" var="topoAPreter">
            <tr>
                <td>${topoAPreter.topoReference.nom}</td>
                <td>
                    <a href="mailto:${topoAPreter.utilisateurProprietaire.mail}">${topoAPreter.utilisateurProprietaire.pseudo}</a>
                </td>
                <td><fmt:formatDate value="${topoAPreter.date_retour}" pattern="dd/MM/yyyy"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/liste_sites_par_topo?topo_id=${topoAPreter.topoReference.topo_id}"
                       class="btn btn-primary">Détails</a>
                    <a href="${pageContext.request.contextPath}/removeFromMy_emprunts?topoAPreter_id=${topoAPreter.utilisateur_topos_id}"
                       class="btn btn-danger">Rendre</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
