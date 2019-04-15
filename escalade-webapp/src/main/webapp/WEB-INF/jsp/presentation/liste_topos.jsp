<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>

<h1> Liste des topos existants:</h1>
<div class="container">
    <table class="table table-striped sorttable">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th class="nosort">Détails</th>
            <th class="nosort">Ajouter</th>
            <th class="nosort">Emprunter</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${liste_topos}" var="topo">
            <tr>
                <td>${topo.nom}</td>
                <td>${topo.description}</td>
                <td><a href="${pageContext.request.contextPath}/liste_sites_par_topo?topo_id=${topo.topo_id}"
                       class="btn btn-primary">Détails</a></td>
                <td><a href="${pageContext.request.contextPath}/addToMy_topos?topo_id=${topo.topo_id}"
                      class="btn btn-primary">Ajouter</a></td>
                <td><a href="${pageContext.request.contextPath}/emprunter_topo?topo_id=${topo.topo_id}"
                       class="btn btn-primary">Emprunter</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
