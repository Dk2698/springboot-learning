package com.kumar.book.service;

import com.kumar.book.service.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserServiceValid {

    //Works even without controller
    public void saveUser(@Valid UserDTO dto) {}

//    @Validated
//    private void save(@Valid UserDto dto) {} Proxies intercept public methods only

    public void create(UserDTO dto) {
        save(dto); // validation skipped
    }

    public void save(@Valid UserDTO dto) {}
}
