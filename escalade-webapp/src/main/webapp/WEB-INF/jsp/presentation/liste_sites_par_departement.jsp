<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>
<%@include file="../include/menu.jsp" %>
<h1> Sites: </h1>
<h4> Département: <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${departement.code}"> ${departement.nom} ${departement.code}</a></h4>
<div class="container">
    <div class="text-center">
        <button data-toggle="modal" href="#ajouter" class="btn btn-success">Ajouter un Site</button>
    </div>
    <div class="modal" id="ajouter">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4 class="modal-title">Ajouter un site</h4>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal text-center" action="ajouter_site" method="post" >
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nom">Nom</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" minlength="3" id="nom" name="nom" required>
                                </div>
                            </div>
                            <div  class="form-group ">
                                <label class="col-md-4 control-label" for="ville">Ville</label>
                                <div class="col-md-4 ">
                                    <select name="ville_id" id="ville" class="form-control" required>
                                        <c:forEach items="${departement.listVille}" var="ville">
                                            <option value="${ville.ville_id}">
                                                    ${ville.nom}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        <input type="text" hidden id="departement_code" name="departement_code" value="${departement.code}">
                        <button type="submit" class="btn btn-success mb-2">Ajouter</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

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
                <td class="col-xs-4">${site.ville.nom}</td>
                <td class="col-xs-3"><a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"
                       class="btn btn-primary">Détails</a>
                    <a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_site?site_id=${site.site_id}"
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
