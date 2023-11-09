
package universidadg6.accesoadatos;

import java.sql.Connection;
import java.sql.*;
import universidadg6.entidades.Inscripcion;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadg6.entidades.Alumno;
import universidadg6.entidades.Materia;
/**
 *
 * @author MI EQUIPO
 */
public class InscripcionData {
    private Connection con= null;
    private AlumnoData ad = new AlumnoData();
    private MateriaData md = new MateriaData(); 
    

    public InscripcionData() {
        this.con= Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql= "INSERT INTO inscripcion(idAlumno, idMateria,nota)"
                +"VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));//solo hay una
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de inscripcion");
        }
        
        
        
    }
    public List<Inscripcion> obtenerInscripciones(){
        
        ArrayList<Inscripcion> cursada = new ArrayList<>();
        
        String sql ="SELECT * FROM inscripcion"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Inscripcion inscrp = new Inscripcion();
            inscrp.setIdInscripcion(rs.getInt("idinscripto"));
            Alumno alum=ad.buscarAlumnoPorId(rs.getInt("idalumno"));
            Materia mate=md.buscarMateria(rs.getInt("idmateria"));
            inscrp.setAlumno(alum);
            inscrp.setMateria(mate);
            inscrp.setNota(rs.getDouble("nota"));
            cursada.add(inscrp);
     
            }
            ps.close();
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de inscripcion");
        }
        return cursada;
     }
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idalumno){
        
        ArrayList<Inscripcion> cursada = new ArrayList<>();
        
        String sql ="SELECT * FROM inscripcion WHERE idalumno=?"; 
    try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Inscripcion inscrp = new Inscripcion();
            inscrp.setIdInscripcion(rs.getInt("idinscripto"));
            Alumno alum=ad.buscarAlumnoPorId(rs.getInt("idalumno"));
            Materia mate=md.buscarMateria(rs.getInt("idmateria"));
            inscrp.setAlumno(alum);
            inscrp.setMateria(mate);
            inscrp.setNota(rs.getDouble("nota"));
            cursada.add(inscrp);
     
            }
            ps.close();
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de inscripcion");
        }
        return cursada;
     }
    public List<Materia> obtenerMateriaCursadas(int idalumno){
        
        ArrayList <Materia > materias=new ArrayList<>();
        
        String sql = "SELECT inscripcion.idmateria, nombre, año FROM inscripcion, materia "
                + "WHERE inscripcion.idmateria=materia.idmateria AND inscripcion.idalumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Materia materia= new Materia();
            materia.setIdMateria(rs.getInt("idmateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("año"));
            materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de Materias Cursadas");
        }
        
    return materias; 
       }
    public List<Materia> obtenerMateriaNoCursadas(int idalumno){
    ArrayList <Materia> materias=new ArrayList();
    String sql = "SELECT * FROM materia "
            + "WHERE estado = 1 AND idmateria not in (SELECT idmateria FROM inscripcion WHERE idalumno = ?)";
    try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Materia materia= new Materia();
            materia.setIdMateria(rs.getInt("idmateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("año"));
            materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de Materias Cursadas");
        }
        
    return materias; 
    }
    public void borrarInscripcioMateriaAlumno(int idalumno, int idmateria){
    
        String sql="DELET FROM inscripcion WHERE idalumno=? AND idmateria= ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ps.setInt(2, idmateria);
            int filas= ps.executeUpdate();
            if(filas>0){
            JOptionPane.showMessageDialog(null, "Inscripcion Borrada");
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de Inscripcion");
        }
    }
    public void actualizarNota(int idalumno, int idmateria, double nota ){
   
    String sql="UPDATE inscripcion "
            + "SET nota=? WHERE idalumno=? AND idmateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idalumno);
            ps.setInt(3, idmateria);
            int filas = ps.executeUpdate();
            if(filas>0){
            JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de Inscripcion");
        }
    
    }
    public List<Alumno> ObtenerAlumnoPorMateria(int idmateria){
        ArrayList alumnosMateria = new ArrayList();
        String sql="SELEC FROM a.idalumno, dni, nombre,apellido,fechaNacimiento, estado"
                + "FROM inscripcion i, alumno a WHERE i.idalumno= a.idalumno AND idmateria = ? AND a.estado = 1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idmateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(rs.getInt("idalumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
            alumno.setActivo(rs.getBoolean("estado"));
            alumnosMateria.add(alumno);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder al tabla de Inscripcion");
        }
        
        return alumnosMateria;
    }
    
   
}
