package ru.xpendence.mylovelytaxservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.mylovelytaxservice.dto.UserDto;
import ru.xpendence.mylovelytaxservice.service.UserService;
import ru.xpendence.mylovelytaxservice.transfer.Validation;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 27.07.19
 * Time: 12:23
 * e-mail: v.chernyshov@pflb.ru
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Validated(value = Validation.New.class) @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@Validated(value = Validation.Exists.class) @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping
    public ResponseEntity<UserDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
