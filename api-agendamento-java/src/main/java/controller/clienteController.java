package controller;

import model.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.clienteRepository;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class clienteController {

    @Autowired
    private clienteRepository clienteRepository;

    @GetMapping(params = "status")
    public List<cliente> buscarClientePorStatus(@RequestParam("status") String status) {
        return clienteRepository.findById(status);
     }
    @PostMapping
    public Long criarCliente(@RequestBody cliente cliente) {
        cliente.setStatus("pending");
        clienteRepository.save(cliente);
        return cliente.getId();
    }
    @PutMapping("/{id}")
    public cliente updateCliente(@PathVariable Long id, @RequestBody cliente cliente){
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removerCliente(@PathVariable long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}