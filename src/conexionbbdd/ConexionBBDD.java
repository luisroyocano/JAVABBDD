/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author luisr
 */
public class ConexionBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // Establecemos la conexión con la base de datos.

            Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clase","root", "");
            Statement st = conexion.createStatement();
//            st.executeUpdate("insert into alumnos values ('luis', '11900421z', 7,'luis@ufv.es')");
            

        
        ConexionBBDD it = new ConexionBBDD();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("leer(1), actualizar registro(2), dar de baja(3)  \n");
        int menu = sc.nextInt();
        
        if(menu == 1){
            System.out.println("usted ha seleccionado leer \n");

            it.leeDatos();
        }else{
            if(menu == 2){
                 
                 System.out.println("usted ha seleccionado actualizar registro\n");
                 System.out.println("escriba el nombre del alumno \n");
                 Scanner sc_n = new Scanner(System.in);
                 String _nombre = sc_n.nextLine();
                 
                 
                 System.out.println("escriba el dni del alumno \n");
                 Scanner sc_d = new Scanner(System.in);
                 String _dni = sc_d.nextLine();
                 
                 
                 System.out.println("escriba la media del alumno \n");
                 Scanner sc_m = new Scanner(System.in);
                 String _media = sc_m.nextLine();
                 
                 
                 System.out.println("escriba el email del alumno \n");
                 Scanner sc_e = new Scanner(System.in);
                 String _email = sc_e.nextLine();

                 it.grabaRegistro(_nombre,_dni,_media,_email);

                 
            }else{ if(menu == 3){
                 System.out.println("usted ha seleccionado borrar registro \n");
                 System.out.println("escriba ahora su dni: \n");
                 
                 Scanner borrador = new Scanner(System.in);
                 String dni = borrador.nextLine();
                 
                 it.borraDatos(dni);
            }
            }
        }
    }
    public void leeDatos()throws SQLException{
        
         Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clase","root", "");
          Statement st = conexion.createStatement();

            
            ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
           
           while (rs.next()){
               System.out.println("nombre="+rs.getObject("nombre")+
                        ", dni=" + rs.getObject("dni")+
                       ", media=" + rs.getObject("media")+", email="+ rs.getObject("email") );
           }
           rs.close();
    }
    public void grabaRegistro(String nombre, String dni, String media, String email)throws SQLException{
        
           Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clase","root", "");
           Statement st = conexion.createStatement();
           st.executeUpdate("insert into alumnos values ('"+nombre+"', '"+dni+"', '"+media+"','"+email+"')");
         
    }

    private void borraDatos(String dni) throws SQLException {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clase","root", "");
           Statement st = conexion.createStatement();
           st.executeUpdate("DELETE FROM alumnos  WHERE dni = '"+dni+"'");

    }
}
