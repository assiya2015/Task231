package web.controller;

import org.springframework.web.bind.annotation.*;
import web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.service.UserService;
import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<User> users = userService.getUsers();
        theModel.addAttribute("users", users);
        return "list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        User user = new User();
        theModel.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") long theId,
                                    Model theModel) {
        User user = userService.getUser(theId);
        theModel.addAttribute("user", user);
        return "update-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") long theId) {
        userService.deleteUser(theId);
        return "redirect:/list";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute(userService.updateUser(user));
        return "redirect:/list";
    }

/*    @GetMapping("/index")
    public String index(Model theModel) {
        List<User> users = userService.getUsers();
        theModel.addAttribute("users", users);
        return "index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }

    @GetMapping("/{id}/edit)")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute(userService.getUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/index";
    }*/


}

