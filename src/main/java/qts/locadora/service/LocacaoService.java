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
	
}
