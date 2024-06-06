package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entity.InstanceTraitement;
import service.InstanceTraitementService;

import java.util.List;

@RestController
@RequestMapping("/MIMApi/instance-traitements")
public class InstanceTraitementController {
	
	@Autowired
	    private InstanceTraitementService instanceTraitementService;

	    @GetMapping
	    public ResponseEntity<List<InstanceTraitement>> getAllInstanceTraitements() {
	        List<InstanceTraitement> instanceTraitements = instanceTraitementService.getAllInstanceTraitements();
	        return ResponseEntity.ok(instanceTraitements);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<InstanceTraitement> getInstanceTraitementById(@PathVariable Integer id) {
	        InstanceTraitement instanceTraitement = instanceTraitementService.getInstanceTraitementById(id);
	        return ResponseEntity.ok(instanceTraitement);
	    }

}
