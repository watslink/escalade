<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Liste des sites </h1>
<div class="container">
    <h1> ${topo.nom} </h1>

    <h2> Liste des sites </h2>
    <table id="table2" class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Ville</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${topo.listSite}" var="site">
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
<%@include file="../include/footer.jsp" %>
</body>
</html>
