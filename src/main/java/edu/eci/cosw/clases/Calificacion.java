package edu.eci.cosw.clases;
// Generated 9/04/2016 10:36:04 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Calificacion generated by hbm2java
 */
@Entity
@Table(name="CALIFICACIONES"
    //,catalog="coswgr4"
)
public class Calificacion  implements java.io.Serializable {


     private int idcalificacion;
     //private Establecimiento establecimientos;
     //private Usuario usuarios;
     private int puntaje;
     private String observacion;
     private String usuarioId;
     private String nit;
     
    public Calificacion() {
    }

	
    public Calificacion(int idcalificacion, Establecimiento establecimientos, Usuario usuarios, int puntaje) {
        this.idcalificacion = idcalificacion;
        //this.establecimientos = establecimientos;
        //this.usuarios = usuarios;
        this.puntaje = puntaje;
    }
    public Calificacion(int idcalificacion, Establecimiento establecimientos, Usuario usuarios, int puntaje, String observacion) {
       this.idcalificacion = idcalificacion;
       //this.establecimientos = establecimientos;
       //this.usuarios = usuarios;
       this.puntaje = puntaje;
       this.observacion = observacion;
    }
   
     @Id 

    @GeneratedValue
    @Column(name="idcalificacion", unique=true, nullable=false)
    public int getIdcalificacion() {
        return this.idcalificacion;
    }
    
    public void setIdcalificacion(int idcalificacion) {
        this.idcalificacion = idcalificacion;
    }
/*
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NitEstablecimiento", nullable=false)
    public Establecimiento getEstablecimientos() {
        return this.establecimientos;
    }
    
    public void setEstablecimientos(Establecimiento establecimientos) {
        this.establecimientos = establecimientos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USUARIOS_idCliente", nullable=false)
    public Usuario getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
*/
    
    @Column(name="puntaje", nullable=false)
    public int getPuntaje() {
        return this.puntaje;
    }
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
    @Column(name="observacion", length=100)
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    
    @Column(name="USUARIOS_idCliente", nullable = false, length=10)
    public String getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    @Column(name="NitEstablecimiento", nullable = false, length=15)
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }


}


