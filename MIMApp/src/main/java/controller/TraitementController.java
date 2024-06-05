package controller;

import dto.TraitementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
