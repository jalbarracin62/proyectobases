/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoVideo;
import Dato.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario-Bx
 */
public class Controllervideo extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/videos.jsp";
    private static String LIST_USER = "/VideoLista.jsp";
    private DaoVideo dao;
    
    public Controllervideo() {
        super();
        dao = new DaoVideo();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            System.out.println("Entro a la accion");
            int videoId = Integer.parseInt(request.getParameter("videoid"));
            dao.deleteVideo(videoId);
            forward = LIST_USER;
            ///primero va la tabla de sql
            request.setAttribute("video", dao.getAllVideos());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int videoId = Integer.parseInt(request.getParameter("videoid"));
            Video video = dao.getvideoById(videoId);
            ///primero va la tabla de sql
            request.setAttribute("video", video);
            
            System.out.println(" Realizo la accion de editar");
        } else if (action.equalsIgnoreCase("VideoLista")){
            forward = LIST_USER;
            request.setAttribute("video", dao.getAllVideos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Video video = new Video();
       // squema.setNombre(request.getParameter("Name"));
        String videoid = request.getParameter("videoid");
        
        if(videoid == null || videoid.isEmpty()){
            dao.addVideo(video);
        }
        else{
            video.setIdvideo(Integer.parseInt(videoid));
            int videoId = Integer.parseInt(request.getParameter("videoid"));
            dao.updateVideo(video,videoId);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("video", dao.getAllVideos());
        view.forward(request, response);
    }
    
}
