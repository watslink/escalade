<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<h1> Mes Topos:</h1>
<div class="container">
    <h2>Bonjour ${utilisateurConnecte.pseudo}</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${utilisateurConnecte.listToposEmprunter}" var="topoAPreter">
            <tr>
                <td>${topoAPreter.topoReference.nom}</td>
                <td>${topoAPreter.topoReference.description}</td>
                <td><a href="${pageContext.request.contextPath}/detail_topo?topo_id=${topoAPreter.topoReference.topo_id}" class="btn btn-primary">Détails</a> </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="include/footer.jsp"%>
</body>
</html>
