package com.docconcierge.docponto.repository;

import com.docconcierge.docponto.model.BancoHoras;
import com.docconcierge.docponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
    List<BancoHoras> findByUsuario(Usuario usuario);
}
