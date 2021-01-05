package com.paramtest.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.paramtest.domain.Produto;

@RunWith(Parameterized.class)
public class ProdutoServiceTest {
	public static ProdutoService service;
	
	@Parameter
	public static List<Produto> produtos;
	
	@Parameter(value = 1)
	public static Double valorTotal;
	
	@Before
	public void init() {
		service = new ProdutoService();
	}
	
	@Parameters
	public List<Object[]> getProdutos() {
		List<Object[]> produtos = Arrays.asList(new Object[][] {
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d)), 15d },
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d)), 25d },
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d), new Produto("apagador", 5d)), 30d },
			{ Arrays.asList(new Produto("caneta", 5d), new Produto("pasta", 10d), new Produto("lapiseira", 15d), new Produto("apagador", 5d), new Produto("marcador de texto", 5d)), 30d }
		});
		
		return produtos;
	}
	
	@Test
	public void deve_dar_desconto_quando_for_mais_de_tres_produtos() {
		
	}
}
