package org.example.week_3.service;


import org.example.week_3.DTO.CreateStudentRequest;
import org.example.week_3.DTO.UpdateStudentRequest;
import org.example.week_3.customException.DuplicateResourceException;
import org.example.week_3.customException.ResourceNotFoundException;
import org.example.week_3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public List<Student> findAll(){
        return students;
    }

    public Student findById(Long id){
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("student", "id", id));
    }

    public Student create(CreateStudentRequest request){
        //kiem tra emmail trung
        boolean emailExists = students.stream()
                .anyMatch(u -> u.getEmail().equals(request.getEmail()));
        if(emailExists){
            throw new DuplicateResourceException("student", "email", request.getEmail());
        }
        Student student = new Student(nextId++, request.getStudentCode(), request.getName(), request.getEmail(), request.getPhone(), request.getDateOfBirth(), request.getGpa(), request.getMajor(), request.getYear());
        students.add(student);
        return student;
    }


    public Student update(Long id, UpdateStudentRequest request){
        Student studentCurrent = findById(id);
        boolean newEmail = students.stream()
                .anyMatch(s -> !s.getId().equals(id) && s.getEmail().equalsIgnoreCase(request.getEmail()));
        if(newEmail){
            throw new DuplicateResourceException("sinh viên", "email", request.getEmail());
        }

        studentCurrent.setName(request.getName());
        studentCurrent.setEmail(request.getEmail());
        studentCurrent.setPhone(request.getPhone());
        studentCurrent.setDateOfBirth(request.getDateOfBirth());
        studentCurrent.setGpa(request.getGpa());
        studentCurrent.setMajor(request.getMajor());
        studentCurrent.setYear(request.getYear());
        return studentCurrent;
    }

    public void delete(Long id){
        Student deleteStudent = findById(id);
        students.remove(deleteStudent);
    }

    public List<Student> findByMajor(String major){
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Student> getHonorsStudent(){
        return students.stream()
                .filter(s -> s.getGpa()>3.6)
                .collect(Collectors.toList());
    }
}
