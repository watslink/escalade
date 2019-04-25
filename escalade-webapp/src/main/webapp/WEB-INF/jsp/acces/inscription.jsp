<%@include file="../include/taglibs.jsp" %>
<html>
<%@include file="../include/head.jsp" %>
<body>
<%@include file="../include/header.jsp" %>
<div class="container marginForm">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <c:if test="${param.errorPassword != null}">
                        <div class="alert alert-warning">
                            La confirmation du mot de passe n'est pas conforme
                        </div>
                    </c:if>
                    <c:if test="${param.errorPseudo != null}">
                        <div class="alert alert-warning">
                            Le pseudo est déja utilisé
                        </div>
                    </c:if>
                    <h3 class="panel-title">Inscription: </h3>
                </div>
                <div class="panel-body">
                    <form:form action="inscription" method="post" modelAttribute="utilisateur">
                        <div class="form-group">
                            <form:input type="text" minlength="3" path="pseudo" id="pseudo"
                                        class="form-control input-sm"
                                        placeholder="Pseudo" required="true"/>
                        </div>
                        <div class="form-group">
                            <form:input type="email" path="mail" id="mail" class="form-control input-sm"
                                        placeholder="Adresse Email" required="true"/>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <form:input type="password" minlength="6" path="mot_de_passe" id="password"
                                                class="form-control input-sm" placeholder="Mot de passe"
                                                required="true"/>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation"
                                           class="form-control input-sm" placeholder="Confirmer Mot de passe"
                                           required="true"/>
                                </div>
                            </div>
                        </div>

                        <input type="submit" value="Valider" class="btn btn-info btn-block">

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>