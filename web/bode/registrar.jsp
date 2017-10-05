<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="io.github.eldemonstro.bodetracker.bean.Usuario"%>
<%
    Usuario usu = (Usuario) session.getAttribute("usuario");
    if (usu == null) {
        response.sendRedirect("../index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar - Bode Tracker</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Bode Tracker</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav navbar-nav">
                        <li><a class="nav-link" href="${pageContext.request.contextPath}/usuario/editar.jsp">Editar</a></li>
                        <li><a class="nav-link" href="${pageContext.request.contextPath}/bode/registrar.jsp">Registrar Bode</a></li>
                        <li><a class="nav-link" href="${pageContext.request.contextPath}/usuario/sair.jsp">Sair</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <br>
        <div class="container">
            <h1>Registrar:</h1>
            <form action="incluir.jsp" method="POST">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input required type="input" class="form-control" id="nome" name="nome" placeholder="Nome">
                </div>
                <div class="form-group">
                    <label for="nome">Registro:</label>
                    <input required type="input" class="form-control" id="registro" name="registro" placeholder="Registro">
                </div>
                <div class="form-group">
                    <label for="nome">Sexo:</label>
                    <input required type="input" class="form-control" id="sexo"  name="sexo" placeholder="Sexo">
                </div>
                <div class="form-group">
                    <label for="nome">Raça:</label>
                    <input required type="input" class="form-control" id="raca"  name="raca" placeholder="Raça">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
        </script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js">
        </script>
    </body>
</html>
