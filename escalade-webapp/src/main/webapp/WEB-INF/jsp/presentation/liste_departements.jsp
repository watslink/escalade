<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>

<h1> Départements:</h1>
<div class="container">
    <table id="table" class="table  table-striped sortTable">
        <thead>
        <tr>
            <th>N°</th>
            <th>Departement</th>
            <th class="nosort">Sites</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${liste_departements}" var="departement">
            <tr>
                <td>${departement.code}</td>
                <td>${departement.nom}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${departement.code}"
                       class="btn btn-primary">Détails</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
