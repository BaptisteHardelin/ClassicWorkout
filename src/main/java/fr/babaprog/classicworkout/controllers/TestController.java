package fr.babaprog.classicworkout.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/anon")
    public String anonEndPoint() {
        return "everyone can see this";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public String userEndPoint() {
        return "ONLY user can see this";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String adminsEndPoint() {
        return "ONLY admin can see this";
    }
}
