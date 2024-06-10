package com.docconcierge.docponto.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String cargo;
    private String descricaoHorario;
    private String senha;
    private String departamento;
    private String gestorResponsavel;
    private Integer cargaHoraria;


    public Usuario() {}

    public Usuario(String nome, String cpf, LocalDate dataNascimento, String email, LocalDate dataAdmissao,
                   LocalDate dataDemissao, String cargo, String descricaoHorario, String senha,
                   String departamento, String gestorResponsavel, int cargaHoraria) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.cargo = cargo;
        this.descricaoHorario = descricaoHorario;
        this.senha = senha;
        this.departamento = departamento;
        this.gestorResponsavel = gestorResponsavel;
        this.cargaHoraria = cargaHoraria;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricaoHorario() {
        return descricaoHorario;
    }

    public void setDescricaoHorario(String descricaoHorario) {
        this.descricaoHorario = descricaoHorario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getGestorResponsavel() {
        return gestorResponsavel;
    }

    public void setGestorResponsavel(String gestorResponsavel) {
        this.gestorResponsavel = gestorResponsavel;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


}
