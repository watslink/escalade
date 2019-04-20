<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Recherche avancée </h1>
<div class="container">
    <div >
        <form:form  action="recherche_multi" method="post" >
            <div class="form-group col-xs-12 col-md-4">
                <label class="col-xs-6 control-label" for="code_departement">Code du Departement</label>
                <div class="col-xs-6">
                    <input type="text" name="code_departement" id="code_departement" class="form-control "/>
                </div>
            </div>
            <div class="form-group col-xs-12 col-md-4">
                <label class="col-xs-6 col-md-4 control-label" for="ville">Ville</label>
                <div class="col-xs-6 col-md-8">
                    <input type="text" name="ville" id="ville" class="form-control"/>
                </div>
            </div>
            <div class="form-group col-xs-12 col-md-4">
                <label class="col-xs-6 control-label" for="cotation">Cotation</label>
                <div class="col-xs-6">
                    <input type="text"  name="cotation" id="cotation" class="form-control "/>
                </div>
            </div>
            <div class="form-group  col-xs-12" >
                <label class="col-xs-6 col-md-offset-2 col-md-4 control-label" for="nombre_points">Points (0-100)</label>
                <div >
                    <input id="nombre_points" name="nombre_points" type="text" class=" slider span " value="" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-value="[0,100]"/>
                </div>
            </div>
            <div class="form-group  col-xs-12">
                <label class="col-xs-6 col-md-offset-2 col-md-4 control-label" for="hauteur">Hauteur (0-150m)</label>
                <div >
                    <input id="hauteur" name="hauteur" type="text" class="slider span " value="" data-slider-min="0" data-slider-max="150" data-slider-step="1" data-slider-value="[0,150]"/>
                </div>
            </div>

            <input type="submit" value="Valider" class="btn btn-info btn-block">
        </form:form>
    </div>


<c:if test="${not empty longueurList}">
    <table  id="table" class="table table-striped sortTable ">
        <thead>
        <tr class="row">
            <th >Departement</th>
            <th >Ville</th>
            <th >Site</th>
            <th >Secteur</th>
            <th >Voie</th>
            <th >Longueur N°</th>
            <th >Cotation</th>
            <th >Hauteur (m)</th>
            <th >Points</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${longueurList}" var="longueur">
            <tr class="row">
                <td >
                    <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${longueur.voie.secteur.site.departement.code}">
                         ${longueur.voie.secteur.site.departement.nom}(${longueur.voie.secteur.site.departement.code})
                    </a>
                </td>
                <td > ${longueur.voie.secteur.site.ville}</td>
                <td >
                    <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${longueur.voie.secteur.site.site_id}" >
                        ${longueur.voie.secteur.site.nom}
                    </a>
                </td>
                <td >
                    <a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${longueur.voie.secteur.site.site_id}" >
                            ${longueur.voie.secteur.nom}
                    </a>
                </td>
                <td >
                    <a href="${pageContext.request.contextPath}/details_voie?voie_id=${longueur.voie.voie_id}" >
                            ${longueur.voie.nom}
                    </a>
                </td>
                <td > ${longueur.numero}</td>
                <td > ${longueur.cotation}</td>
                <td > ${longueur.hauteur}</td>
                <td > ${longueur.nombre_points}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</c:if>



</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript">
$(".slider").slider({});
</script>
</body>
</html>
