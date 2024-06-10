package com.docconcierge.docponto.service;

import com.docconcierge.docponto.model.BancoHoras;
import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    public List<BancoHoras> obterBancoHorasPorUsuario(Usuario usuario) {
        return bancoHorasRepository.findByUsuario(usuario);
    }
}
