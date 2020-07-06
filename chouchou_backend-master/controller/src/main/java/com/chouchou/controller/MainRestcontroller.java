package com.chouchou.controller;

import com.chouchou.dao.RoleRepository;
import com.chouchou.dao.UserRepository;
import com.chouchou.model.AuthProvider;
import com.chouchou.model.Role;
import com.chouchou.model.UserManager;
import com.chouchou.security.TokenProvider;
import com.chouchou.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
public class MainRestcontroller {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenProvider tokenProvider;

    @GetMapping("api")
    public HashMap<String, Object> home() {
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("home", 1);
        return res;
    }


    @PostMapping("api/login")
    public ResponseEntity<?> authenticateUser(String username, String password) {
        HashMap<String, Object> res = new HashMap<String, Object>();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        res.put("token", jwt);
        return ResponseEntity.ok(res);
    }

    @GetMapping("api/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCurrentUser(UserPrincipal userPrincipal) {
        HashMap<String, Object> res = new HashMap<String, Object>();
        UserManager user = userRepository.findByEmail(userPrincipal.getUsername());
        res.put("user",user);
        return ResponseEntity.ok(res);
    }
    @PostMapping("api/signup")
    public ResponseEntity<?> registerUser(String username, String password, String nom, String prenom) {

        HashMap<String, Object> res = new HashMap<String, Object>();
        if (userRepository.existsByEmail(username)) {
            res.put("error", "Username is already taken!");
            return new ResponseEntity(res,
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(username)) {
            res.put("error", "Username Address already in use!");
            return new ResponseEntity(res,
                    HttpStatus.BAD_REQUEST);
        }
        UserManager user = new UserManager(nom, prenom, username, password);
        user.setProvider(AuthProvider.local);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role("USER_ROLE");
        List<Role> roles = null;
        roles.add(role);
        user.setRoles(roles);

        UserManager result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getEmail()).toUri();
        res.put("user", user);
        return ResponseEntity.created(location).body(res);
    }
}
