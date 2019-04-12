<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>
<%@include file="../include/menu.jsp" %>
<h1> Mes Topos:</h1>
<div class="container">
    <h2>Bonjour ${utilisateurConnecte.pseudo}</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Propriétaire</th>
            <th>Date retour</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${utilisateurConnecte.listToposEmprunter}" var="topoAPreter">
            <tr>
                <td>${topoAPreter.topoReference.nom}</td>
                <td>${topoAPreter.utilisateurProprietaire.pseudo}</td>
                <td><fmt:formatDate value="${topoAPreter.date_retour}" pattern="dd/MM/yyyy"/> </td>
                <td>
                    <a href="${pageContext.request.contextPath}/liste_sites_par_topo?topo_id=${topoAPreter.topoReference.topo_id}"
                       class="btn btn-primary">Détails</a>
                </td>
                <td>
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
