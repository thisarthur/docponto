package com.docconcierge.docponto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BancoHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate data;

    private Integer saldo; // Saldo em minutos, para facilitar cálculos de horas extras ou faltantes

    // Construtores, getters e setters
    public BancoHoras() {
    }

    public BancoHoras(Usuario usuario, LocalDate data, Integer saldo) {
        this.usuario = usuario;
        this.data = data;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
