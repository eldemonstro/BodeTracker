<%@page import="io.github.eldemonstro.bodetracker.bean.Bode"%>
<%@page import="io.github.eldemonstro.bodetracker.controller.BodeController"%>
<%@page import="io.github.eldemonstro.bodetracker.bean.Usuario"%>
<%@page import="io.github.eldemonstro.bodetracker.controller.UsuarioBodeController"%>
<%
    UsuarioBodeController usuBodeControl = new UsuarioBodeController();
    BodeController bodeControl = new BodeController();
    Usuario usu = (Usuario) session.getAttribute("usuario");
    Bode bode = new Bode();
    long id = Long.parseLong(request.getParameter("id"));
    bode.setId(id);
    bode = bodeControl.consultar(bode);
    usuBodeControl.inserir(usu, bode);
    String redirect = "listar.jsp";
    response.sendRedirect(redirect);
%>