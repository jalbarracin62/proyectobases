/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

/**
 *
 * @author Juan Albarracin
 */
public class Video {
    private int idvideo;
    private String titulo;
    private String director;
    private int creacion;
    private String genero;

    public Video(int idvideo, String titulo, String director, int creacion, String genero) {
        this.idvideo = idvideo;
        this.titulo = titulo;
        this.director = director;
        this.creacion = creacion;
        this.genero = genero;
    }

    public Video() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(int idvideo) {
        this.idvideo = idvideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCreacion() {
        return creacion;
    }

    public void setCreacion(int creacion) {
        this.creacion = creacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Video{" + "idvideo=" + idvideo + ", titulo=" + titulo + ", director=" + director + ", creacion=" + creacion + ", genero=" + genero + '}';
    }
    
}
