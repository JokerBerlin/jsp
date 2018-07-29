<% 
    String pagina = request.getParameter("pagina");
%>

<nav>
    <ul>
        <li>
            <a href="/JavaServerPages/" class="<% out.print(pagina.equals("inicio")?"seleccionado":"");%>">Inicio</a>
        </li>
        <li>
            <a href="/JavaServerPages/nosotros.jsp" class="<% out.print(pagina.equals("nosotros")?"seleccionado":"");%>">Nosotros</a>
        </li>
        <li>
            <a href="/JavaServerPages/formulario.html">Nuevo</a>
        </li>
    </ul>
</nav>
<!--<p>El parámetro recibido es: <% out.print(pagina);%></p>-->
