<%@page import="io.github.eldemonstro.bodetracker.bean.Usuario"%>
<%@page import="io.github.eldemonstro.bodetracker.controller.BodeController" %>
<%@page import="io.github.eldemonstro.bodetracker.bean.Bode" %>
<%
    String nome = request.getParameter("nome");
    String registro = request.getParameter("registro");
    String sexo = request.getParameter("sexo");
    String raca = request.getParameter("raca");
    String redirect = "registrar.jsp";
    Bode bode = new Bode();
    bode.setNome(nome);
    bode.setRegistro(registro);
    bode.setSexo(sexo);
    bode.setRaca(raca);
    
    Usuario usu = (Usuario) session.getAttribute("usuario");
    BodeController bodeControl = new BodeController();
    bodeControl.incluir(bode, usu);
    
    redirect = "../index.jsp";

    response.sendRedirect(redirect);
%>