<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>

<%@include file="../include/menu.jsp" %>
<h1> Sites du topo: ${topo.nom} </h1>
<div class="container">
    <div class="text-center">
        <button data-toggle="modal" href="#gererSites" class="btn btn-success">Gérer les Sites</button>
    </div>
    <div class="modal" id="gererSites">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4 class="modal-title">Mettre à jour les sites du topo: ${topo.nom}</h4>
                </div>
                <div class="modal-body">
                    <form:form class="form-horizontal text-center" action="update_sites_topo" method="post">
                        <fieldset>
                            <table id="tableSite" class="table table-condensed sortTable">
                                <thead>
                                <tr>
                                    <th>Nom</th>
                                    <th>Departement</th>
                                    <th>Ville</th>
                                    <th class="nosort">dans le topo?</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${listSites}" var="site">
                                    <tr>
                                        <td>${site.nom}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${site.departement.code}">
                                                    ${site.departement.nom}(${site.departement.code})
                                            </a>
                                        </td>
                                        <td>${site.ville.nom}</td>
                                        <c:if test="${topo.listSite.contains(site)}">
                                            <td><input type="checkbox" name="listSite_id" value="${site.site_id}" checked></td>
                                        </c:if>
                                        <c:if test="${!topo.listSite.contains(site)}">
                                            <td><input type="checkbox" name="listSite_id" value="${site.site_id}"></td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <input type="text" hidden id="topo_id" name="topo_id" value="${topo.topo_id}">
                            <button type="submit" class="btn btn-success mb-2">Mettre à jour</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <table id="table2" class="table table-striped sortTable">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Département</th>
            <th>Ville</th>
            <th class="nosort">Détails</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${topo.listSite}" var="site">
            <tr>
                <td>${site.nom}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/liste_sites_par_departement?code_departement=${site.departement.code}">
                    ${site.departement.nom}(${site.departement.code})
                    </a>
                </td>
                <td>${site.ville.nom}</td>
                <td><a href="${pageContext.request.contextPath}/liste_secteurs?site_id=${site.site_id}"
                       class="btn btn-primary">Détails</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>
