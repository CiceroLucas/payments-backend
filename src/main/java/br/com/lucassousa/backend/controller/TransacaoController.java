package br.com.lucassousa.backend.controller;

import br.com.lucassousa.backend.domain.Transacao;
import br.com.lucassousa.backend.domain.TransacaoReport;
import br.com.lucassousa.backend.service.TransacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    List<TransacaoReport> listAll(){
        return service.listTotaisTransacaoPorNomeDaLoja();
    }
}
