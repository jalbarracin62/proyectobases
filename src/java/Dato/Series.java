/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import org.hibernate.validator.constraints.br.TituloEleitoral;

/**
 *
 * @author Juan Albarracin
 */
public class Series extends Video{
private int idseries;
private int nocapitulos;
private int notemporadas;
 public Series( ) {
        super(   );
        
    }
    public Series( int idvideo, String titulo, String director,  int creacion,   String genero,int idseries, int nocapitulos, int notemporadas) {
        super(   idvideo,  titulo,  director,   creacion,  genero);
        this.idseries = idseries;
        this.nocapitulos = nocapitulos;
        this.notemporadas = notemporadas;
    }

    public int getIdseries() {
        return idseries;
    }

    public void setIdseries(int idseries) {
        this.idseries = idseries;
    }

    public int getNocapitulos() {
        return nocapitulos;
    }

    public void setNocapitulos(int nocapitulos) {
        this.nocapitulos = nocapitulos;
    }

    public int getNotemporadas() {
        return notemporadas;
    }

    public void setNotemporadas(int notemporadas) {
        this.notemporadas = notemporadas;
    }

    @Override
    public String toString() {
        return "Series{" + "idseries=" + idseries + ", nocapitulos=" + nocapitulos + ", notemporadas=" + notemporadas + '}';
    }
    
   
    
}
