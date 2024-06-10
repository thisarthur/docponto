package com.docconcierge.docponto;

import com.docconcierge.docponto.model.TipoPonto;
import com.docconcierge.docponto.model.Usuario;
import com.docconcierge.docponto.service.PontoService;
import com.docconcierge.docponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class DocPontoApplication {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PontoService pontoService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DocPontoApplication.class, args);
	}

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Criação de usuários ou obtenção de usuários existentes
		Usuario usuario1 = usuarioService.findByEmail("joao@example.com");
		if (usuario1 == null) {
			usuario1 = new Usuario("João Silva", "12345678900", LocalDate.of(1985, 4, 10), "joao@example.com", LocalDate.of(2020, 1, 15), null, "Desenvolvedor", "09:00 - 18:00", passwordEncoder.encode("senha123"), "TI", "Maria Souza", 40);
			usuario1 = usuarioService.criarUsuario(usuario1);
		}

		Usuario usuario2 = usuarioService.findByEmail("ana@example.com");
		if (usuario2 == null) {
			usuario2 = new Usuario("Ana Pereira", "09876543211", LocalDate.of(1989, 8, 25), "ana@example.com", LocalDate.of(2019, 3, 10), null, "Analista", "08:00 - 17:00", passwordEncoder.encode("senha123"), "TI", "Joaozin", 40);
			usuario2 = usuarioService.criarUsuario(usuario2);
		}

		Usuario us3 = usuarioService.findByEmail("ragnar@gmail.com");
		if (us3 == null) {
			us3 = new Usuario("Ragnar Notebook", "38332225817", LocalDate.of(1991, 8, 12), "ragnar@gmail.com", LocalDate.of(2024, 6, 3), null, "Analista Sr", "08:00 - 16:00", passwordEncoder.encode("Doc2024"), "TI", "Arthur", 44);
			us3 = usuarioService.criarUsuario(us3);
		}

		// Registro de pontos para os usuários
		registrarPontosParaUsuario(usuario1);
		registrarPontosParaUsuario(usuario2);
		registrarPontosParaUsuario(us3);
	}

	private void registrarPontosParaUsuario(Usuario usuario) {
		pontoService.registrarPonto(usuario, TipoPonto.ENTRADA);
		pontoService.registrarPonto(usuario, TipoPonto.SAIDA_ALMOCO);
		pontoService.registrarPonto(usuario, TipoPonto.VOLTA_ALMOCO);
		pontoService.registrarPonto(usuario, TipoPonto.SAIDA);
	}
}
