

package com.bcp.monitoring.MIMApp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authRequest) {
        // Vérifiez que l'authRequest contient bien les champs attendus
        if (authRequest.getEmail() == null || authRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password must be provided");
        }

        // Authentification
        try {
            AuthenticationResponse response = authenticationService.authenticate(authRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Authentication failed");
        }
    }
}