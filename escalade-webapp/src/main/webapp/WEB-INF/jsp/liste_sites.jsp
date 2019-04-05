<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<%@include file="include/header.jsp"%>

<%@include file="include/menu.jsp"%>

<h1> Liste des sites existants:</h1>
<div class="container">
    <table id="table" class="table sortable table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Departement</th>
            <th>Ville</th>
            <th>Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${liste_sites}" var="site">
            <tr>
                <td>${site.nom}</td>
                <td>${site.departement}</td>
                <td>${site.ville}</td>
                <td><a href="${pageContext.request.contextPath}/detail_site?site_id=${site.site_id}" class="btn btn-primary">Détails</a> </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="include/footer.jsp"%>
</body>
</html>
