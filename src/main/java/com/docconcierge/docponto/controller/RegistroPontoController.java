package com.docconcierge.docponto.controller;

import com.docconcierge.docponto.model.RegistroPonto;
import com.docconcierge.docponto.model.TipoPonto;
import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.service.PontoService;
import com.docconcierge.docponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registroponto")
public class RegistroPontoController {

    @Autowired
    private PontoService pontoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{usuarioId}/registrar")
    public ResponseEntity<RegistroPonto> registrarPonto(@PathVariable Long usuarioId, @RequestParam TipoPonto tipo) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        pontoService.registrarPonto(usuario, tipo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<RegistroPonto>> obterRegistrosPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        List<RegistroPonto> registrosPonto = pontoService.obterRegistrosPorUsuario(usuario);
        return ResponseEntity.ok(registrosPonto);
    }
}
