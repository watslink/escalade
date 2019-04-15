<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav role="navigation" class="navbar">
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">

            <li> <a href="${pageContext.request.contextPath}/">Accueil</a></li>
            <li class="dropdown">
                <a data-toggle="dropdown" href="#">Rechercher un site<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/liste_departements">Liste par département</a></li>
                    <li><a href="${pageContext.request.contextPath}/recherche_multi">Recherche par critères</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a data-toggle="dropdown" href="#">Topos<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/liste_topos">Liste des topos</a></li>
                    <li><a href="${pageContext.request.contextPath}/mes_topos">Mes Topos</a></li>
                    <li><a href="${pageContext.request.contextPath}/mes_emprunts">Mes Emprunts</a></li>
                </ul>
            </li>
        </ul>
        <form  class="navbar-form navbar-right inline-form">
            <span class="glyphicon glyphicon-user"> <security:authentication property="principal.username" /> </span>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger"><span class="glyphicon glyphicon-off"></span> Déconnexion </a>
        </form>
    </div>
</nav>

