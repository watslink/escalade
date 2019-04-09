<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="include/taglibs.jsp" %>
<html>
<%@include file="include/head.jsp" %>
<body>
<%@include file="include/header.jsp" %>

<%@include file="include/menu.jsp" %>
<h1> Voie: ${voie.nom} </h1>
<div class="container-fluid">

    <c:forEach items="${voie.listLongueur}" var="longueur">


        <table  id="table" class="table table-striped ">
            <thead>
            <tr class="row">
                <th class="col-xs-6">Voie</th>
                <th class="col-xs-3">Détails</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${secteur.listVoie}" var="voie">
                <tr class="row">
                    <td class="col-xs-6"> ${voie.nom}</td>
                    <td class="col-xs-3"><a href="${pageContext.request.contextPath}/details_voie?voie_id=${voie.voie_id}"
                                            class="btn btn-primary">Détails</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

    </c:forEach>


</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
