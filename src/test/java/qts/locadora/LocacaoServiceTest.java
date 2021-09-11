package qts.locadora;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import qts.locadora.model.Cliente;
import qts.locadora.model.Jogo;
import qts.locadora.model.Locacao;
import qts.locadora.service.LocacaoService;
import qts.locadora.util.DataUtil;

public class LocacaoServiceTest {
	
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
