package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entity.InterfaceT;
import service.InterfaceService;

import java.util.List;

@RestController
@RequestMapping("/MIMApi/interfaces")
public class InterfaceController {
	@Autowired
    private InterfaceService interfaceService;

    @GetMapping
    public ResponseEntity<List<InterfaceT>> getAllInterfaces() {
        List<InterfaceT> interfaces = interfaceService.getAllInterfaces();
        return ResponseEntity.ok(interfaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterfaceT> getInterfaceById(@PathVariable Integer id) {
        InterfaceT iface = interfaceService.getInterfaceById(id);
        return ResponseEntity.ok(iface);
    }

}
