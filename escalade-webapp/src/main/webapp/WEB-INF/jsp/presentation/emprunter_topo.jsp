<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>

<div class="container-fluid">
    <h1> Topo: ${topo.nom} </h1>
    <h4> Utilisateurs propriétaires: </h4>
    <table id="table1" class="table table-striped sortTable">
        <thead>
        <tr class="row">
            <th class="col-xs-5">Pseudo</th>
            <th class="nosort col-xs-7">Emprunter</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${topo.listTopoAPreter}" var="topoAPreter">
            <c:if test="${utilisateurConnecte.equals(topoAPreter.utilisateurProprietaire)}">
                <h4> Je posséde ce topo</h4>
            </c:if>
            <c:if test="${!utilisateurConnecte.equals(topoAPreter.utilisateurProprietaire)}">
            <tr class="row">
                <td class="col-xs-5"><a href="mailto:${topoAPreter.utilisateurProprietaire.mail}">${topoAPreter.utilisateurProprietaire.pseudo}</a></td>
                <td class="col-xs-7">
                    <c:if test="${topoAPreter.disponible}">
                        <form:form action="addToMy_toposEmpruntes" method="post" class="form-inline">
                            <input type="hidden" id="topoAPreter_id" name="topoAPreter_id" value="${topoAPreter.utilisateur_topos_id}">
                            <div class="form-group col-xs-8">
                                <div class="form-group">
                                    <div class='input-group date datepicker' >
                                        <input type='text' class="form-control" required/>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                         </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-4 paddingleft">
                            <input type="submit" value="Emprunter" class="btn btn-success ">
                            </div>
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
