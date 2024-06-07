package controller;

import dto.TraitementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TraitementService;

import java.util.List;

@RestController
@RequestMapping("/mimapi/traitements")
public class TraitementController {

    @Autowired
    private TraitementService traitementService;

    @GetMapping
    public List<TraitementDTO> getAllTraitements() {
        return traitementService.getAllTraitementsWithInterfaces();
    }

    @PostMapping
    public TraitementDTO addTraitement(@RequestBody TraitementDTO traitementDTO) {
        return traitementService.addTraitement(traitementDTO);
    }

    @PutMapping("/{id}")
    public TraitementDTO updateTraitement(@PathVariable Integer id, @RequestBody TraitementDTO traitementDTO) {
        return traitementService.updateTraitement(id, traitementDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTraitement(@PathVariable Integer id) {
        traitementService.deleteTraitement(id);
    }
}
