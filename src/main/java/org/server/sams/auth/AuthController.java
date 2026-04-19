package org.server.sams.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final AuthService authService;

//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
//        // 1. Xác thực username/password
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );
//
//        // 2. Load user details
//        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
//
//        // 3. Tạo JWT token
//        String token = jwtService.generateToken(user);
//
//        return ResponseEntity.ok(new AuthResponse(token));
//    }

}
