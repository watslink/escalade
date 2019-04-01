<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<div class="container">

<form:form  action="login" method="post" class="well" >
    <legend>Connection:</legend>
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
    <div class="form-group">
        <label for="username">Pseudo</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <label class="checkbox-inline">
        <input type="checkbox">Se souvenir de moi
    </label>

    <button type="submit" class="btn btn-primary">Valider</button>
</form:form>
</div>
</body>
</html>