package qts.locadora.service;

import java.util.Date;

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
	
	public static void main(String[] args) {
		// Cenário
		Cliente cliente = new Cliente("Ádrian");
		Jogo jogo = new Jogo("God of War",40.66, 5);
		
		// Ação
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarJogo(cliente, jogo);
		
		// Verificação
		System.out.println("Jogo da locação é igual ao da instância? -> " + locacao.getJogo().getNome().equals(jogo.getNome()));
		System.out.println("Cliente da locação é igual ao da instância? -> " + locacao.getCliente().getNome().equals(cliente.getNome()));
		System.out.println("Valor da locação é igual ao da instância? -> " + (locacao.getValor()==jogo.getPreco()));
		System.out.println("Data de locaçãoe é igual a data de hoje? -> " + (new DataUtil().verificaDatasIguais(locacao.getRetirada(), new Date())));
	}

}
