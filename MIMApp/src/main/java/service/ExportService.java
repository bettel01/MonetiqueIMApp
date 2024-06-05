package service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.itextpdf.text.Font;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import entity.Lancer;

@Service
public class ExportService {

    public ByteArrayInputStream exportLaunchHistoryToExcel(List<Lancer> launchHistory) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("LaunchHistory");
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Nom Traitement", "Sens du Flux", "Mode de Lancement", "Date Début", "Date Fin", "Etat"};

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowIdx = 1;
            for (Lancer lancer : launchHistory) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(lancer.getNomTraitement());
                row.createCell(1).setCellValue(lancer.getSensFlux());
                row.createCell(2).setCellValue(lancer.getModeLancement());
                // Vérification si la date de début et de fin ne sont pas nulles avant de les convertir en chaîne de caractères
                row.createCell(3).setCellValue(lancer.getDateDebutLancement() != null ? lancer.getDateDebutLancement().toString() : "");
                row.createCell(4).setCellValue(lancer.getDateFinLancement() != null ? lancer.getDateFinLancement().toString() : "");
                row.createCell(5).setCellValue(lancer.getEtatLancement());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to export to Excel", e);
        }
    }


    public ByteArrayInputStream exportLaunchHistoryToPdf(List<Lancer> launchHistory) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph("Historique des traitements ", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100); // La table occupe toute la largeur de la page
            Stream.of("Nom Traitement", "Sens du Flux", "Mode de Lancement", "Date Début", "Date Fin", "Etat")
                    .forEach(columnTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(new BaseColor(173, 216, 230)); // Couleur de fond de l'en-tête
                        // Épaisseur de la bordure
                        header.setPhrase(new Phrase(columnTitle, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK))); // Police et couleur du texte de l'en-tête
                        table.addCell(header);
                    });

            for (Lancer lancer : launchHistory) {
                table.addCell(lancer.getNomTraitement());
                table.addCell(lancer.getSensFlux());
                table.addCell(lancer.getModeLancement());
                // Vérification si la date de début et de fin ne sont pas nulles avant de les convertir en chaîne de caractères
                table.addCell(lancer.getDateDebutLancement() != null ? lancer.getDateDebutLancement().toString() : "");
                table.addCell(lancer.getDateFinLancement() != null ? lancer.getDateFinLancement().toString() : "");
                table.addCell(lancer.getEtatLancement());

            }

            document.add(table);
            document.close();

            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to export to PDF", e);
        }
    }
}
