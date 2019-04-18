<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Longueurs de la voie: ${voie.nom} </h1>
<h4> Département: <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${voie.secteur.site.departement.code}"> ${voie.secteur.site.departement.nom} ${voie.secteur.site.departement.code}</a> /
    Site: <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${voie.secteur.site.site_id}"> ${voie.secteur.site.nom}</a> /
 Secteur: ${voie.secteur.nom}</h4>
<div class="container-fluid">
        <table  id="table" class="table table-striped sortTable">
            <thead>
            <tr class="row">
                <th >Numéro</th>
                <th >Description</th>
                <th >Hauteur</th>
                <th >Cotation</th>
                <th >Points</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${voie.listLongueur}" var="longueur">
                <tr class="row">
                    <td > ${longueur.numero}</td>
                    <td > ${longueur.description}</td>
                    <td > ${longueur.hauteur}</td>
                    <td > ${longueur.cotation}</td>
                    <td > ${longueur.nombre_points}</td>
                    <td><a data-confirm="Confirmer la suppression?" href="${pageContext.request.contextPath}/supprimer_longueur?longueur_id=${longueur.longueur_id}"
                    ><i class="fa fa-trash fa-adjust" aria-hidden="true"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <div class="text-center">
        <button data-toggle="modal" href="#ajouter" class="btn btn-success">Ajouter une longueur</button>
    </div>
    <div class="modal" id="ajouter">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4 class="modal-title">Ajouter une longueur</h4>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal text-center" action="ajouter_longueur" method="post" modelAttribute="longueur" >
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="numero">Numéro</label>
                                <div class="col-md-4">
                                    <form:input id="numero" path="numero" type="number" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="description">Description</label>
                                <div class="col-md-4">
                                    <form:input id="description" path="description" type="text" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="cotation">Cotation</label>
                                <div class="col-md-4">
                                    <form:select path="cotation" required="true">
                                        <form:option value="" label="*** Cotation ***" />
                                        <form:options items="${listCotation}" />
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="hauteur">Hauteur (m)</label>
                                <div class="col-md-4">
                                    <form:input id="hauteur" path="hauteur" type="number" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nombre_points">Nombre de points</label>
                                <div class="col-md-4">
                                    <form:input id="nombre_points" path="nombre_points" type="number" placeholder="" class="form-control input-md" required="true"/>
                                </div>
                            </div>
                            <input type="text" hidden id="secteur_id" name="voie_id" value="${voie.voie_id}">
                            <button type="submit" class="btn btn-success mb-2">Ajouter</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>



    <div class="commentaire">
    <h4>Commentaires</h4>
    <table  id="tableCommentaires" class="table table-striped ">
        <thead>
        <tr class="row">
            <th>Date</th>
            <th>Pseudo</th>
            <th>Commentaire</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${voie.listCommentaire}" var="commentaire">
            <tr class="row">
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${commentaire.date}"/></td>
                <td> ${commentaire.utilisateur.pseudo}</td>
                <td> ${commentaire.texte}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row col-xs-offset-2 col-xs-8">
        <form:form action="details_voie" method="post" modelAttribute="commentaire">
            <div class="lg-form amber-textarea active-amber-textarea">
                <textarea id="formComm" name="commentaire" class="md-textarea form-control" rows="3" placeholder="commenter..."></textarea>
            </div>
            <input name="voie_id" type="hidden" value="${voie.voie_id}"/>
            <input type="submit" value="Valider" class="btn btn-info btn-block ">
        </form:form>
    </div>
    </div>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
