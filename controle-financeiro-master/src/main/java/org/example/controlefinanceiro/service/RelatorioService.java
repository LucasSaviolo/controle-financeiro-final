package org.example.controlefinanceiro.service;

import org.example.controlefinanceiro.model.Relatorio;
import org.example.controlefinanceiro.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public Relatorio gerarRelatorio(Relatorio relatorio) {
        relatorio.setDataGeracao(new Date());
        return relatorioRepository.save(relatorio);
    }

    public byte[] exportarPDF(Relatorio relatorio) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Relatório ID: " + relatorio.getId()));
        document.add(new Paragraph("Tipo: " + relatorio.getTipo()));
        document.add(new Paragraph("Data de Geração: " + relatorio.getDataGeracao()));
        document.add(new Paragraph("Usuário: " + relatorio.getUsuario().getNome()));

        document.close();
        return baos.toByteArray();
    }

    public List<Relatorio> listar() {
        return relatorioRepository.findAll();
    }

    public Optional<Relatorio> buscarPorId(Long id) {
        return relatorioRepository.findById(id);
    }
}