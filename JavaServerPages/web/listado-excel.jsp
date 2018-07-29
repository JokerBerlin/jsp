<%-- 
    Document   : listado
    Created on : 29-jul-2018, 16:03:19
    Author     : Canchito
--%>
<!-- generar excel -->
<% 
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=utf-8");
    response.setHeader("Content-Disposition", "attachment; filename=listado.xls");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de excel</h1>
        <table>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>pedro</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>yeni</td>
                    <td>13</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>fredi</td>
                    <td>30</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
