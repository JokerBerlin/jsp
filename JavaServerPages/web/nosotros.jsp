<%-- 
    Document   : nosotros
    Created on : 29-jul-2018, 14:32:53
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
        
        <jsp:include page="WEB-INF/partials-dinamic/menu-navegacion.jsp" >
            <jsp:param name="pagina" value="nosotros"/>
        </jsp:include>
 

        <h1>Página donde explicamos quienes somos</h1>
        <%@include file="WEB-INF/partials-static/footer.html" %>
    </body>
</html>
