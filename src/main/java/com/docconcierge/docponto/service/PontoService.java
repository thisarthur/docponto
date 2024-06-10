package com.docconcierge.docponto.service;

import com.docconcierge.docponto.model.RegistroPonto;
import com.docconcierge.docponto.model.TipoPonto;
import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    public void registrarPonto(Usuario usuario, TipoPonto tipo) {
        RegistroPonto registro = new RegistroPonto();
        registro.setUsuario(usuario);
        registro.setData(LocalDate.now());
        registro.setHorario(LocalTime.now());
        registro.setTipo(tipo);
        registroPontoRepository.save(registro);
    }

    public List<RegistroPonto> obterRegistrosPorUsuario(Usuario usuario) {
        return registroPontoRepository.findByUsuario(usuario);
    }
}
