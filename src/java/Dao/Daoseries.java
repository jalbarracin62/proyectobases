/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dato.Video;
import Servicios.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario-Bx
 */
public class Daoseries  {

    private Connection connection;

    public Daoseries() {
        connection = DbUtil.getConnection();
    }

    public void addVideo(Video video) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into video(titulo,director,creacion,genero) values (?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, video.getTitulo());
             preparedStatement.setString(2, video.getDirector());
             preparedStatement.setInt(3, video.getCreacion());
             preparedStatement.setString(4, video.getGenero());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVideo(int videoid) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from video where idvideo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, videoid);
            preparedStatement.executeUpdate();
            System.out.println("Elimino El  video");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVideo(Video video,int cs ) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update video set titulo=? ,director=?,creacion=?  ,genero=?  where idvideo="+cs);
                            
            // Parameters start with 1
            preparedStatement.setString(1, video.getTitulo());
             preparedStatement.setString(2, video.getDirector());
             preparedStatement.setInt(3, video.getCreacion());
             preparedStatement.setString(4, video.getGenero());
           // preparedStatement.setInt(2, squema.getId_Squema());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Video> getAllVideos() {
		List<Video> videoLista = new ArrayList<Video>();
		try {
                      System.out.println("LLegue hasta aca");
			Statement statement = connection.createStatement();
                        
                        
			ResultSet rs = statement.executeQuery("select * from video");
			while (rs.next()) {
				Video video = new Video();
                                video.setIdvideo(rs.getInt("idvideo"));
				video.setTitulo(rs.getString("titulo"));
                                
                                video.setDirector(rs.getString("director"));
                                video.setCreacion(rs.getInt("creacion"));
                                video.setGenero(rs.getString("genero"));
				videoLista.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return videoLista;
	}
    
    public Video getvideoById(int videoid) {
		Video video = new Video();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from video where idvideo=?");
			preparedStatement.setInt(1, videoid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				video.setIdvideo(rs.getInt("idvideo"));
				video.setTitulo(rs.getString("titulo"));
                                video.setDirector(rs.getString("director"));
                                 video.setCreacion(rs.getInt("creacion"));
                                 video.setGenero(rs.getString("genero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return video;
	}
}