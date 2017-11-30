<%-- 
    Document   : VideoLista
    Created on : 30/11/2017, 02:43:20 AM
    Author     : Juan Albarracin
--%>

<%@page import="Dato.Video"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viddeos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
        <link rel="stylesheet" href="ui/Css/MenuDesplegableSub.css">
        <link rel="stylesheet" href="ui/Css/Etilo Fomulario.css">
    </head>

    <body>
        <div id="Centrar">
            <div id="Telon" align="center">
                <div class="Menu">
                    <header class="Menu_Des">
                        <input type="checkbox" id="btn_Menu">
                        <label for="btn_Menu"> <img class="icon"  src="ui/Imagenes/menu-icon.png"></label>
                        <nav class="MenuCss">
                            <ul>
                                <li><a href="Videolista.jsp"><span class="uno"><img class="icon" src="ui/Imagenes/icon1.png" /></span>Inicio</a></li>
                                <li><a href="Videolista.jsp"><span class="dos"><img class="icon" src="ui/Imagenes/Esquema.png" /> </span>series</a></li>
                                <li><a href="Videolista.jsp"><span class="tres"><img class="icon" src="ui/Imagenes/Database-Table-icon.png" /> </span>peliculas</a></li>
                                <li><a href="Videolista.jsp"><span class="cuatro"><img class="icon" src="ui/Imagenes/Columna.png" /> </span>documentales</a></li>
                            </ul>
                        </nav>
                    </header>                
                </div>


                <div class="form-style-5">
                    <a href="Controllervideo?action=insert"><input type="submit" value="Add Video"/></a>
                    <table border=1>
                        <thead>
                            <tr>
                                <th>Video Id</th>
                                <th>titulo</th>
                                <th>director</th>
                                <th>creacion</th>
                                <th>genero</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Video> videos = (List<Video>) request.getAttribute("videos");
                                if (videos != null) {
                                    for (Video video : videos) {
                            %>
                            <tr>
                                <td><%=video.getIdvideo()%></td>
                                <td><%=video.getTitulo()%></td>
                                <td><%=video.getDirector()%></td>
                                <td><%=video.getCreacion()%></td>
                                <td><%=video.getGenero()%></td>
                                <td><a href="Controllervideo?action=edit&videoid=<%=video.getIdvideo()%>">Actualizar</a></td>
                                <td><a href="Controllervideo?action=delete&videoid=<%=video.getIdvideo()%>">Eliminar</a></td>
                            </tr>

                            <%
                                    }

                                }

                            %>

                        </tbody>
                    </table>
                    
                </div>

            </div>
        </div>

    </body>
</html>
