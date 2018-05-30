package DAO;

import DTO.ServicioDto;

/**
 *
 * @author andres
 */
public interface IServicioDao extends IBaseDao<ServicioDto> {

    public boolean deshabilitar(String obj);
    
    public boolean habilitar(String obj);
    
}
