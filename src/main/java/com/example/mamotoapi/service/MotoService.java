package com.example.mamotoapi.service;

import com.example.mamotoapi.model.Moto;
import com.example.mamotoapi.model.StatusMoto;
import com.example.mamotoapi.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MotoService {

    private final MotoRepository;

    public MotoService(MotoRepository motoRepository){
        this.motoRepository = motoRepository;
    }

    public List <MotoService(MotoRepository motoRepository){
        this.motoRepository = motoRepository;
    }

    public List<Moto> listarDisponivels(){
        return motoRepository.findByStatus(StatusMoto.DISPONIVEL);
    }

    public Moto buscarPorId(Long id){
        return motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
    }

    public Moto cadastrar (Moto moto){
        if (moto.getStatus() == null ){
            moto.setStatus(StatusMoto.DISPONIVEL);
        }
        return motoRepository.save(moto);
    }
    public Moto atualizar(Long id, Moto dadosAtualizados) {
        Moto moto = buscarPorId(id);

        moto.setNome(dadosAtualizados.getNome());
        moto.setMarca(dadosAtualizados.getMarca());
        moto.setModelo(dadosAtualizados.getModelo());
        moto.setAno(dadosAtualizados.getAno());
        moto.setCilindrada(dadosAtualizados.getCilindrada());
        moto.setQuilometragem(dadosAtualizados.getQuilometragem());
        moto.setCor(dadosAtualizados.getCor());
        moto.setDescricao(dadosAtualizados.getDescricao());
        moto.setImagemUrl(dadosAtualizados.getImagemUrl());
        moto.setStatus(dadosAtualizados.getStatus());

        return motoRepository.save(moto);
    }
    public void remover(Long id) {
        Moto moto = buscarPorId(id);
        motoRepository.delete(moto);
    }

    public Moto marcarComoVendida(Long id) {
        Moto moto = buscarPorId(id);
        moto.setStatus(StatusMoto.VENDIDA);
        return motoRepository.save(moto);
    }

}
