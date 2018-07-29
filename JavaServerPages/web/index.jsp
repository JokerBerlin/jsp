<%-- 
    Document   : index
    Created on : 29-jul-2018, 14:27:19
    Author     : Canchito
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>JSP Page</title>
        <style>
            nav{
                background-color: #333;
            }
            nav ul li {
                display: inline-block;
            }
            
            nav ul li a {
                color: #eee;
                text-decoration: none;
            }
            .seleccionado {
                background-color: white;
                color: black;
            }
        </style>
    </head>
    <body>
        <!-- jsp:include sirve para incluir paginas dinamicas (jsp) a las cuales
        les podemos enviar parámetros para su proceso-->
        <jsp:include page="WEB-INF/partials-dinamic/menu-navegacion.jsp" >
            <jsp:param name="pagina" value="inicio"/>
        </jsp:include>
        <h1>Hello World!</h1>
        <!-- @include sirve para incluir paginas estaticas: html puro -->
        <%@include file="WEB-INF/partials-static/footer.jsp" %>
        <div> Los snippet comienzan con &lt;% </div>
        <p>
            
        <%
            int a = 5, b=4, c;
            c=a+b;
            out.print("El resultado es: "+c);
        %>
        </p>
        <div>LLas expresiones comienzan con &lt;%=</div>
        <div><%= c %></div>
    </body>
</html>
