package controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ExportService;
import repository.LancerRepository;
import entity.Lancer;

@RestController
@RequestMapping("/mimapi")
public class ExportController {

    @Autowired
    private LancerRepository lancerRepository;

    @Autowired
    private ExportService exportService;

    @GetMapping("/launchHistory")
    public List<Lancer> getLaunchHistory() {
        return lancerRepository.findAll();
    }

    @GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportLaunchHistoryToExcel() {
        List<Lancer> launchHistory = lancerRepository.findAll();
        ByteArrayInputStream in = exportService.exportLaunchHistoryToExcel(launchHistory);
        byte[] content = in.readAllBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=launch_history.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(content);
    }

    @GetMapping("/export/pdf")
    public ResponseEntity<byte[]> exportLaunchHistoryToPdf() {
        List<Lancer> launchHistory = lancerRepository.findAll();
        ByteArrayInputStream in = exportService.exportLaunchHistoryToPdf(launchHistory);
        byte[] content = in.readAllBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=launch_history.pdf")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(content);
    }
}
