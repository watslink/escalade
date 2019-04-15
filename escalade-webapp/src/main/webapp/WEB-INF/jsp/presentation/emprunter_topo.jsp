<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>

<div class="container">
    <h1> ${topo.nom} </h1>
    <h2> Utilisateurs propriétaires: </h2>
    <table id="table1" class="table table-striped">
        <thead>
        <tr>
            <th>Pseudo</th>
            <th>Emprunter</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${topo.listTopoAPreter}" var="topoAPreter">
            <c:if test="${!utilisateurConnecte.equals(topoAPreter.utilisateurProprietaire)}">
            <tr>
                <td>${topoAPreter.utilisateurProprietaire.pseudo}</td>
                <td>
                    <c:if test="${topoAPreter.disponible}">
                        <form:form action="addToMy_toposEmpruntes" method="post" class="form-inline">
                            <input type="hidden" id="topoAPreter_id" name="topoAPreter_id" value="${topoAPreter.utilisateur_topos_id}">
                            <div class="form-group">
                                <div class='input-group date datepicker'>
                                    <label>
                                        <input type='text' name="date" class="form-control" required>
                                    </label>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                     </span>
                                </div>
                            </div>
                            <input type="submit" value="Emprunter" class="btn btn-success btn-block">
                        </form:form>
                    </c:if>
                    <c:if test="${!topoAPreter.disponible}">
                        Indisponible, retour prévu le
                        <fmt:formatDate value="${topoAPreter.date_retour}" type="date" dateStyle="long"/>
                    </c:if>
                </td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>

    </table>


</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
