<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp"%>
<html>
<%@include file="include/head.jsp"%>
<body>
<%@include file="include/header.jsp"%>
<div class="container marginForm">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8  col-sm-offset-2 c" >
            <div class="panel panel-default">
                <div class="panel-heading">
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
             <c:if test="${param.inscrit != null}">
                <div class="alert alert-success">
                    Inscription réussie. Veuillez-vous identifiez.
                </div>
            </c:if>
                <h3 class="panel-title">Connection: </h3>
            </div>
            <div class="panel-body">
                <form:form  action="login" method="post" class="col-xs-12 col-sm-8  col-sm-offset-2"  >
                <div class="form-group">
                    <input type="text" name="username" id="username" class="form-control input-sm" placeholder="Pseudo"/>
                </div>
            <div class="form-group">
                <input type="password" id="password" name="password" placeholder="Mot de passe" class="form-control input-sm"/>
            </div>
            <input type="submit" value="Valider" class="btn btn-info btn-block">

            <div class="row">
                <div class="col-xs-9">
                    <label class="checkbox-inline">
                        <input type="checkbox">Se souvenir de moi
                    </label>
                </div>
                <div class="pull-right" style="padding-right: 15px">
                    <a  href="${pageContext.request.contextPath}/inscription">S'inscrire</a>
                </div>
            </div>
        </form:form>
            </div>
    </div>
</div>
</div>
</div>
</body>
</html>