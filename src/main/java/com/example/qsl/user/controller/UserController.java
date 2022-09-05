package com.example.qsl.user.controller;

import com.example.qsl.user.entity.SiteUser;
import com.example.qsl.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping("/user/{id}")
    public SiteUser user(@PathVariable Long id){
        return userRepository.getQslUser(id);
    }
}
