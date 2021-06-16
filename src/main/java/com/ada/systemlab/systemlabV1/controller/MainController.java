package com.ada.systemlab.systemlabV1.controller;


import com.ada.systemlab.systemlabV1.model.*;
import com.ada.systemlab.systemlabV1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping (path = "/systemlab/ada/v1")
public class MainController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EstudiosRepository estudiosRepository;

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    //***** read ******

    @GetMapping(path = "/pacientes/all")
    public @ResponseBody
    Iterable<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping(path = "/estudios/all")
    public @ResponseBody
    Iterable<Estudios> getAllEstudios() {
        return estudiosRepository.findAll();
    }

    @GetMapping(path = "/protocolos/all")
    public @ResponseBody
    Iterable<Protocolo> getAllProtocolos() {
        return protocoloRepository.findAll();
    }

    @GetMapping(path = "/resultados/all")
    public @ResponseBody
    Iterable<Resultado> getAllResultados() {
        return resultadoRepository.findAll();
    }

    @GetMapping(path = "/encuestas/all")
    public @ResponseBody
    Iterable<Encuesta> getAllEncuestas() {
        return encuestaRepository.findAll();
    }

    @GetMapping(path = "/user/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping (path = "/user/{id}")
    public @ResponseBody
    Optional <User> getUserById (@PathVariable ("id") int id){
        return userRepository.findById(id);
    }

    @GetMapping(path = "/role/all")
    public @ResponseBody
    Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping (path = "/role/{id}")
    public @ResponseBody
    Optional<Role> getRoleById (@PathVariable ("id") int id) {
        return roleRepository.findById(id);
    }
    @GetMapping(path = "/resource/all")
    public @ResponseBody
    Iterable<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @GetMapping (path = "/resource/{id}")
    public @ResponseBody
    Optional<Resource> getResourceById (@PathVariable ("id") int id) {
        return resourceRepository.findById(id);
    }

    @GetMapping(path = "role/all/user/{userId}")
    public @ResponseBody
    Collection<Role> getAllRolesByUserId(@PathVariable("userId") String userId) {
        return roleRepository.getRolesByUser(userId);
    }

    @GetMapping(path = "/resource/all/role/{roleId}")
    public @ResponseBody
    Collection<Resource> getResourceByRoles(@PathVariable ("roleId") String roleId) {
        return resourceRepository.getResourceByRole(roleId);
    }



    //******** consultas personalizadas **********

    //etMapping(path = "/paciente/obra_social/like/{obra_social}")
    //public @ResponseBody
    //Iterable<Paciente> getPacienteByInst(@PathVariable("obra_social") String obra_social) {
    //return pacienteRepository.getPacienteObraSocialLike(obra_social);
    //}

    @GetMapping(path = "/paciente/obra_social/like/{obra_social}")
    public @ResponseBody
    ResponseEntity<PacientesResponse> getPacienteByInst(@PathVariable("obra_social") String obra_social) {
        PacientesResponse response = new PacientesResponse();
        try {
            response.setPaciente(pacienteRepository.getPacienteObraSocialLike(obra_social));
            Paciente paciente = (Paciente) Arrays.stream(pacienteRepository.getPacienteObraSocialLike(obra_social).toArray()).findFirst().get();
            response.setMessage("ok");
            return ResponseEntity.ok(response);
        } catch (Exception e) {

            response.setMessage("No hay pacientes ingresados con esa obra social" + "-----" + e.getMessage());
            return ResponseEntity.badRequest().body(response);

        }
    }

    //@GetMapping(path = "/paciente/nrodocumento/like/{nrodocumento}")
    // public @ResponseBody
    //Iterable<Paciente> getPacienteNroDoc(@PathVariable("nrodocumento") Integer nrodocumento) {
    //    return pacienteRepository.getPacienteDNILike(nrodocumento);
    //}

    @GetMapping(path = "/paciente/nrodocumento/like/{nrodocumento}")
    public @ResponseBody
    ResponseEntity<PacientesResponse> getPacienteByDNI(@PathVariable("nrodocumento") Integer nrodocumento) {
        PacientesResponse response = new PacientesResponse();
        try {
            response.setPaciente(pacienteRepository.getPacienteDNILike(nrodocumento));
            Paciente paciente = (Paciente) Arrays.stream(pacienteRepository.getPacienteDNILike(nrodocumento).toArray()).findFirst().get();
            response.setMessage("ok");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("no existe paciente con ese DNI" + "---" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/protocolos/like/{fecha_de_resultados}")
    public @ResponseBody
    Iterable<Protocolo> getProtocoloPorFechaEntrega(@PathVariable("fecha_de_resultados")  String  fecha_de_resultados) {
        return protocoloRepository.getProtocoloPorFechaDeResultados(fecha_de_resultados);
    }


     @GetMapping (path = "/estudios/{fecha_ingreso}/like/{nombre}")
     public @ResponseBody
    Collection<Estudios> traerEstudioPorFecha (@PathVariable("fecha_ingreso") String fecha_ingreso, @PathVariable("nombre") String id_nombre){
        return estudiosRepository.getEstudioporFechaIngreso(id_nombre,fecha_ingreso);
    }

    //***** create ******

    @PostMapping (path = "/pacientes/create", consumes = "application/json", produces = "application/json")
    public Paciente createPaciente (@RequestBody Paciente newpaciente){
        return pacienteRepository.save(newpaciente);
    }

    @PostMapping (path = "/estudios/create", consumes = "application/json", produces = "application/json")
    public Estudios createEstudios (@RequestBody Estudios newestudio){
        return estudiosRepository.save(newestudio);
    }

    @PostMapping (path = "/protocolo/create", consumes = "application/json", produces = "application/json")
    public Protocolo createProtocolo (@RequestBody Protocolo newprotocolo){
        return protocoloRepository.save(newprotocolo);
    }

    // ****** update ********

    @PutMapping(path = "/pacientes/update")
    public Paciente updatePaciente(@RequestBody Paciente newpaciente) {
        return pacienteRepository.save(newpaciente);
    }

    @PutMapping(path = "/estudios/update")
    public Estudios updateEstudio(@RequestBody Estudios newestudio) {
        return estudiosRepository.save(newestudio);
    }

    @PutMapping(path = "/protocolos/update")
    public Protocolo updateProtocolo(@RequestBody Protocolo newprotocolo) {
        return protocoloRepository.save(newprotocolo);
    }

    @PutMapping(path = "/resultados/update")
    public Resultado updateResultado(@RequestBody Resultado newresultado) {
        return resultadoRepository.save(newresultado);
    }

    @PutMapping(path = "/encuestas/update")
    public Encuesta updateEncuesta(@RequestBody Encuesta newencuesta) {
        return encuestaRepository.save(newencuesta);
    }

    //******* delete *********

    //@DeleteMapping(path = "pacientes/delete/{id_paciente}")
    //public @ResponseBody
    //Iterable<Paciente> deletePacienteById(@PathVariable("id_paciente") int id_paciente) {
      //  pacienteRepository.deleteById(id_paciente);
      //  return pacienteRepository.findAll();
    //}

    @DeleteMapping(path = "user/{id_user}/pacientes/delete/{id_paciente}")
    public @ResponseBody
    ResponseEntity <GeneralResponse>deletePacientesByUser (@PathVariable("id_user") String id_user,@PathVariable("id_paciente") int id_paciente) {

        GeneralResponse response = new GeneralResponse();

        Collection<Role> rolesByUser = roleRepository.getRolesByUser(id_user);

        for (Role role:rolesByUser) {
            if (role.getNombre().equals("direccion")) {
                pacienteRepository.deleteById(id_paciente);
                response.setCode(HttpStatus.OK.value());
                response.setMessage("El paciente fue eliminado, id:" + id_paciente);
               return ResponseEntity.ok(response);
            }
        }
        response.setCode(401);
        response.setMessage("Usuario no autorizado para borrar registros");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "estudios/delete/{id_estudio}")
    public @ResponseBody
    Iterable<Estudios> deleteEstudioById(@PathVariable("id_estudio") int id_estudio) {
        estudiosRepository.deleteById(id_estudio);
        return estudiosRepository.findAll();
    }
    @DeleteMapping(path = "protocolos/delete/{id}")
    public @ResponseBody
    Iterable<Protocolo> deleteProtocoloById(@PathVariable("id") int id) {
        protocoloRepository.deleteById(id);
        return protocoloRepository.findAll();
    }
    @DeleteMapping(path = "resultados/delete/{id_resultado}")
    public @ResponseBody
    Iterable<Resultado> deleteResultadoById(@PathVariable("id_resultado") int id_resultado) {
        resultadoRepository.deleteById(id_resultado);
        return resultadoRepository.findAll();
    }
    @DeleteMapping(path = "encuestas/delete/{id_encuesta}")
    public @ResponseBody
    Iterable<Encuesta> deleteEncuestaById(@PathVariable("id_encuesta") int id_encuesta) {
        encuestaRepository.deleteById(id_encuesta);
        return encuestaRepository.findAll();
    }
}
