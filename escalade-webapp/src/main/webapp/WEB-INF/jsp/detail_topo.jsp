<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<%@include file="include/menu.jsp"%>

    <h3>Topo: ${topo.nom}</h3>
    <h4>Description: ${topo.description}</h4>

    <h3>Listes des sites :</h3>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Département</th>
            <th>Ville</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${topo.listSite}" var="site">
            <tr>
                <td>${site.nom}</td>
                <td>${site.departement}</td>
                <td>${site.ville}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>
