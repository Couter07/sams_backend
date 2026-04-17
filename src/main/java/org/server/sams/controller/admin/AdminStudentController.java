package org.server.sams.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.server.sams.dto.Student.StudentSaveDto;
import org.server.sams.service.admin.AdminStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/student")
public class AdminStudentController {

    private final AdminStudentService adminStudentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentSaveDto studentSaveDto) {
        adminStudentService.saveStudent(studentSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
