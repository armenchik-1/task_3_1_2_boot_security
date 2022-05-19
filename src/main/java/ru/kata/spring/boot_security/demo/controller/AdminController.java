package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String emptyPageMethod() {
        return "empty-page";
    }

    @GetMapping("/getAll")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers",userService.getAll());
        return "all-users";
    }

    @GetMapping("/addUser")
    public String addUser(User user) {
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:getAll";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/admin/getAll";
    }
}
