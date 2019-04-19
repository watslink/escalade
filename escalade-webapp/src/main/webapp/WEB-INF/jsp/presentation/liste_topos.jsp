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
    <div class="text-center">
        <button data-toggle="modal" href="#ajouter" class="btn btn-success">Ajouter un topo</button>
    </div>
    <div class="modal" id="ajouter">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4 class="modal-title">Ajouter un topo</h4>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal text-center" action="ajouter_topo" method="post" modelAttribute="topo" >
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nom">Nom</label>
                                <div class="col-md-4">
                                    <form:input id="nom" path="nom" type="text" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="description">Description</label>
                                <div class="col-md-4">
                                    <form:input id="description" path="description" type="text" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-success mb-2">Ajouter</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-striped sortTable">
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
                    <c:if test="${ not empty topo.listTopoAPreter}">
                    <a href="${pageContext.request.contextPath}/emprunter_topo?topo_id=${topo.topo_id}"
                       class="btn btn-warning">Emprunter</a>
                    </c:if>
                    <a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_topo?topo_id=${topo.topo_id}"
                    ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
