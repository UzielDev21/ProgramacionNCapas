package com.Uziel.UCastanedaProgramacionNCapas.DAO;

import com.Uziel.UCastanedaProgramacionNCapas.JPA.DireccionJPA;
import com.Uziel.UCastanedaProgramacionNCapas.JPA.ColoniaJPA;
import com.Uziel.UCastanedaProgramacionNCapas.JPA.RolJPA;
import com.Uziel.UCastanedaProgramacionNCapas.JPA.UsuarioJPA;
import com.Uziel.UCastanedaProgramacionNCapas.ML.Direccion;
import com.Uziel.UCastanedaProgramacionNCapas.ML.Result;
import com.Uziel.UCastanedaProgramacionNCapas.ML.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioJPADAOImplementation implements IUsuarioJPA {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Result GetAllJPA() {
        Result result = new Result();

        try {
            TypedQuery<UsuarioJPA> queryUsuario = entityManager.createQuery("FROM UsuarioJPA", UsuarioJPA.class);
            List<UsuarioJPA> usuariosJPA = queryUsuario.getResultList();

            List<Usuario> usuarios = usuariosJPA.stream().map(usuarioJPA -> modelMapper.map(usuarioJPA, Usuario.class)).collect(Collectors.toList());

            result.objects = (List<Object>) (List<?>) usuarios;
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Override
    public Result GetByIdJPA(int IdUsuario) {
        Result result = new Result();

        try {
            
            UsuarioJPA usuarioJPA = entityManager.find(UsuarioJPA.class, IdUsuario);
            
            Usuario usuario = modelMapper.map(usuarioJPA, Usuario.class);
            RolJPA rolJPA = usuarioJPA.getRolJPA();
            
            result.object = usuario;
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    @Transactional
    public Result UpdateJPA(Usuario usuario) {
        Result result = new Result();

        try {
            UsuarioJPA usuarioBase = entityManager.find(UsuarioJPA.class, usuario.getIdUsuario());

            UsuarioJPA usuarioJPA = modelMapper.map(usuario, UsuarioJPA.class);

            usuarioJPA.setPassword(usuarioBase.getPassword());
            usuarioJPA.setImagen(usuarioBase.getImagen());
            usuarioJPA.setDireccionesJPA(usuarioBase.getDireccionesJPA());

            RolJPA rolJPA = modelMapper.map(usuario.Rol, RolJPA.class);
            usuarioJPA.RolJPA = rolJPA;

            entityManager.merge(usuarioJPA);

            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    @Transactional
    public Result AddJPA(Usuario usuario) {
        Result result = new Result();

        try {
            UsuarioJPA usuarioJPA = modelMapper.map(usuario, UsuarioJPA.class);

            RolJPA rolJPA = modelMapper.map(usuario.Rol, RolJPA.class);
            usuarioJPA.RolJPA = rolJPA;

            List<Direccion> direcciones = usuario.Direcciones;
            usuarioJPA.DireccionesJPA = direcciones.stream().map(direccion -> modelMapper.map(direccion, DireccionJPA.class)).collect(Collectors.toList());
            usuarioJPA.DireccionesJPA.get(0).UsuarioJPA = usuarioJPA;

            ColoniaJPA coloniaJPA = modelMapper.map(usuario.Direcciones.get(0).Colonia, ColoniaJPA.class);
            usuarioJPA.DireccionesJPA.get(0).ColoniaJPA = coloniaJPA;

            entityManager.persist(usuarioJPA);

            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    public Result BuscarUsuarioJPA(Usuario usuario) {
        Result result = new Result();
        
        try {
            String queryValidar = "FROM UsuarioJPA usuarioJPA";
            boolean filtro = false;
            
            if (usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
                if (!filtro) {
                    queryValidar = queryValidar + " WHERE usuarioJPA.Nombre LIKE :nombre".toLowerCase();
                    filtro = true;
                }else{
                    queryValidar = queryValidar + " AND usuarioJPA.Nombre LIKE :nombre".toLowerCase();
                }
            }
            
            if (usuario.getApellidoPaterno() != null && !usuario.getApellidoPaterno().isEmpty()) {
                if (!filtro) {
                    queryValidar = queryValidar + " WHERE usuarioJPA.ApellidoPaterno LIKE :apellidoPaterno".toLowerCase();
                    filtro = true;
                } else {
                    queryValidar = queryValidar + " AND usuarioJPA.ApellidoPaterno LIKE :apellidoPaterno".toLowerCase();
                }
            }
            
            if (usuario.getApellidoMaterno() != null && !usuario.getApellidoMaterno().isEmpty()) {
                if (!filtro) {
                    queryValidar = queryValidar + " WHERE usuarioJPA.ApellidoMaterno LIKE :apellidoMaterno".toLowerCase();
                    filtro = true;
                } else {
                    queryValidar = queryValidar + " AND usuarioJPA.ApellidoMaterno LIKE :apellidoMaterno".toLowerCase();
                }
            }
            
            if (usuario.Rol != null && usuario.Rol.getIdRol() > 0) {
                if (!filtro) {
                    queryValidar = queryValidar + " WHERE usuarioJPA.RolJPA.IdRol = :idRol";
                    filtro = true;
                } else {
                    queryValidar = queryValidar + " AND usuarioJPA.RolJPA.IdRol = :idRol";
                }
            }
            
            TypedQuery<UsuarioJPA> queryBuscar = entityManager.createQuery(queryValidar, UsuarioJPA.class);
            
            if (usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
                queryBuscar.setParameter("nombre", "%" + usuario.getNombre() + "%");
            }
            
        } catch (Exception ex) {
            
        }
        
        
        return result;
    }
    

}
