package edu.eci.cosw.clases;
// Generated 9/04/2016 10:36:04 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *Establecimientos generated by hbm2java
 */
@Entity
@Table(name="ESTABLECIMIENTOS"
    //,catalog="coswgr4"
)
public class Establecimiento  implements java.io.Serializable {


     private String nit;
     private String razonsocial;
     private String direccion;
     private String telefono;
     private Double calificacionpromedio;
     private Set<Cancha> canchases = new HashSet<Cancha>(0);
     private Set<Calificacion> calificacioneses = new HashSet<Calificacion>(0);

    public Establecimiento() {
    }

	
    public Establecimiento(String nit) {
        this.nit = nit;
    }
    public Establecimiento(String nit, String razonsocial, String direccion, String telefono, Double calificacionpromedio, Set<Cancha> canchases, Set<Calificacion> calificacioneses) {
       this.nit = nit;
       this.razonsocial = razonsocial;
       this.direccion = direccion;
       this.telefono = telefono;
       this.calificacionpromedio = calificacionpromedio;
       this.canchases = canchases;
       this.calificacioneses = calificacioneses;
    }
   
     @Id 

    
    @Column(name="nit", unique=true, nullable=false, length=15)
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }

    
    @Column(name="razonsocial", length=50)
    public String getRazonsocial() {
        return this.razonsocial;
    }
    
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    
    @Column(name="direccion", length=50)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="telefono", length=10)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="calificacionpromedio", precision=5, scale=3)
    public Double getCalificacionpromedio() {
        return this.calificacionpromedio;
    }
    
    public void setCalificacionpromedio(Double calificacionpromedio) {
        this.calificacionpromedio = calificacionpromedio;
    }

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="NitEstablecimiento")
    public Set<Cancha> getCanchases() {
        return this.canchases;
    }
    
    public void setCanchases(Set<Cancha> canchases) {
        this.canchases = canchases;
    }

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="NitEstablecimiento")
    public Set<Calificacion> getCalificacioneses() {
        return this.calificacioneses;
    }
    
    public void setCalificacioneses(Set<Calificacion> calificacioneses) {
        this.calificacioneses = calificacioneses;
    }
}

