package br.com.lucassousa;

import java.math.BigDecimal;

public record TrasacaoCNAB(
        Integer tipo,
        String data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        String hora,
        String donoDaLoja,
        String nomeDaLoja) {
}
