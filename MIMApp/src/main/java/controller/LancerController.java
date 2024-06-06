package controller;

import entity.Lancer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import service.InstanceService;
import entity.InstanceTraitement;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/mimapi")
public class LancerController {

    @Autowired
    private InstanceService instanceService;

    @PostMapping("/launch")
    public ResponseEntity<String> launch(@RequestParam Integer idTraitement,
                                         @RequestParam String nomTraitement,
                                         @RequestParam String sensFlux,
                                         @RequestParam String modeLancement,
                                         @RequestParam String interfaceIds) {
        try {
            List<Integer> interfaceIdList = Arrays.stream(interfaceIds.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            LocalDateTime dateDebutLancement = LocalDateTime.now();
            LocalDateTime dateFinLancement = dateDebutLancement.plusMinutes(5);

            InstanceTraitement instanceTraitement = instanceService.createInstanceTraitement(idTraitement);
            instanceService.createInstanceInterfaces(interfaceIdList, instanceTraitement.getIdInstanceTraitement());

            instanceService.createLancer(instanceTraitement.getIdInstanceTraitement(),
                    nomTraitement, sensFlux, modeLancement,
                    dateDebutLancement, dateFinLancement);
            return ResponseEntity.ok("Treatment launched successfully");
        } catch (Exception e) {
            // Log the exception for more details
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to launch treatment: " + e.getMessage());
        }
    }
}
