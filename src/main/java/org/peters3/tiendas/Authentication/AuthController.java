package org.peters3.tiendas.Authentication;

import org.peters3.tiendas.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.peters3.tiendas.entity.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository; // Repositorio de usuarios

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("test")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("Enviando GET ");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable int id, @RequestBody RegisterRequest request) {
        return userRepository.findById(id).map(usuario -> {
            usuario.setUsername(request.getUsername());
            usuario.setNombre(request.getNombre());
            usuario.setApellido(request.getApellido());
            usuario.setPassword(request.getPassword());
            usuario.setRole(Role.valueOf(request.getRole()));
            userRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int id) {
        return userRepository.findById(id).map(usuario -> {
            userRepository.delete(usuario);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        }).orElse(ResponseEntity.notFound().build());
    }
}
