<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav role="navigation" class="navbar navbar-inverse">
    <div class="">
        <a href="" class="navbar-brand">EscaladeOC</a>
    </div>
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/">Accueil</a></li>
            <li><a href="${pageContext.request.contextPath}/liste_topos">Liste</a></li>
            <li><a href="${pageContext.request.contextPath}/logout"> <security:authentication property="principal.username" /> Logout</a></li>
        </ul>
    </div>
</nav>
