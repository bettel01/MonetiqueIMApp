package controller;

import dto.InterfaceDTO;
import entity.InterfaceT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.InterfaceService;

import java.util.List;

@RestController
@RequestMapping("/mimapi/interfaces")
@RequiredArgsConstructor
public class InterfaceController {

    private final InterfaceService interfaceService;

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

    @PostMapping
    public ResponseEntity<InterfaceT> createInterface(@RequestBody InterfaceDTO interfaceDTO) {
        InterfaceT createdInterface = interfaceService.createInterface(interfaceDTO);
        return ResponseEntity.ok(createdInterface);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterfaceT> updateInterface(@PathVariable Integer id, @RequestBody InterfaceDTO interfaceDTO) {
        InterfaceT updatedInterface = interfaceService.updateInterface(id, interfaceDTO);
        return ResponseEntity.ok(updatedInterface);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterface(@PathVariable Integer id) {
        interfaceService.deleteInterface(id);
        return ResponseEntity.noContent().build();
    }
}
