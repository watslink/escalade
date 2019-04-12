<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Recherche avancée </h1>
<div class="container-fluid">
    <div >
        <form:form action="recherche_multi" method="post" >
            <div class="form-group">
                <input type="text"  name="cotation" id="cotation" class="form-control input-sm"
                       placeholder="Cotation"/>
            </div>
            Nombre de points:
            <b>0  </b>
            <input id="nombre_points" name="nombre_points" type="text" class=" slider span2" value="" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-value="[0,50]"/>
            <b> 50</b>
            Hauteur (m):
            <b>0  </b>
            <input id="hauteur" name="hauteur" type="text" class="slider span2" value="" data-slider-min="0" data-slider-max="150" data-slider-step="1" data-slider-value="[0,150]"/>
            <b>  150</b>

            <div class="form-group">
                <input type="text" name="code_departement" id="code_departement" class="form-control input-sm"
                       placeholder="Departement"/>
            </div>
            <div class="form-group">
                <input type="text" name="ville" id="ville" class="form-control input-sm"
                       placeholder="Ville"/>
            </div>




            <input type="submit" value="Valider" class="btn btn-info btn-block">


        </form:form>
    </div>


<c:if test="${not empty longueurList}">
    <table  id="table" class="table table-striped ">
        <thead>
        <tr class="row">
            <th >Departement</th>
            <th >Ville</th>
            <th >Voie</th>
            <th >Numéro</th>
            <th >Description</th>
            <th >Cotation</th>
            <th >Points</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${longueurList}" var="longueur">
            <tr class="row">
                <td > ${longueur.voie.secteur.site.departement.nom}</td>
                <td > ${longueur.voie.secteur.site.ville}</td>
                <td > ${longueur.voie.nom}</td>
                <td > ${longueur.numero}</td>
                <td > ${longueur.description}</td>
                <td > ${longueur.cotation}</td>
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
