<%-- 
    Document   : InsertarDeseos
    Created on : 20/11/2017, 08:02:45 PM
    Author     : Alejandro
--%>

<%@page import="VO.Libro"%>
<%@page import="VO.Empleado"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>DESEOS</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
        <meta name="description" content="Your description">
        <meta name="keywords" content="Your keywords">
        <meta name="author" content="Your name">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/preview.css" type="text/css">
        <script type="text/javascript" src="js/include_script.js"></script>
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <link href="css/ie.css" rel="stylesheet" type="text/css">
    <![endif]-->
    </head>
    <body>
        <!--content wrapper-->
        <div id="wrapper">
            <section>
                <div class="container">
                    <div class="dynamicContent">
                        <!--content-->

                        <h1>Realizar Deseos</h1>
                        <%
                            if (request.getAttribute("resultado") != null) {
                                Boolean resultado = (Boolean) request.getAttribute("resultado");
                                if (resultado.booleanValue() == true) {
                        %>
                        <h2> se ha registrado de manera exitosa</h2>
                        <%
                        } else {
                        %>     
                        <h2> llene los campos correctamente </h2>
                        <%
                                }
                            }
                        %>


                        <p>Ingrese la informacion solicitada</p>

                        <form action=" CrearDeseos" method="post">
                            <div class="form_settings">
                                <p><span>Numero De Registro</span>
                                    <input class="contact" type="text" name="id_deseo" value="" /></p>
                                <p><span>Nombre Libro</span>
                                    <select class="contact" name="nombre_libro" >
                                        <%                            //Si la variable que me deben enviar existe  
                                            if (request.getAttribute("lis") != null) {
                                                //Capturando informacion variable que me estan enviado.    
                                                ArrayList<Libro> esquemas = (ArrayList<Libro>) request.getAttribute("lis");
                                                //Existan activos
                                                if (esquemas != null) {
                                                    for (Libro li : esquemas) {
                                        %>
                                        <option value="<%=li.getNombre()%>"><%=li.getNombre()%>

                                        </option>
                                        <%
                                            }
                                        } else {
                                        %>
                                        <h1>inserte un deseo</h1>
                                        <%
                                                }
                                            }

                                        %>

                                    </select>
                                </p>
                                <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="submit" /></p>
                            </div>
                          



                        </form>
                                          <h2><a href="index.jsp"> volver al menu</a></h2>
                            <h2><a href="verDeseos"> deseos totales</a></h2>

                    </div>
                </div>
            </section>
        </div>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script>
            $(".fancybox").fancybox({});
        </script>
    </body>
</html>