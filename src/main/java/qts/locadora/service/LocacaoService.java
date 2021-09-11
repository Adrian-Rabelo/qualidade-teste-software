package qts.locadora.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import qts.locadora.model.Cliente;
import qts.locadora.model.Jogo;
import qts.locadora.model.Locacao;
import qts.locadora.util.DataUtil;

public class LocacaoService {
	
	private final int DIAS_PADRAO = 5;
	
	public Locacao alugarJogo(Cliente cliente, Jogo jogo) {
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setJogo(jogo);
		
		locacao.setValor(jogo.getPreco());
		locacao.setRetirada(new Date());
		
		Date devolucao = new DataUtil().addDias(new Date(), DIAS_PADRAO);
		locacao.setDevolucao(devolucao);
		
		return locacao;
	}
	
	@Test
	public void teste() {

		// Cenário
		Cliente cliente = new Cliente("Ádrian");
		Jogo jogo = new Jogo("God of War",40.66, 5);
		
		// Ação
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarJogo(cliente, jogo);
		
		// Verificação
		Assert.assertTrue(("Erro no jogo seleionado para locação"),locacao.getJogo().getNome().equals(jogo.getNome()));
		Assert.assertTrue(("Erro nos dados do cliente"), locacao.getCliente().getNome().equals(cliente.getNome()));
		Assert.assertTrue(("Erro no valor da locação"), (locacao.getValor()==jogo.getPreco()));
		Assert.assertTrue(("Erro na data ad locação"), (new DataUtil().verificaDatasIguais(locacao.getRetirada(), new Date())));
		
	}

}
