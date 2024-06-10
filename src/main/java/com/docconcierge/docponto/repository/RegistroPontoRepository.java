package com.docconcierge.docponto.repository;

import com.docconcierge.docponto.model.RegistroPonto;
import com.docconcierge.docponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByUsuario(Usuario usuario);
}
