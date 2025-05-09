package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class Controller {

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read() {
        return "Только для пользователей с ролью [READ]!";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String write() {
        return "Только для пользователей с ролью [WRITE]!";
    }

    @GetMapping("/write-and-delete")
    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public String readAndWrite() {
        return "Для пользователей с ролями [WRITE] и [DELETE]!";
    }

    @GetMapping("/equals")
    public String equalsUsername(@RequestParam String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated() && auth.getName().equals(username))
            return "Имя " + username + " совпадает с текущим пользователем!";
        return "Указанное имя НЕ СОВПАДАЕТ с текущим пользователем, уходите!";
    }
}
