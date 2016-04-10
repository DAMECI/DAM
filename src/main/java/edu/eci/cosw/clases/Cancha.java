package edu.eci.cosw.clases;
// Generated 9/04/2016 10:36:04 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *Canchas generated by hbm2java
 */
@Entity
@Table(name="CANCHAS"
    //,catalog="coswgr4"
)
public class Cancha  implements java.io.Serializable {


     private CanchasId id;
     //private Establecimiento establecimientos;
     private Boolean estadocancha;
     private Integer reservaId;
     private Set<Horario> horarioses = new HashSet<Horario>(0);
     private Set<Reserva> reservases = new HashSet<Reserva>(0);

    public Cancha() {
    }

	
    public Cancha(CanchasId id, Establecimiento establecimientos) {
        this.id = id;
        //this.establecimientos = establecimientos;
    }
    public Cancha(CanchasId id, Establecimiento establecimientos, Boolean estadocancha, Integer reservaId, Set<Horario> horarioses, Set<Reserva> reservases) {
       this.id = id;
       //this.establecimientos = establecimientos;
       this.estadocancha = estadocancha;
       this.reservaId = reservaId;
       this.horarioses = horarioses;
       this.reservases = reservases;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idcancha", column=@Column(name="idcancha", nullable=false) ), 
        @AttributeOverride(name="nitEstablecimiento", column=@Column(name="NitEstablecimiento", nullable=false, length=15) ) } )
    public CanchasId getId() {
        return this.id;
    }
    
    public void setId(CanchasId id) {
        this.id = id;
    }
/*
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NitEstablecimiento", nullable=false, insertable=false, updatable=false)
    public Establecimiento getEstablecimientos() {
        return this.establecimientos;
    }
    
    public void setEstablecimientos(Establecimiento establecimientos) {
        this.establecimientos = establecimientos;
    }
*/
    
    @Column(name="estadocancha")
    public Boolean getEstadocancha() {
        return this.estadocancha;
    }
    
    public void setEstadocancha(Boolean estadocancha) {
        this.estadocancha = estadocancha;
    }

    
    @Column(name="reserva_id")
    public Integer getReservaId() {
        return this.reservaId;
    }
    
    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumns( { 
        @JoinColumn(name="CANCHAS_idcancha"), 
        @JoinColumn(name="Nit_Establecimiento")})
    public Set<Horario> getHorarioses() {
        return this.horarioses;
    }
    
    public void setHorarioses(Set<Horario> horarioses) {
        this.horarioses = horarioses;
    }

@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumns( { 
        @JoinColumn(name="IdCancha"), 
        @JoinColumn(name="Nit_Establecimiento") } )
    public Set<Reserva> getReservases() {
        return this.reservases;
    }
    
    public void setReservases(Set<Reserva> reservases) {
        this.reservases = reservases;
    }
}