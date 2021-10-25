package com.effecti.gerenciador.webScrapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.effecti.gerenciador.entities.LicitacaoEntity;
import com.effecti.gerenciador.exception.EffectiException;

@Service
public class WebScrapping {

	public static List<LicitacaoEntity> extrairDados() throws EffectiException, IOException {
		System.out.println("Extraindo dados das licitações...");
		String url = "https://sig.ifsc.edu.br/public/listaEditais.do?tipo=2&aba=p-editais-atas&buscaTodas=true&acao=544";
		Document doc = Jsoup.connect(url).get();
		Element table = doc.getElementsByClass("listagem").first();
		Element tbody = table.getElementsByTag("tbody").first();
		List<Element> licitacoes = tbody.getElementsByTag("tr");
		List<LicitacaoEntity> licitacoesObjects = new ArrayList<>();
		
		for (Element licitacao : licitacoes) {
			List<Element> attributes = licitacao.getElementsByTag("td");
			List<Element> tagLink = licitacao.getElementsByTag("a");
			List<String> link = new ArrayList<>();
			tagLink.forEach(element -> {
				link.add(element.attr("href"));
			});
			
			LicitacaoEntity licitacaoEntity = new LicitacaoEntity();
			licitacaoEntity.setLicitacao(attributes.get(0).text());
			licitacaoEntity.setStatus(attributes.get(1).text());
			licitacaoEntity.setLocalizacao(attributes.get(2).text());
			licitacaoEntity.setVigencia(attributes.get(3).text());
			licitacaoEntity.setDescricao(attributes.get(4).text());
			licitacaoEntity.setArquivoVisualizar(link.get(0));
			licitacaoEntity.setArquivoItens(link.get(1));
			licitacaoEntity.setArquivoBaixar(link.get(2));
			licitacoesObjects.add(licitacaoEntity);
		}
		System.out.println("Extração Finalizada");
		return licitacoesObjects;
	}
}
