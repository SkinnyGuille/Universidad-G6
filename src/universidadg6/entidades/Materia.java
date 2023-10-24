
package universidadg6.entidades;

public class Materia {
    private int idmateria;
    private String nombre;
    private int anioMateria;
    private boolean activo;
    
    public Materia() {
    }

    public Materia(int idmateria, String nombre, int anioMateria, boolean activo) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idmateria;
    }

    public void setIdMateria(int idMateria) {
        this.idmateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idmateria + ", nombre=" + nombre + ", anioMateria=" + anioMateria + ", activo=" + activo + '}';
    }
    
    
}
