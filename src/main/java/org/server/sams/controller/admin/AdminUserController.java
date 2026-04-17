package org.server.sams.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.server.sams.dto.User.UserSaveDto;
import org.server.sams.service.admin.AdminUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserSaveDto userSaveDto) {
        return ResponseEntity.ok(new StringBuilder("Oke bro!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(new StringBuilder("Oke bro!"));
    }

    @GetMapping("/country")
    public ResponseEntity<?> getAllCountry() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(adminUserService.getAllCountry());
    }
}
