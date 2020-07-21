package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sborowy.hotelroomsbookingapp.service.CustomerService;
import pl.sborowy.hotelroomsbookingapp.util.AttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.Mappings;
import pl.sborowy.hotelroomsbookingapp.util.ViewNames;

@Controller
public class CustomerController {

    // --fields--
    private final CustomerService customerService;

    // --constructors--
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // --request methods--
    @GetMapping(Mappings.CUSTOMERS)
    public String customers(Model model) {
        model.addAttribute(AttributeNames.CUSTOMERS, customerService.findAll());

        return ViewNames.CUSTOMERS_LIST;
    }
}
