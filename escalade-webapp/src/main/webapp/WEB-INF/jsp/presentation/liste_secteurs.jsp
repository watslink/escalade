<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Secteurs: </h1>
<h4> Département: <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${site.departement.code}"> ${site.departement.nom} ${site.departement.code}</a> /
 Site: <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"> ${site.nom} </a></h4>
<div class="container-fluid">
    <div class="text-center">
        <button data-toggle="modal" href="#ajouterSecteur" class="btn btn-success">Ajouter un secteur</button>
    </div>
    <div class="modal" id="ajouterSecteur">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4 class="modal-title">Ajouter un secteur</h4>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal text-center" action="ajouter_secteur" method="post" >
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nom">Nom</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control col-md-4" minlength="3" id="nom" name="nom"  required>
                                </div>
                            </div>
                        <input type="text" hidden id="site_id" name="site_id" value="${site.site_id}">
                        <button type="submit" class="btn btn-success mb-2">Ajouter</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <c:forEach items="${site.listSecteur}" var="secteur">
        <div class="secteur">
        <h3>Secteur : ${secteur.nom} <a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_secteur?secteur_id=${secteur.secteur_id}"
        ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a></h3>
        <table  id="table" class="table table-striped ">
            <thead>
            <tr class="row">
                <th class="col-xs-8">Voie</th>
                <th class="col-xs-4">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${secteur.listVoie}" var="voie">
                <tr class="row" >
                    <td class="col-xs-8"> ${voie.nom}</td>
                    <td class="col-xs-4"><a href="${pageContext.request.contextPath}/details_voie?voie_id=${voie.voie_id}"
                           class="btn btn-primary">Détails</a>
                        <a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_voie?voie_id=${voie.voie_id}"
                        ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <div class="text-center">
                <button data-toggle="modal" href="#ajouterVoie" class="btn btn-success">Ajouter une voie</button>
            </div>
            <div class="modal" id="ajouterVoie">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">x</button>
                            <h4 class="modal-title">Ajouter une voie</h4>
                        </div>
                        <div class="modal-body">

                            <form:form class="form-horizontal text-center" action="ajouter_voie" method="post" >
                            <fieldset>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="nomVoie">Nom</label>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control col-md-4" minlength="3" id="nomVoie" name="nomVoie"  required>
                                    </div>
                                </div>
                                <input type="text" hidden id="secteur_id" name="secteur_id" value="${secteur.secteur_id}">
                                <button type="submit" class="btn btn-success mb-2">Ajouter</button>
                            </fieldset>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
