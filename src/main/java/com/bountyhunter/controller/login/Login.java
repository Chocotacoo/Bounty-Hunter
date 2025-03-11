package com.bountyhunter.controller.login;

import com.bountyhunter.constants.AuthConstants;
import com.bountyhunter.dto.LoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bountyhunter/login")
public class Login {

    @RequestMapping(value = "/check-login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> checkLogin(@RequestBody LoginRequestDTO loginRequest) {
        Map<String, Object> response = new HashMap<>();

        String encodedUsername = Base64.getEncoder().encodeToString(loginRequest.getUsername().getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(loginRequest.getPassword().getBytes());

        if (encodedUsername.equals(AuthConstants.USERNAME) && encodedPassword.equals(AuthConstants.PASSWORD)) {
            response.put("status", "success");
            response.put("message", "Login Successful!");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid Username or Password!");
        }

        return ResponseEntity.ok(response);
    }
}
