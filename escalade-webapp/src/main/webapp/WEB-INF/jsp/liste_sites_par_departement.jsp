<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="include/taglibs.jsp" %>
<html>
<%@include file="include/head.jsp" %>
<body>
<%@include file="include/header.jsp" %>

<%@include file="include/menu.jsp" %>
<h1> Liste des sites du département: ${departement.nom} ${departement.code}</h1>
<div class="container">
    <table id="table" class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Ville</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${departement.listSite}" var="site">
            <tr>
                <td>${site.nom}</td>
                <td>${site.ville}</td>
                <td><a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"
                       class="btn btn-primary">Détails</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
