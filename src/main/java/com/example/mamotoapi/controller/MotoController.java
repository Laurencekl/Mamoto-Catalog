package com.example.mamotoapi.controller;

import com.example.mamotoapi.model.Moto;
import com.example.mamotoapi.service.MotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@CrossOrigin(origins = "*")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public List<Moto> listarTodas() {
        return motoService.listarTodas();
    }

    @GetMapping("/disponiveis")
    public List<Moto> listarDisponiveis() {
        return motoService.listarDisponiveis();
    }

    @GetMapping("/{id}")
    public Moto buscarPorId(@PathVariable Long id) {
        return motoService.buscarPorId(id);
    }

    @PostMapping
    public Moto cadastrar(@RequestBody Moto moto) {
        return motoService.cadastrar(moto);
    }

    @PutMapping("/{id}")
    public Moto atualizar(@PathVariable Long id, @RequestBody Moto moto) {
        return motoService.atualizar(id, moto);
    }

    @PatchMapping("/{id}/vendida")
    public Moto marcarComoVendida(@PathVariable Long id) {
        return motoService.marcarComoVendida(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        motoService.remover(id);
    }
}