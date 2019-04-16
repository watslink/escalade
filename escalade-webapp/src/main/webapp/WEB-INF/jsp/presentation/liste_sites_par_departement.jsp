<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>
<%@include file="../include/menu.jsp" %>
<h1> Liste des sites du département: ${departement.nom} ${departement.code}</h1>
<div class="container">
    <form:form class="form-inline text-center" action="ajouter_site" method="post" >
        <label>Ajouter un site:</label>
        <div class="form-group ">
            <input type="text" class="form-control" minlength="3" id="nom" name="nom" placeholder="Nom" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control"  id="ville" name="ville" placeholder="Ville" required>
        </div>
        <input type="text" hidden id="departement_code" name="departement_code" value="${departement.code}">
        <button type="submit" class="btn btn-success mb-2">Ajouter</button>
    </form:form>
    <table id="table" class="table table-striped sortTable">
        <thead>
        <tr>
            <th class="col-xs-5">Nom</th>
            <th class="col-xs-4">Ville</th>
            <th class="nosort col-xs-3">Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departement.listSite}" var="site">
            <tr>
                <td class="col-xs-5">${site.nom}</td>
                <td class="col-xs-4">${site.ville}</td>
                <td class="col-xs-3"><a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"
                       class="btn btn-primary">Détails</a>
                    <a href="#delete" data-toggle="modal"
                       ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a>

                </td>
            </tr>

            <div class="modal" id="delete">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">x</button>
                            <h4 class="modal-title">Suppression</h4>
                        </div>
                        <div class="modal-body">
                            Confirmer la suppression?
                        </div>
                        <div class="modal-footer">
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/supprimer_site?site_id=${site.site_id}"
                            >Supprimer</a>
                            <button class="btn btn-info" data-dismiss="modal">Annuler</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>



<%@include file="../include/footer.jsp" %>

</body>
</html>
