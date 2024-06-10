package com.docconcierge.docponto.controller;

import com.docconcierge.docponto.model.BancoHoras;
import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.service.BancoHorasService;
import com.docconcierge.docponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancohoras")
public class BancoHorasController {

    @Autowired
    private BancoHorasService bancoHorasService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<BancoHoras>> obterBancoHorasPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        List<BancoHoras> bancoHoras = bancoHorasService.obterBancoHorasPorUsuario(usuario);
        return ResponseEntity.ok(bancoHoras);
    }
}
