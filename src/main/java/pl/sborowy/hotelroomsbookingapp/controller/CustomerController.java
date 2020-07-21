package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;
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

    // --get methods--
    @GetMapping(Mappings.CUSTOMERS)
    public String listCustomers(Model model) {
        model.addAttribute(AttributeNames.CUSTOMERS, customerService.findAll());

        return ViewNames.CUSTOMERS_LIST;
    }

    @GetMapping(Mappings.CUSTOMER)
    public String getCustomer(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute(AttributeNames.CUSTOMER, customer);

        return ViewNames.CUSTOMER;
    }

    @GetMapping(Mappings.CUSTOMER_DELETE)
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteById(id);

        return "redirect:" + Mappings.CUSTOMERS;
    }

    @GetMapping(Mappings.CUSTOMER_FORM_SAVE)
    public String showFormForSaveCustomer(Model model) {
        // model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute(AttributeNames.CUSTOMER, customer);

        return ViewNames.CUSTOMER_FORM;
    }

    @GetMapping(Mappings.CUSTOMER_FORM_UPDATE)
    public String showFormForUpdateCustomer(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute(AttributeNames.CUSTOMER, customer);

        return ViewNames.CUSTOMER_FORM;
    }

    // --post methods--
    @PostMapping(Mappings.CUSTOMER_SAVE)
    public String saveCustomer(@ModelAttribute(AttributeNames.CUSTOMER) Customer customer) {
        customerService.save(customer);

        return "redirect:" + Mappings.CUSTOMERS;
    }
}
