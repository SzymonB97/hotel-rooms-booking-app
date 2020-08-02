package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.User;
import pl.sborowy.hotelroomsbookingapp.service.UserService;
import pl.sborowy.hotelroomsbookingapp.util.user.UserViewNames;
import pl.sborowy.hotelroomsbookingapp.util.user.UserAttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.user.UserMappings;

@Controller
public class UserController {

    // --fields--
    private final UserService customerService;

    // --constructors--
    @Autowired
    public UserController(UserService customerService) {
        this.customerService = customerService;
    }

    // --get methods--
    @GetMapping(UserMappings.USERS_LIST)
    public String listCustomers(Model model) {
        model.addAttribute(UserAttributeNames.USERS, customerService.findAll());

        return UserViewNames.USERS_LIST;
    }

    @GetMapping(UserMappings.USER_GET)
    public String getCustomer(@RequestParam(UserAttributeNames.USER_ID) int id, Model model) {
        User customer = customerService.findById(id);
        model.addAttribute(UserAttributeNames.USER, customer);

        return UserViewNames.USER;
    }

    @GetMapping(UserMappings.USER_DELETE)
    public String deleteCustomer(@RequestParam(UserAttributeNames.USER_ID) int id) {
        customerService.deleteById(id);

        return "redirect:" + UserMappings.USERS_LIST;
    }

    @GetMapping(UserMappings.USER_FORM_SAVE)
    public String showFormForSaveCustomer(Model model) {
        // model attribute to bind form data
        User customer = new User();
        model.addAttribute(UserAttributeNames.USER, customer);

        return UserViewNames.USER_FORM;
    }

    @GetMapping(UserMappings.USER_FORM_UPDATE)
    public String showFormForUpdateCustomer(@RequestParam(UserAttributeNames.USER_ID) int id, Model model) {
        User customer = customerService.findById(id);
        model.addAttribute(UserAttributeNames.USER, customer);

        return UserViewNames.USER_FORM;
    }

    // --post methods--
    @PostMapping(UserMappings.USER_SAVE)
    public String saveCustomer(@ModelAttribute(UserAttributeNames.USER) User customer) {
        customerService.save(customer);

        return "redirect:" + UserMappings.USERS_LIST;
    }
}
