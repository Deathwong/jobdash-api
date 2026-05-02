package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.CreateSchoolUserRequest;
import fr.jeff.jobdashapi.dto.request.CreateStudentRequest;
import fr.jeff.jobdashapi.dto.request.LoginRequest;
import fr.jeff.jobdashapi.dto.response.AuthResponse;
import fr.jeff.jobdashapi.model.entity.SchoolUser;
import fr.jeff.jobdashapi.model.entity.Student;
import fr.jeff.jobdashapi.model.enums.Role;
import fr.jeff.jobdashapi.repository.ClassRoomRepository;
import fr.jeff.jobdashapi.repository.SchoolRepository;
import fr.jeff.jobdashapi.repository.StudentRepository;
import fr.jeff.jobdashapi.repository.SchoolUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StudentRepository studentRepository;
    private final SchoolUserRepository schoolUserRepository;
    private final ClassRoomRepository classRoomRepository;
    private final SchoolRepository schoolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        var user = (fr.jeff.jobdashapi.model.entity.User) auth.getPrincipal();
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole());
    }

    public AuthResponse registerStudent(CreateStudentRequest request) {
        var classRoom = classRoomRepository.findById(request.classRoomId())
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("ClassRoom not found: " + request.classRoomId()));

        var student = new Student();
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        student.setPassword(passwordEncoder.encode(request.password()));
        student.setRole(Role.STUDENT);
        student.setClassRoom(classRoom);
        studentRepository.save(student);

        String token = jwtService.generateToken(student);
        return new AuthResponse(token, student.getId(), student.getEmail(), student.getFirstName(), student.getLastName(), student.getRole());
    }

    public AuthResponse registerSchoolUser(CreateSchoolUserRequest request) {
        var school = schoolRepository.findById(request.schoolId())
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("School not found: " + request.schoolId()));

        var schoolUser = new SchoolUser();
        schoolUser.setFirstName(request.firstName());
        schoolUser.setLastName(request.lastName());
        schoolUser.setEmail(request.email());
        schoolUser.setPassword(passwordEncoder.encode(request.password()));
        schoolUser.setRole(request.role());
        schoolUser.setSchool(school);
        schoolUserRepository.save(schoolUser);

        String token = jwtService.generateToken(schoolUser);
        return new AuthResponse(token, schoolUser.getId(), schoolUser.getEmail(), schoolUser.getFirstName(), schoolUser.getLastName(), schoolUser.getRole());
    }
}
