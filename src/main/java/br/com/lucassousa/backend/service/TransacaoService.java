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

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
    public List<TransacaoReport> listTotaisTransacaoPorNomeDaLoja() {
        var transacoes = transacaoRepository.findAllByOrderByNomeDaLojaAscIdDesc();

        var reportMap = new LinkedHashMap <String, TransacaoReport>();

        transacoes.forEach(transacao -> {
            var nomeDaLoja = transacao.nomeDaLoja();
            var valor = transacao.valor();

            reportMap.compute(nomeDaLoja, (key, existingReport) -> {
                var report = (existingReport != null) ? existingReport :
                        new TransacaoReport(key , BigDecimal.ZERO, new ArrayList<>());
                return report.addTotal(valor).addTransacao(transacao);
            });
        });
        return new ArrayList<>(reportMap.values());
    }
}
