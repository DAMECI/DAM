package edu.eci.cosw.clases;
// Generated 9/04/2016 10:36:04 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * ReservasId generated by hbm2java
 */
@Embeddable
public class ReservasId  implements java.io.Serializable {


     private int idreserva;
     private String nitEstablecimiento;

    public ReservasId() {
    }

    public ReservasId(int idreserva, String nitEstablecimiento) {
       this.idreserva = idreserva;
       this.nitEstablecimiento = nitEstablecimiento;
    }
   

    @GeneratedValue
    @Column(name="idreserva", nullable=false)
    public int getIdreserva() {
        return this.idreserva;
    }
    
    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
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
		 if ( !(other instanceof ReservasId) ) return false;
		 ReservasId castOther = ( ReservasId ) other; 
         
		 return (this.getIdreserva()==castOther.getIdreserva())
 && ( (this.getNitEstablecimiento()==castOther.getNitEstablecimiento()) || ( this.getNitEstablecimiento()!=null && castOther.getNitEstablecimiento()!=null && this.getNitEstablecimiento().equals(castOther.getNitEstablecimiento()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdreserva();
         result = 37 * result + ( getNitEstablecimiento() == null ? 0 : this.getNitEstablecimiento().hashCode() );
         return result;
   }   


}


