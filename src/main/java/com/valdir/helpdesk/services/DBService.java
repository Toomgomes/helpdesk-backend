package com.valdir.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.helpdesk.domain.Chamado;
import com.valdir.helpdesk.domain.Cliente;
import com.valdir.helpdesk.domain.Tecnico;
import com.valdir.helpdesk.domain.enums.Perfil;
import com.valdir.helpdesk.domain.enums.Prioridade;
import com.valdir.helpdesk.domain.enums.Status;
import com.valdir.helpdesk.repositories.ChamadoRepository;
import com.valdir.helpdesk.repositories.ClienteRepository;
import com.valdir.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "12345678901", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Thomas Gomes", "13345678903", "thomas@mail.com", "123");
		tec2.addPerfil(Perfil.ADMIN);
		Tecnico tec3 = new Tecnico(null, "Thiago Gomes", "13745878903", "thiago@mail.com", "123");
		Tecnico tec4 = new Tecnico(null, "Gutemberg Assis", "10344678903", "gutem@mail.com", "123");
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "01234567890", "torvalds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Jhon Deep", "01534597890", "jdeep@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Jalcione Silva", "01534091890", "jalci@mail.com", "123");
		Cliente cli4 = new Cliente(null, "Lilian Beatriz", "01534099899", "lilian@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 03", "Terceiro chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 04", "Quarto chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 05", "Quinto chamado", tec2, cli1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));		
		
	}

}
