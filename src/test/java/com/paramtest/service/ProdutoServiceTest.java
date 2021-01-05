package com.paramtest.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.paramtest.domain.Produto;

@RunWith(Parameterized.class)
public class ProdutoServiceTest {
	
	@Rule
	public ErrorCollector ec = new ErrorCollector(); 
	
	private static ProdutoService service;
	
	@Parameter
	public List<Produto> produtos;
	
	@Parameter(value = 1)
	public Double valorTotal;
	
	@Parameter(value = 2)
	public String descricaoCaso;
	
	
	@Before
	public void init() {
		service = new ProdutoService();
	}
	
	@Parameters(name = "Caso {index}: {2}")
	public static List<Object[]> getProdutos() {
		List<Object[]> produtos = Arrays.asList(new Object[][] {
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d)), 15d, "2 PRODUTOS"},
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d)), 30d, "3 PRODUTOS" },
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d), new Produto("apagador", 5d)), 28d, "4 PRODUTOS" },
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d), new Produto("apagador", 5d), new Produto("marcador de texto", 5d)), 32d, "5 PRODUTOS" }
		});
		
		return produtos;
	}
	
	@Test
	public void deve_dar_desconto_quando_for_mais_de_tres_produtos() {
		//CENARIO
		
		//ACAO
		Double total = service.calcularTotal(produtos);
		
		//VERIFICACAO
		ec.checkThat(total, is(equalTo(valorTotal)));
	}
}
