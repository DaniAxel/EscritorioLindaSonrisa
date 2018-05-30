package DAO_IMP;

import BBDD.Conexion;
import DAO.ITrabajadorDao;
import DTO.TrabajadorDto;
import java.security.Principal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andres
 */
public class TrabajadorDaoImp implements ITrabajadorDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean deshabilitar(TrabajadorDto trabajador) {
        String query = "UPDATE trabajador SET habilitado=0 WHERE rut=?";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, trabajador.getRut());

            //Si actualiza una fila retorna
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL deshabilitando trabajador " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al deshabilitar trabajador " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<TrabajadorDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(TrabajadorDto trabajador) {
        String query = "INSERT INTO trabajador VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, trabajador.getRut());
            sql.setString(2, trabajador.getNombre());
            sql.setDate(3, trabajador.getFechaNacimiento());
            sql.setString(4, trabajador.getSexo());
            sql.setString(5, trabajador.getCorreo());
            sql.setString(6, trabajador.getDireccion());
            sql.setString(7, trabajador.getTelefono());
            sql.setString(8, trabajador.getContrasenia());
            sql.setString(9, trabajador.getTipo());
            sql.setString(10, trabajador.getEspecialidad());
            sql.setBoolean(11, trabajador.isHabilitado());

            //Si ejecuta, agregamos y cerramos conexión
            if (sql.execute()) {
                connection.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al agregar trabajador: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar trabajador" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(TrabajadorDto trabajador) {
        String query = "UPDATE trabajador SET nombre=?,fecha_nacimiento=?,sexo=?,correo=?,direccion=?,telefono=?,"
                + "contraseña=?,tipo=?,especialidad=?,habilitado=? WHERE rut=? ";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
                        
            sql.setString(1, trabajador.getRut());
            sql.setString(2, trabajador.getNombre());
            sql.setDate(3, trabajador.getFechaNacimiento());            
            sql.setString(4, trabajador.getSexo());
            sql.setString(5, trabajador.getCorreo());
            sql.setString(6, trabajador.getDireccion());
            sql.setString(7, trabajador.getTelefono());            
            sql.setString(8, trabajador.getContrasenia());
            sql.setString(9, trabajador.getTipo());
            sql.setString(10, trabajador.getEspecialidad());
            sql.setBoolean(11, trabajador.isHabilitado());

            //executeUpdate para ver si se actualizó una fila
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al modificar trabajador" + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificar trabajador " + e.getMessage());
        }
        return false;
    }

    /**
     *
     * @param trabajador
     * @return
     */
    //Buscar trabajador por rut
    public boolean buscars(TrabajadorDto trabajador) {
        String query = "SELECT * FROM trabajador WHERE rut = ?";
        try (Connection connection = Conexion.getConexion()) {

            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, trabajador.getRut());

            try (ResultSet results = sql.executeQuery()) {
                while (results.next()) {
                    trabajador.setRut(results.getString("rut"));
                    trabajador.setNombre(results.getString("nombre"));
                    trabajador.setFechaNacimiento(results.getDate("fecha_nacimiento"));
                    trabajador.setSexo(results.getString("sexo"));
                    trabajador.setCorreo(results.getString("correo"));
                    trabajador.setDireccion(results.getString("direccion"));
                    trabajador.setTelefono(results.getString("telefono"));
                    trabajador.setContrasenia(results.getString("contraseña"));                    
                    trabajador.setTipo(results.getString("tipo"));
                    trabajador.setEspecialidad(results.getString("especialidad"));                    
                    trabajador.setHabilitado(results.getBoolean("habilitado"));
                    return true;
                    
                }
            } catch (Exception e) {
                log.error("Error al obtener resultset de buscar: " + e.getMessage());
            }
            connection.close();

        } catch (SQLException s) {
            log.error("Error SQL buscando trabajador " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar trabajador " + e.getMessage());
        } finally {
            
        }
        return false;
    }

    @Override
    //habilitar trabajador por rut
    public boolean habilitar(TrabajadorDto trabajador) {
        String query = "UPDATE trabajador SET habilitado=1 WHERE rut=?";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, trabajador.getRut());

            //Si actualiza una fila retorna
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL habilitando trabajador " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al habilitar trabajador " + e.getMessage());
        }
        return false;
    }

    @Override
    public TrabajadorDto buscar(TrabajadorDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean iniciar(TrabajadorDto dto){
        String query="select rut, contraseña from trabajador where rut=? and contraseña=?";
        try(Connection connection = Conexion.getConexion()){
            PreparedStatement sql=connection.prepareCall(query);
            sql.setString(1,dto.getRut());
            sql.setString(2, dto.getContrasenia());
            ResultSet rs=sql.executeQuery();
            while(rs.next()){
                dto.setRut(rs.getString("rut"));
                dto.setContrasenia(rs.getString("contraseña"));
                return true;
            }
        }catch(SQLException s){
             log.error("Error SQL habilitando trabajador " + s.getMessage());
        }
        return false;
    }
    public String mostrarNombre(TrabajadorDto dto){
        String query="select nombre from trabajador where rut=?";
        try(Connection connection = Conexion.getConexion()){
            PreparedStatement sql=connection.prepareCall(query);
            sql.setString(1,dto.getRut());
            ResultSet rs=sql.executeQuery();
            while(rs.next()){
                dto.setRut(rs.getString("nombre"));
                return dto.getNombre();
            }
        }catch(SQLException s){
             log.error("Error SQL habilitando trabajador " + s.getMessage());
        }
        return "";
    }
   

}
