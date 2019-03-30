<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<div class="container">
<h2>Connection</h2>
<form class="form-group" action="login" method="post">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Pseudo ou mot de passe invalide</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            Vous êtes deconnecté.
        </div>
    </c:if>
    <p>
        <label for="username">Pseudo</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password"/>
    </p>

    <button type="submit" class="btn btn-primary">Valider</button>
</form>
</div>
</body>
</html>