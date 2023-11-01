/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadg6;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import universidadg6.accesoadatos.AlumnoData;
import universidadg6.accesoadatos.Conexion;
import universidadg6.accesoadatos.InscripcionData;
import universidadg6.accesoadatos.MateriaData;
import universidadg6.entidades.Alumno;
import universidadg6.entidades.Inscripcion;
import universidadg6.entidades.Materia;

/**
 *
 * @author MI EQUIPO
 */
public class UniversidadG6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Connection conex= Conexion.getConexion();   
      
////////    PRUEBAS DE LA CLASE ALUMNODATA////////////////
    
        //AGREGAR ALUMNOS
//        Alumno a1 = new Alumno(12351777, "Lautaro", "Rodriguez", LocalDate.of(1996, 7, 21), true);
//        Alumno a2 = new Alumno(66651777, "Gustavo", "Rosales", LocalDate.of(1997, 3, 6), true);
//        AlumnoData alumnoData = new AlumnoData();
//          alumnoData.guardarAlumno(a1);
//          alumnoData.guardarAlumno(a2);

//        //  MODIFICAR ALUMNOS
//      
//      Alumno sebAlumno=new Alumno(4,12351777, "Lautaro", "Rodriguez", LocalDate.of(1996, 8, 21), false);
//      AlumnoData alumnoData= new AlumnoData();
//      alumnoData.modificarAlumno(sebAlumno);

        //BORRAR ALUMNOS
        // alumnoData.borradoLogicoAlumno(1);
        
        //MOSTRAR ALUMNOS por ID
//        Alumno alumnoEncontradoID=alumnoData.buscarAlumnoPorId(1);
//        System.out.println("Datos del alumno");
//        System.out.println("    ");
//        System.out.println("DNI"+ alumnoEncontradoID.getDni()); 
//        System.out.println("Nombre: "+ alumnoEncontradoID.getNombre());
//        System.out.println("Apellido: "+ alumnoEncontradoID.getApellido());
//        System.out.println("    ");


        //  MOSTRAR ALUMNOS por DNI
//        Alumno alumnoEncontradoDNI = alumnoData.buscarAlumnoPorDni(12351777);
//        if (alumnoEncontradoDNI != null) {
//            System.out.println("Datos del alumno por DNI");
//            System.out.println("    ");
//            System.out.println("Nombre: " + alumnoEncontradoDNI.getNombre());
//            System.out.println("Apellido: " + alumnoEncontradoDNI.getApellido());
//            System.out.println("DNI: " + alumnoEncontradoDNI.getDni());
//        } else {
//            System.out.println("");
//            System.out.println(" No encontré nada che por DNI...");
//        }

          //MOSTRAR LISTA ALUMNOS
//       AlumnoData alumnosData= new AlumnoData();
//        List<Alumno> listaAlumnos = alumnosData.listaAlumnos();
//
//      for (Alumno alumno : listaAlumnos) {
//          System.out.println("Nombre: " + alumno.getNombre() + ", Apellido "+ alumno.getApellido()+" ID: " + alumno.getIdAlumno() + ", DNI: " + alumno.getDni());
//}
        
    
////////    PRUEBAS DE LA CLASE MATERIADATA////////////////

            // GUARDAR MATERIA 

//        Materia m1 = new Materia("Matematica", 2023, true);
//        Materia m2 = new Materia("Lengua", 2023, true);
//        Materia m3 = new Materia("Ingles", 2023, true);
//        MateriaData materiaData = new MateriaData();
//        materiaData.guardarMateria(m3);
//        materiaData.guardarMateria(m2);
//        
           //BUSCAR MATERIA 
//     MateriaData md= new MateriaData();
//     Materia m1 = md.buscarMateria(5);
//        System.out.println("Datos de materia por id");
//         System.out.println("    ");
//            System.out.println("Nombre: " + m1.getNombre() );
//          System.out.println("Año: " + m1.getAnioMateria() );
///     //LISTAR MATERIA
         MateriaData materialista = new MateriaData();
        List<Materia> listaMateria = materialista.listarMaterias();
//
      for (Materia materia : listaMateria) {
        System.out.println("Nombre: " + materia.getNombre() + ", Año "+ materia.getAnioMateria()+", ID: " + materia.getIdMateria());
}      

////////    PRUEBAS DE LA CLASE INSCRIPCIONDATA////////////////

        // CARGAR INSCRIPCION 
//      
//     AlumnoData ad= new AlumnoData();
//     MateriaData md=new MateriaData();
//     InscripcionData ins=new InscripcionData();
//     
//     Alumno Gustavo = ad.buscarAlumnoPorId(5);
//     Materia m1 = md.buscarMateria(6);
//     Inscripcion inscri =  new Inscripcion(Gustavo,m1,9);
//     ins.guardarInscripcion(inscri);


    }
}
