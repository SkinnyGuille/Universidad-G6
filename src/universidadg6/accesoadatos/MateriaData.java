/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadg6.accesoadatos;

import java.sql.*;
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
        
        String sql ="INSERT INTO `materia`(`nombre`, `año`, `estado`)"
                + "VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarMateria(Materia materia) {
        // codigo para actualizar una materia en la base de datos
    }
    
    public void eliminarMateria(int idMateria) {
        // codigo para marcar una materia como eliminada en la base de datos
    }
    
    public Materia buscarMateria(int idMateria) {
        // codigo para buscar una materia por ID en la base de datos
        return null;
        // codigo para buscar una materia por ID en la base de datos
    }
    
    public List<Materia> listarMaterias() {
        // codigo para obtener una lista de todas las materias activas en la base de datos
        return null;
        // codigo para obtener una lista de todas las materias activas en la base de datos
    }
    
}
