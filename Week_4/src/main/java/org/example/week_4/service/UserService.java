package org.example.week_4.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.week_4.dto.request.UserRequest;
import org.example.week_4.dto.response.UserResponse;
import org.example.week_4.entity.User;
import org.example.week_4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(UserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("email da ton tai");
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();

        user = userRepository.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
