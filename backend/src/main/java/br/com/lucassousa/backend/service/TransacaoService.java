package br.com.lucassousa.backend.service;

import br.com.lucassousa.backend.domain.TipoTransacao;
import br.com.lucassousa.backend.domain.Transacao;
import br.com.lucassousa.backend.domain.TransacaoReport;
import br.com.lucassousa.backend.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.repository = transacaoRepository;
    }
    public List<TransacaoReport> listTotaisTransacaoPorNomeDaLoja() {
         List<Transacao> transacoes = repository.findAllByOrderByNomeDaLojaAscIdDesc();

    // preserves order
    Map<String, TransacaoReport> reportMap = new LinkedHashMap<>();

    transacoes.forEach(transacao -> {
      var nomeDaLoja = transacao.nomeDaLoja();
      var valor = transacao.valor();

      reportMap.compute(nomeDaLoja, (key, existingReport) -> {
        TransacaoReport report = (existingReport != null) ? existingReport
            : new TransacaoReport(key, BigDecimal.ZERO, new ArrayList<>());
        return report.addTotal(valor).addTransacao(transacao);
      });
    });

    return new ArrayList<>(reportMap.values());
    }
}
