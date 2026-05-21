/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;
import java.util.Date;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DisponibilidadCursoDTO;
import com.mycompany.fitlifegym_dtos.EstadoDTO;
import com.mycompany.fitlifegym_dtos.EstadoInscripcionDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.HorarioDiaSemanaDTO;
import com.mycompany.fitlifegym_dtos.ImagenDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.DisponibilidadCurso;
import com.mycompany.fitlifegym_persistencia.entidades.Estado;
import com.mycompany.fitlifegym_persistencia.entidades.EstadoInscripcion;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia.entidades.HorarioDiaSemana;
import com.mycompany.fitlifegym_persistencia.entidades.Imagen;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class DtosAEntidadesAdapter {

    public static Membresia adaptarMembresia(NuevaMembresiaDTO nuevaMembresiaDTO) {

        TipoMembresia tipoMembresiaDominio = TipoMembresia.BRONCE;

        if (nuevaMembresiaDTO.getTipoMembresia() == TipoMembresiaDTO.PLATA) {
            tipoMembresiaDominio = TipoMembresia.PLATA;
        }else if (nuevaMembresiaDTO.getTipoMembresia() == TipoMembresiaDTO.ORO) {
            tipoMembresiaDominio = TipoMembresia.ORO;
        }

        Membresia membresia = new Membresia(tipoMembresiaDominio, nuevaMembresiaDTO.getPrecio(), nuevaMembresiaDTO.getVigencia());

        return membresia;
    }

    public static MembresiaComprada adaptarMembresiaCompradaDTO(NuevaMembresiaCompradaDTO membresiaCompradaDTO) {

        Membresia membresia = adaptarMembresia(membresiaCompradaDTO.getMembresia());

        Estado estadoDominio = Estado.ACTIVO;

        if (membresiaCompradaDTO.getEstado() == EstadoDTO.INACTIVO) {
            estadoDominio = Estado.INACTIVO;
        }

        MembresiaComprada membresiaComprada = new MembresiaComprada(membresia, membresiaCompradaDTO.getFechaInicio(), membresiaCompradaDTO.getFechaFin(), membresiaCompradaDTO.getPrecioPagado(), estadoDominio);

        return membresiaComprada;
    }

    public static Cliente adaptarClienteDTO(NuevoClienteDTO clienteDTO) {

        MembresiaComprada membresiaComprada = null;

        if (clienteDTO.getMembresiaComprada() != null) {
            membresiaComprada = adaptarMembresiaCompradaDTO(clienteDTO.getMembresiaComprada());
        }

        Cliente clienteNuevo = new Cliente(
                clienteDTO.getNombre(), clienteDTO.getApellidos(), clienteDTO.getCorreo(), clienteDTO.getTelefono(), clienteDTO.getContrasenia(), clienteDTO.getFechaNacimiento(), clienteDTO.getPin(), membresiaComprada);

        return clienteNuevo;
    }

    public static TipoMembresia adaptarTipoMembresia(TipoMembresiaDTO tipoDTO) {

        if (tipoDTO == TipoMembresiaDTO.PLATA) {
            return TipoMembresia.PLATA;
        } else if (tipoDTO == TipoMembresiaDTO.ORO) {
            return TipoMembresia.ORO;
        }

        return TipoMembresia.BRONCE;
    }

    public static TipoMembresiaDTO adaptarTipoMembresiaDTO(TipoMembresia tipo) {

        if (tipo == TipoMembresia.PLATA) {
            return TipoMembresiaDTO.PLATA;
        } else if (tipo == TipoMembresia.ORO) {
            return TipoMembresiaDTO.ORO;
        }

        return TipoMembresiaDTO.BRONCE;
    }

    public static EstadoDTO adaptarEstadoDTO(Estado estado) {

        if (estado == Estado.ACTIVO) {
            return EstadoDTO.ACTIVO;
        }

        return EstadoDTO.INACTIVO;
    }

    public static Curso adaptarCursoDTO(CursoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Curso(dto.getIdCurso(), dto.getNombre(), adaptarImagenDTO(dto.getImagen()), dto.getDescripcion(), dto.getCupoMinimo(),adaptarDisponibilidad(dto.getDisponibilidad()));
    }

    public static CursoDTO adaptarCurso(Curso curso) {
        if (curso == null) {
            return null;
        }
        return new CursoDTO(curso.getIdCurso(),curso.getNombre(), adaptarImagen(curso.getImagen()), curso.getDescripcion(), curso.getCupoMinimo(), adaptarDisponibilidadDTO(curso.getDisponibilidad()));
    }

    public static List<CursoDTO> adaptarListaCursos(List<Curso> cursos) {
        List<CursoDTO> lista = new ArrayList<>();
        if (cursos != null) {
            for (Curso c : cursos) {
                lista.add(adaptarCurso(c));
            }
        }
        return lista;
    }

    public static DisponibilidadCurso adaptarDisponibilidad(DisponibilidadCursoDTO dto) {

        if (dto == null) {
            return DisponibilidadCurso.DISPONIBLE;
        }

        switch (dto) {
            case NO_DISPONIBLE:
                return DisponibilidadCurso.NO_DISPONIBLE;

            case SIN_HORARIOS:
                return DisponibilidadCurso.SIN_HORARIOS;

            default:
                return DisponibilidadCurso.DISPONIBLE;
        }
    }

    public static DisponibilidadCursoDTO adaptarDisponibilidadDTO(DisponibilidadCurso d) {

        if (d == null) {
            return DisponibilidadCursoDTO.DISPONIBLE;
        }

        switch (d) {
            case NO_DISPONIBLE:
                return DisponibilidadCursoDTO.NO_DISPONIBLE;

            case SIN_HORARIOS:
                return DisponibilidadCursoDTO.SIN_HORARIOS;

            default:
                return DisponibilidadCursoDTO.DISPONIBLE;
        }
    }

    public static Horario adaptarHorarioDTO(HorarioDTO dto) {

        if (dto == null){
            return null;
        }

        return new Horario(dto.getIdHorario(), dto.getIdCurso(), adaptarDias(dto.getDias()), dto.getHoraInicio(), dto.getHoraFin(), dto.getCupoMax(), dto.getCupoActual());
    }

    public static HorarioDTO adaptarHorario(Horario h) {

        if (h == null){
            return null;
        }

        return new HorarioDTO(
                h.getIdHorario(),
                h.getIdCurso(),
                adaptarDiasDTO(h.getDias()),
                h.getHoraInicio(),h.getHoraFin(), h.getCupoMax(), h.getCupoActual()
        );
    }

    public static List<HorarioDTO> adaptarListaHorarios(List<Horario> horarios) {

        List<HorarioDTO> lista = new ArrayList<>();

        if (horarios != null) {
            for (Horario h : horarios) {
                lista.add(adaptarHorario(h));
            }
        }

        return lista;
    }

    public static List<HorarioDiaSemana> adaptarDias(List<HorarioDiaSemanaDTO> diasDTO) {

        List<HorarioDiaSemana> dias = new ArrayList<>();

        if (diasDTO != null) {
            for (HorarioDiaSemanaDTO diaDTO : diasDTO) {
                dias.add(HorarioDiaSemana.valueOf(diaDTO.name()));
            }
        }

        return dias;
    }

    public static List<HorarioDiaSemanaDTO> adaptarDiasDTO(List<HorarioDiaSemana> dias) {

        List<HorarioDiaSemanaDTO> diasDTO = new ArrayList<>();

        if (dias != null) {
            for (HorarioDiaSemana dia : dias) {
                diasDTO.add(HorarioDiaSemanaDTO.valueOf(dia.name()));
            }
        }

        return diasDTO;
    }

    public static Inscripcion adaptarInscripcionDTO(InscripcionDTO dto) {

        if (dto == null){
            return null;
        }

        return new Inscripcion(
                dto.getIdInscripcion(),
                dto.getIdCliente(),
                dto.getIdHorario(),
                dto.getFechaRegistro(),
                adaptarEstadoInscripcion(dto.getEstado()));
    }

    public static InscripcionDTO adaptarInscripcion(Inscripcion i) {

        if (i == null){
            return null;
        }

        return new InscripcionDTO(
                i.getIdInscripcion(),
                i.getIdCliente(),
                i.getIdHorario(),
                i.getFechaRegistro(),
                adaptarEstadoInscripcionDTO(i.getEstado()));
    }

    public static List<InscripcionDTO> adaptarListaInscripciones(List<Inscripcion> ins) {

        List<InscripcionDTO> lista = new ArrayList<>();

        if (ins != null) {
            for (Inscripcion i : ins) {
                lista.add(adaptarInscripcion(i));
            }
        }

        return lista;
    }

    public static EstadoInscripcion adaptarEstadoInscripcion(EstadoInscripcionDTO dto) {
        if (dto == null) {
            return EstadoInscripcion.NO_INSCRITO;
        }

        return EstadoInscripcion.valueOf(dto.name());
    }

    public static EstadoInscripcionDTO adaptarEstadoInscripcionDTO(EstadoInscripcion e) {
        if (e == null) {
            return EstadoInscripcionDTO.NO_INSCRITO;
        }

        return EstadoInscripcionDTO.valueOf(e.name());
    }
    
    public static NuevoClienteDTO adaptarCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new NuevoClienteDTO(cliente.getNombre(),cliente.getApellidos(),cliente.getCorreo(),cliente.getTelefono(),cliente.getContrasenia(),cliente.getFechaNacimiento(),cliente.getPin(),null);
    }
    
    public static List<NuevoClienteDTO> adaptarListaClientes(List<Cliente> clientes) {
        List<NuevoClienteDTO> lista = new ArrayList<>();
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                lista.add(adaptarCliente(cliente));
            }
        }

        return lista;
    }
    
    public static ClienteLogueadoDTO adaptarClienteLogueado(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        TipoMembresiaDTO tipoDTO = null;

        EstadoDTO estadoDTO = null;

        if (cliente.getMembresiaComprada() != null) {
            tipoDTO = adaptarTipoMembresiaDTO(cliente.getMembresiaComprada().getMembresia().getTipoMembresia());

            estadoDTO = adaptarEstadoDTO(cliente.getMembresiaComprada().getEstado());
        }

        return new ClienteLogueadoDTO(
            cliente.getIdCliente(), cliente.getNombre() + " " + cliente.getApellidos(),tipoDTO,estadoDTO);
        }
    
    public static Imagen adaptarImagenDTO(ImagenDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Imagen(dto.getRuta());
    }

    public static ImagenDTO adaptarImagen(Imagen imagen) {
        if (imagen == null) {
            return null;
        }

        return new ImagenDTO(imagen.getRuta());
    }
    
    

}
