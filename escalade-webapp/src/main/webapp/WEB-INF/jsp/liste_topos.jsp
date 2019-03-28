<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<%@include file="include/menu.jsp"%>
<h1> Liste des topos existants:</h1>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${liste_topos}" var="topo">
            <tr>
                <td>${topo.nom}</td>
                <td>${topo.description}</td>
                <td><a href="${pageContext.request.contextPath}/detail_topo?topo_id=${topo.topo_id}" class="btn btn-primary">Détails</a> </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>
