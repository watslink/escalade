<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Liste des secteurs du site: ${site.nom} </h1>
<div class="container">

    <c:forEach items="${site.listSecteur}" var="secteur">

        <h3>Secteur : ${secteur.nom}</h3>

        <table  id="table" class="table table-striped ">
            <thead>
            <tr >
                <th>Voie</th>
                <th>Détails</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${secteur.listVoie}" var="voie">
                <tr >
                    <td class=> ${voie.nom}</td>
                    <td class=><a href="${pageContext.request.contextPath}/details_voie?voie_id=${voie.voie_id}"
                           class="btn btn-primary">Détails</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

    </c:forEach>


</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
