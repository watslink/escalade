<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="include/taglibs.jsp" %>
<html>
<%@include file="include/head.jsp" %>
<body>
<%@include file="include/header.jsp" %>

<%@include file="include/menu.jsp" %>
<div class="container">
    <h2 class="accueil">Bonjour ${utilisateurConnecte.pseudo}</h2>
    <p class="accueil"><strong>Bienvenue sur Escalade OC</strong>, consultez les meilleurs sites de grimpe, proposer vos
        topos ou empruntez-en! </p>

    <div class="media col-lg-12 text-center">
            <iframe width="420" height="320" src="https://www.youtube.com/embed/Fb22k-B08R4" frameborder="0" allowfullscreen></iframe>
    </div>
    <c:if test="${not empty listToposARendre}">
        <h2 class="accueil">
            A rendre rapidement:
        </h2>
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Propriétaire</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${listToposARendre}" var="topoAPreter">
                <tr>
                    <td>${topoAPreter.topoReference.nom}</td>
                    <td><a href="mailto:${topoAPreter.utilisateurProprietaire.mail}">${topoAPreter.utilisateurProprietaire.pseudo}</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </c:if>
</div>


<%@include file="include/footer.jsp" %>
</body>
</html>
