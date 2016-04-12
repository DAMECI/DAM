package TestDam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.cosw.Repositories.CanchaRepository;
import edu.eci.cosw.Repositories.EstablecimientoRepository;
import edu.eci.cosw.Repositories.ReservaRepository;
import edu.eci.cosw.Repositories.UserRepository;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.CanchasId;
import edu.eci.cosw.clases.Establecimiento;
import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.ReservasId;
import edu.eci.cosw.clases.Usuario;
import edu.eci.cosw.imp.DamServices;
import edu.eci.cosw.main.DemoApplication;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author 2087151
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class ApiRestTest {
    
    @Autowired
    UserRepository userRep;
    
    @Autowired
    EstablecimientoRepository estRep;
    
    @Autowired
    ReservaRepository resRep;
    
    @Autowired
    CanchaRepository canRep;
    
    @Autowired
    ReservaRepository resRep;

    @Autowired
    DamServices services;
    
        @Test
	public void existeUsuario() throws Exception {
            Usuario u = new Usuario("martin123", "Martin", "Alvarez", "abcd123");
            Usuario u2 = new Usuario("camila87", "Camila", "Perlaza", "9587463", "camila@mail.com", 
                    "12345as", null, null);
            userRep.save(u);
            userRep.save(u2);
            assertEquals("martin123", services.findUserById("martin123").getIdCliente());
            assertEquals("Martin", services.findUserById("martin123").getNombre());
            assertEquals("Alvarez", services.findUserById("martin123").getApellido());
            assertEquals("camila87", services.findUserById("camila87").getIdCliente());
            assertEquals("Camila", services.findUserById("camila87").getNombre());
            assertEquals("Perlaza", services.findUserById("camila87").getApellido());
            assertEquals("camila@mail.com", services.findUserById("camila87").getEmail());
            assertEquals("9587463", services.findUserById("camila87").getTelefono());
           
	}
        
        
        
        
        @Test
        public void noExisteUsuario() throws Exception{
            Usuario u = new Usuario("896632", "Andrea", "Pardo", "789ab");
            assertNull(services.findUserById("7asg89e"));
            assertNull(services.findUserById("896632"));
        }
        
        @Test
        public void agregaUsuario() throws Exception{
            services.addUser(new Usuario("maria89", "Maria", "Lopez", "89652"));
            assertNotNull(services.findUserById("maria89"));
        }
    
    /*    @Test
        public void agregaReserva() throws Exception{
            
            Establecimiento e= new Establecimiento("6789-3");
            estRep.save(e);
            
            Cancha c=new Cancha(new CanchasId(123,e.getNit()) ,e );
            canRep.save(c);
            
            Usuario u=new Usuario("124", "Carolina", "Bece", "124"); 
            userRep.save(u);
            services.addReserva(new Reserva());
            services.addReserva(new Reserva(new ReservasId(111,e.getNit()), c ,u , null , 30.000, 2.3 ,"124", "ocupado"  ));
            
            assertNotNull(services.getReservaByid(111));
            
            
        } 
        
      */  
        @Test
        public void agregaEstablecimiento() throws Exception{
            services.addEstablecimiento(new Establecimiento("7854-2", "Emirate Futbol5", "calle 9 #145-51", "9999658", 
                    3.5, null, null));
            assertNotNull(services.getEstablecimientoByNit("7854-2"));
        }
        
        @Test
        public void obtieneEstablecimientos() throws Exception{
            Establecimiento est = new Establecimiento("9621", "xxx", "cra.7 #85-06", "5552255", 4.8, null, null);
            Establecimiento est1 = new Establecimiento("5896", "yyy", "cra.7 #85-06", "5552255", 4.2, null, null);
            Establecimiento est2 = new Establecimiento("2540", "zzz", "cra.7 #85-06", "5552255", 3.2, null, null);
            estRep.save(est);
            estRep.save(est1);
            estRep.save(est2);
            
            assertEquals(7, services.getEstablecimientos().size());
            
            estRep.delete(est);
            estRep.delete(est1);
            estRep.delete(est2);
        }
        
        @Test
        public void existeEstablecimiento() throws Exception{
            Establecimiento est = new Establecimiento("895", "aaa", "cra.45 #103-06", "9854100", 4.8, null, null);
            Establecimiento est1 = new Establecimiento("2652-2", "abc", "cra.4 #180-06", "9854100", 4.0, null, null);
            estRep.save(est);
            estRep.save(est1);
            assertNotNull("895", services.getEstablecimientoByNit("895"));
            assertNotNull("2652-2", services.getEstablecimientoByNit("2652-2"));
            assertEquals("aaa", services.getEstablecimientoByNit("895").getRazonsocial());
            assertEquals("cra.45 #103-06", services.getEstablecimientoByNit("895").getDireccion());
            assertEquals("9854100", services.getEstablecimientoByNit("895").getTelefono());
            assertTrue(services.getEstablecimientoByNit("895").getCalificacionpromedio()==4.8);

            assertEquals("abc", services.getEstablecimientoByNit("2652-2").getRazonsocial());
            assertEquals("cra.4 #180-06", services.getEstablecimientoByNit("2652-2").getDireccion());
            assertEquals("9854100", services.getEstablecimientoByNit("2652-2").getTelefono());
            assertTrue(services.getEstablecimientoByNit("2652-2").getCalificacionpromedio()==4.0);
        }
        
        @Test
        public void noExiteEstablecimiento() throws Exception{
            assertNull(services.getEstablecimientoByNit("89562"));
            Establecimiento e = new Establecimiento("123-6");
            assertNull(services.getEstablecimientoByNit("123-6"));
        }
        
        @Test
        public void canchasEstablecimiento() throws Exception{
            Set<Cancha> canchas = new HashSet<Cancha>();
            Cancha c = new Cancha(new CanchasId(1, "2154"), new Establecimiento("2154"), true, 0, null, null);
            Cancha c1 = new Cancha(new CanchasId(2, "2154"), new Establecimiento("2154"), true, 0, null, null);
            canchas.add(c);
            canchas.add(c1);
            Establecimiento e = new Establecimiento("2154", "ppp", "diagonal 127 #36-08", "8965423", 2.8, canchas, null);
            estRep.save(e);
            
            assertTrue(services.getEstablecimientoByNit("2154").getCanchases().size()==2);
        }
        
        @Test
	public void existeCancha() throws Exception {
            Establecimiento e = new Establecimiento("1548-5");
            estRep.save(e);
            Cancha c = new Cancha(new CanchasId(58,"1548-5"), e, true, 0, null, null);
            Cancha c1 = new Cancha(new CanchasId(99,"1548-5"), e, true, 0, null, null);
            canRep.save(c);
            canRep.save(c1);
            assertNotNull(services.getCanchaByid(58));
            assertNotNull(services.getCanchaByid(99));
            
            assertEquals("1548-5", services.getCanchaByid(58).getId().getNitEstablecimiento());
            assertTrue(services.getCanchaByid(58).getEstadocancha()==true);
            assertEquals(0,services.getCanchaByid(58).getReservases().size());
            assertEquals("1548-5", services.getCanchaByid(99).getId().getNitEstablecimiento());
            assertTrue(services.getCanchaByid(99).getEstadocancha()==true);
            assertEquals(0,services.getCanchaByid(99).getReservases().size());
        }
        
        @Test
	public void noExisteCanchaSinEstablecimiento() throws Exception {
            Establecimiento e = new Establecimiento("59620");
            Cancha c = new Cancha(new CanchasId(58,"59620"), e, true, 0, null, null);
            Cancha c1 = new Cancha(new CanchasId(99,"59620"), e, true, 0, null, null);
            try {
                canRep.save(c);
                canRep.save(c1);
                fail("Se espera excepcion Exception");
              } catch(Exception ex) {}
        }
        
        @Test 
        public void noExistenCanchas() throws Exception {
            assertNull(services.getCanchaByid(589));
            Cancha c = new Cancha(new CanchasId(1254,"54128-2"), null, true, 0, null, null);
            assertNull(services.getCanchaByid(1254));         
        }
        
        @Test
        public void agregaReserva() throws Exception{
            
            Establecimiento e= new Establecimiento("8756210");
            estRep.save(e);
            
            Cancha c=new Cancha(new CanchasId(123,"8756210") ,e );
            canRep.save(c);
            
            Usuario u=new Usuario("asd124", "Carolina", "Bece", "124"); 
            userRep.save(u);
            //services.addReserva(new Reserva(new ReservasId(111,"8756210"), c, u, "124"));
            services.addReserva(new Reserva(new ReservasId(111,e.getNit()), c ,u , new Date(13-01-2014), 
                    30.000, 2.3 ,u.getIdCliente(), "ocupado"  ));
            
            assertNotNull(services.getReservaByid(111));
            
            
        }
        
        @Test
	public void existeReserva() throws Exception {
            Establecimiento e = new Establecimiento("203-99");
            estRep.save(e);
            Cancha c = new Cancha(new CanchasId(58,"203-99"), e, true, 0, null, null);
            Cancha c1 = new Cancha(new CanchasId(99,"203-99"), e, true, 0, null, null);
            canRep.save(c);
            canRep.save(c1);
            Usuario u = new Usuario("ar85", "marta", "casas", "8965");
            userRep.save(u);
           
            
            Reserva r = new Reserva(new ReservasId(123,"203-99"), c, u, new Date(13-01-2014), 
                    30.000, 2.3 ,u.getIdCliente(), "ocupado");
            resRep.save(r);
            assertNotNull(services.getReservaByid(123));
            
        }
}
