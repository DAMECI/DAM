package edu.eci.cosw.clases;
// Generated 9/04/2016 08:18:08 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CanchasId generated by hbm2java
 */
@Embeddable
public class CanchasId  implements java.io.Serializable {


     private int idcancha;
     private String nitEstablecimiento;

    public CanchasId() {
    }

    public CanchasId(int idcancha, String nitEstablecimiento) {
       this.idcancha = idcancha;
       this.nitEstablecimiento = nitEstablecimiento;
    }
   


    @Column(name="idcancha", nullable=false)
    public int getIdcancha() {
        return this.idcancha;
    }
    
    public void setIdcancha(int idcancha) {
        this.idcancha = idcancha;
    }


    @Column(name="NitEstablecimiento", nullable=false, length=15)
    public String getNitEstablecimiento() {
        return this.nitEstablecimiento;
    }
    
    public void setNitEstablecimiento(String nitEstablecimiento) {
        this.nitEstablecimiento = nitEstablecimiento;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CanchasId) ) return false;
		 CanchasId castOther = ( CanchasId ) other; 
         
		 return (this.getIdcancha()==castOther.getIdcancha())
 && ( (this.getNitEstablecimiento()==castOther.getNitEstablecimiento()) || ( this.getNitEstablecimiento()!=null && castOther.getNitEstablecimiento()!=null && this.getNitEstablecimiento().equals(castOther.getNitEstablecimiento()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdcancha();
         result = 37 * result + ( getNitEstablecimiento() == null ? 0 : this.getNitEstablecimiento().hashCode() );
         return result;
   }   


}

