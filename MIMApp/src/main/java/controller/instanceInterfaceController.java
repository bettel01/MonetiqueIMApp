package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entity.InstanceInterface;
import service.InstanceInterfaceService;

import java.util.List;

@RestController
@RequestMapping("/MIMApi/instance-interfaces")
public class instanceInterfaceController {

    @Autowired
    private InstanceInterfaceService instanceInterfaceService;

    @GetMapping
    public ResponseEntity<List<InstanceInterface>> getAllInstanceInterfaces() {
        List<InstanceInterface> instanceInterfaces = instanceInterfaceService.getAllInstanceInterfaces();
        return ResponseEntity.ok(instanceInterfaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstanceInterface> getInstanceInterfaceById(@PathVariable Integer id) {
        InstanceInterface instanceInterface = instanceInterfaceService.getInstanceInterfaceById(id);
        return ResponseEntity.ok(instanceInterface);
    }
}
