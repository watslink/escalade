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
        <tr class="row">
            <th class="col-xs-3">Nom</th>
            <th class="col-xs-5">Description</th>
            <th class="nosort col-xs-4">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${liste_topos}" var="topo">
            <tr class="row">
                <td class="col-xs-3">${topo.nom}</td>
                <td class="col-xs-5">${topo.description}</td>
                <td class="col-xs-4">
                    <a href="${pageContext.request.contextPath}/liste_sites_par_topo?topo_id=${topo.topo_id}"
                       class="btn btn-primary">Détails</a>
                    <a href="${pageContext.request.contextPath}/addToMy_topos?topo_id=${topo.topo_id}" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Mes topos</a>
                    <a href="${pageContext.request.contextPath}/emprunter_topo?topo_id=${topo.topo_id}"
                       class="btn btn-warning">Emprunter</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
