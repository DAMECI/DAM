package edu.eci.cosw.clases;
// Generated 9/04/2016 10:36:04 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HorariosId generated by hbm2java
 */
@Embeddable
public class HorariosId  implements java.io.Serializable {


     private int dia;
     private int horaInicial;
     private int horaFin;
     private int canchasIdcancha;
     private double precio;
     private String nitEstablecimiento;

    public HorariosId() {
    }

    public HorariosId(int dia, int horaInicial, int horaFin, int canchasIdcancha, double precio, String nitEstablecimiento) {
       this.dia = dia;
       this.horaInicial = horaInicial;
       this.horaFin = horaFin;
       this.canchasIdcancha = canchasIdcancha;
       this.precio = precio;
       this.nitEstablecimiento = nitEstablecimiento;
    }
   


    @Column(name="Dia", nullable=false)
    public int getDia() {
        return this.dia;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }


    @Column(name="HoraInicial", nullable=false)
    public int getHoraInicial() {
        return this.horaInicial;
    }
    
    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }


    @Column(name="HoraFin", nullable=false)
    public int getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }


    @Column(name="CANCHAS_idcancha", nullable=false)
    public int getCanchasIdcancha() {
        return this.canchasIdcancha;
    }
    
    public void setCanchasIdcancha(int canchasIdcancha) {
        this.canchasIdcancha = canchasIdcancha;
    }


    @Column(name="Precio", nullable=false, precision=10)
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Column(name="Nit_Establecimiento", nullable=false, length=15)
    public String getNitEstablecimiento() {
        return this.nitEstablecimiento;
    }
    
    public void setNitEstablecimiento(String nitEstablecimiento) {
        this.nitEstablecimiento = nitEstablecimiento;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HorariosId) ) return false;
		 HorariosId castOther = ( HorariosId ) other; 
         
		 return (this.getDia()==castOther.getDia())
 && ( (this.getHoraInicial()==castOther.getHoraInicial())  )
 && ( (this.getHoraFin()==castOther.getHoraFin())  )
 && (this.getCanchasIdcancha()==castOther.getCanchasIdcancha())
 && (this.getPrecio()==castOther.getPrecio())
 && ( (this.getNitEstablecimiento()==castOther.getNitEstablecimiento()) || ( this.getNitEstablecimiento()!=null && castOther.getNitEstablecimiento()!=null && this.getNitEstablecimiento().equals(castOther.getNitEstablecimiento()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDia();
         result = 37 * result + this.getHoraInicial();
         result = 37 * result + this.getHoraFin();
         result = 37 * result + this.getCanchasIdcancha();
         result = 37 * result + (int) this.getPrecio();
         result = 37 * result + ( getNitEstablecimiento() == null ? 0 : this.getNitEstablecimiento().hashCode() );
         return result;
   }   


}


