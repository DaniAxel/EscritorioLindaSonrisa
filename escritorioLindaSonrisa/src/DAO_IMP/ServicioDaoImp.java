package DAO_IMP;

import DAO.IServicioDao;
import DTO.ServicioDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import BBDD.Conexion;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class ServicioDaoImp implements IServicioDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean deshabilitar(String obj) {
        String query = "UPDATE servicio SET habilitado=0 WHERE nombre=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj);
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL deshabilitando servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al deshabilitando servicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<ServicioDto> listar() {
        String query = "SELECT * FROM servicio ";
        List<ServicioDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ServicioDto obj = new ServicioDto();
                obj.setNombre(result.getString("nombre"));
                obj.setDescripcion(result.getString("descripcion"));
                obj.setPrecio(result.getInt("precio"));
                obj.setHabilitado(result.getBoolean("habilitado"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL listando todos servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listando todos servicio " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean agregar(ServicioDto obj) {
        String query = "INSERT INTO servicio(nombre,descripcion,precio,habilitado) VALUES(?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getNombre());
            sql.setString(2, obj.getDescripcion());
            sql.setInt(3, obj.getPrecio());
            sql.setBoolean(4, obj.isHabilitado());
            if (sql.execute()) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL agregando servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar servicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(ServicioDto obj) {
        String query = "UPDATE servicio SET nombre=?,descripcion=?,precio=?,habilitado? WHERE id_servicio=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getNombre());
            sql.setString(2, obj.getDescripcion());
            sql.setInt(3, obj.getPrecio());
            sql.setBoolean(4, obj.isHabilitado());
            sql.setInt(5, obj.getIdServicio());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL modificando servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificando servicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public ServicioDto buscar(ServicioDto obj) {
        String query = "SELECT * FROM servicio WHERE id_servicio=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                obj.setNombre(result.getString("nombre"));
                obj.setDescripcion(result.getString("descripcion"));
                obj.setPrecio(result.getInt("precio"));
                obj.setHabilitado(result.getBoolean("habilitado"));
                return obj;
            }
        } catch (SQLException s) {
            log.error("Error SQL buscando servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscando servicio " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean habilitar(String obj) {
        String query = "UPDATE servicio SET habilitado=1 WHERE nombre=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj);
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL habilitando servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al habilitando servicio " + e.getMessage());
        }
        return false;
    }

    public ArrayList<String> listarNombres() {
        String query = "SELECT * FROM servicio ";
        ArrayList<String> list = new ArrayList<String>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                list.add(result.getString("nombre"));
                
            }
        } catch (SQLException s) {
            log.error("Error SQL listando todos servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listando todos servicio " + e.getMessage());
        }
        return list;

    }

    public boolean eliminar(String nombre) {
        String query = "delete from servicio where nombre=?";
        try (Connection conexion = Conexion.getConexion()) {

            PreparedStatement sql = conexion.prepareCall(query);
            sql.setString(1, nombre);
            if (sql.executeUpdate() > 0) {
                conexion.close();
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error SQL Eliminando todos servicio " + ex.getMessage());

        } catch (Exception e) {
            log.error("Error SQL Eliminar todos servicio " + e.getMessage());

        }
        return false;
    }

}
