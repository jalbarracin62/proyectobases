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
public class Documentales extends Video {
    private int iddocumentales;
private String genero;

public Documentales( ) {
        super(   );
        
    }
public Documentales(int idvideo, String titulo, String director,  int creacion,   String genero ) {
        super(  idvideo,  titulo,  director,   creacion,  genero  );
        
    }

    public int getIddocumentales() {
        return iddocumentales;
    }

    public void setIddocumentales(int iddocumentales) {
        this.iddocumentales = iddocumentales;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Documentales{" + "iddocumentales=" + iddocumentales + ", genero=" + genero + '}';
    }
    

}
