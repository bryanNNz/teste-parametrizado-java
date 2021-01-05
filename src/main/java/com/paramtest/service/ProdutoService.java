package com.paramtest.service;

import java.util.List;

import com.paramtest.domain.Produto;

public class ProdutoService {

	public Double calcularTotal(List<Produto> produtos) {
		Double valorTotal = 0d;
		
		for(Produto p : produtos) {
			valorTotal += p.getValor();
		}
		
		if(produtos.size() > 3) {
			valorTotal -= valorTotal * 0.2;
		}
		
		return valorTotal;
	}

}
