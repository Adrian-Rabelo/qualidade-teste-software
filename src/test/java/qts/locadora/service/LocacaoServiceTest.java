package qts.locadora.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import qts.locadora.exceptions.JogoSemEstoqueException;
import qts.locadora.exceptions.LocacaoValorNuloException;
import qts.locadora.model.Cliente;
import qts.locadora.model.Jogo;
import qts.locadora.model.Locacao;
import qts.locadora.util.DataUtil;

public class LocacaoServiceTest {

	@Test
	public void teste() throws Exception {

		// Cenário
		Cliente cliente = new Cliente("Ádrian");
		Jogo jogo = new Jogo("God of War",40.66, 5);

		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
		// Ação
		locacao = locacaoService.alugarJogo(cliente, jogo);

		// Verificação

		Assert.assertTrue(("Erro no jogo seleionado para locação"),locacao.getJogo().getNome().equals(jogo.getNome()));
		Assert.assertTrue(("Erro nos dados do cliente"), locacao.getCliente().getNome().equals(cliente.getNome()));
		Assert.assertTrue(("Erro no valor da locação"), (locacao.getValor()==jogo.getPreco()));
		Assert.assertTrue(("Erro na data ad locação"), (new DataUtil().verificaDatasIguais(locacao.getRetirada(), new Date())));


	}

	@Test(expected = JogoSemEstoqueException.class)
	public void testeSemEstoque() throws Exception {

		// Cenário
		Cliente cliente = new Cliente("Ádrian");
		Jogo jogo = new Jogo("God of War",40.66, 0);
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;

		// Ação
		locacao = locacaoService.alugarJogo(cliente, jogo);

	}


	@Test
	public void testeValoresNulo() throws Exception {

		// Cenário
		Cliente cliente = new Cliente("Ádrian");
		Jogo jogo = new Jogo("God of War",40.66, 3);
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
		
		// Ação
		locacao = locacaoService.alugarJogo(cliente, null);

	}
}


