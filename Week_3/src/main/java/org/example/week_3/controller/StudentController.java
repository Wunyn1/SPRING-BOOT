package org.example.week_3.controller;

import jakarta.validation.Valid;
import org.example.week_3.DTO.CreateStudentRequest;
import org.example.week_3.DTO.UpdateStudentRequest;
import org.example.week_3.api.ApiResponse;
import org.example.week_3.model.Student;
import org.example.week_3.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(){
        List<Student> studentList = studentService.findAll();
        return ResponseEntity.ok(ApiResponse.success(studentList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable Long id){
        Student student  = studentService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(student));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@Valid @RequestBody CreateStudentRequest request){
        Student student = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.create(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable Long id, @Valid @RequestBody UpdateStudentRequest request){
        Student updateStudent = studentService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(updateStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<ApiResponse<List<Student>>> fillterByMajor(@PathVariable String major){
        List<Student> students = studentService.findByMajor(major);
        return ResponseEntity.ok(ApiResponse.success(students));
    }


    @GetMapping("/honors")
    public ResponseEntity<ApiResponse<List<Student>>> getHonorStudent(){
        List<Student> students = studentService.getHonorsStudent();
        return ResponseEntity.ok(ApiResponse.success(students));
    }
}
