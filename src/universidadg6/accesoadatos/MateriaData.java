/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadg6.accesoadatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadg6.entidades.Materia;

public class MateriaData {
    private Connection con=null;

    public MateriaData() {
        this.con= Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        
        String query ="INSERT INTO `materia`(`nombre`, `año`, `estado`)"
                + "VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(1);
                JOptionPane.showMessageDialog(null, "Materia agregada");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose Agrego materia");
        }
    }
    
    public void modificarMateria(Materia materia) {
         String sql = "UPDATE materia SET  nombre=?, año=?, estado=? WHERE idmateria=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnioMateria());
            ps.setBoolean(3,materia.isActivo());
            
             int materias=ps.executeUpdate();
             if(materias>0){
                 JOptionPane.showMessageDialog(null, "Materia Modificada");       
             }else{
             JOptionPane.showMessageDialog(null, "No se encontro Materia");
             }
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose Modifico materia");
        }
         
              
    }
    
    public void eliminarMateria(int idmateria) {
        
        String sql = "UPDATE materia SET estado = false WHERE idmateria = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idmateria);
            int materias=ps.executeUpdate();
            if(materias>0){
                JOptionPane.showMessageDialog(null, "Se Elimino la Materi (Forma Logica)");
            }
            
        } catch (SQLException ex) {   
            JOptionPane.showMessageDialog(null, "Nose Elimino materia");
        }
    }
    
    public Materia buscarMateria(int idmateria) {
        Materia materias = null;
        String sql = "SELECT nombre, año, estado FROM materia WHERE idmateria = ? AND estado = 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idmateria);
            ResultSet rs= ps.executeQuery();
            
            if (rs.next()) {
                materias = new Materia();
                materias.setIdMateria(idmateria);
                materias.setNombre(rs.getString("nombre"));
                materias.setAnioMateria(rs.getInt("año"));
                materias.setActivo(true);
            }else{
            JOptionPane.showMessageDialog(null, "Nose existe materia");
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nose se accedio a la tabla materia");
           
        }
        
        return materias;
    }
    
    public List<Materia> listarMateria() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String nombre= rs.getString("nombre");
                int año = rs.getInt("año");
                boolean estado = rs.getBoolean("estado");
                
                Materia mate = new Materia();
                mate.setNombre(nombre);
                mate.setAnioMateria(año);
                mate.setActivo(estado);
                
                materias.add(mate);
            }
            ps.close();
            rs.close();            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Nose encontro materia");    
    }
        return materias;
}
}