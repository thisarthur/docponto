package com.docconcierge.docponto.service;

import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia");
        }
        // Codificar a senha antes de salvar o usuário
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioDetalhes) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuario.setNome(usuarioDetalhes.getNome());
        usuario.setCpf(usuarioDetalhes.getCpf());
        usuario.setDataNascimento(usuarioDetalhes.getDataNascimento());
        usuario.setEmail(usuarioDetalhes.getEmail());
        usuario.setDataAdmissao(usuarioDetalhes.getDataAdmissao());
        usuario.setDataDemissao(usuarioDetalhes.getDataDemissao());
        usuario.setCargo(usuarioDetalhes.getCargo());
        usuario.setDescricaoHorario(usuarioDetalhes.getDescricaoHorario());
        usuario.setSenha(passwordEncoder.encode(usuarioDetalhes.getSenha()));
        usuario.setDepartamento(usuarioDetalhes.getDepartamento());
        usuario.setGestorResponsavel(usuarioDetalhes.getGestorResponsavel());
        usuario.setCargaHoraria(usuarioDetalhes.getCargaHoraria());

        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }
}
