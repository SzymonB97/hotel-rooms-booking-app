package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;
import pl.sborowy.hotelroomsbookingapp.service.CustomerService;
import pl.sborowy.hotelroomsbookingapp.util.customer.CustomerViewNames;
import pl.sborowy.hotelroomsbookingapp.util.customer.CustomerAttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.customer.CustomerMappings;

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
    @GetMapping(CustomerMappings.CUSTOMERS_LIST)
    public String listCustomers(Model model) {
        model.addAttribute(CustomerAttributeNames.CUSTOMERS, customerService.findAll());

        return CustomerViewNames.CUSTOMERS_LIST;
    }

    @GetMapping(CustomerMappings.CUSTOMER_GET)
    public String getCustomer(@RequestParam(CustomerAttributeNames.CUSTOMER_ID) int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute(CustomerAttributeNames.CUSTOMER, customer);

        return CustomerViewNames.CUSTOMER;
    }

    @GetMapping(CustomerMappings.CUSTOMER_DELETE)
    public String deleteCustomer(@RequestParam(CustomerAttributeNames.CUSTOMER_ID) int id) {
        customerService.deleteById(id);

        return "redirect:" + CustomerMappings.CUSTOMERS_LIST;
    }

    @GetMapping(CustomerMappings.CUSTOMER_FORM_SAVE)
    public String showFormForSaveCustomer(Model model) {
        // model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute(CustomerAttributeNames.CUSTOMER, customer);

        return CustomerViewNames.CUSTOMER_FORM;
    }

    @GetMapping(CustomerMappings.CUSTOMER_FORM_UPDATE)
    public String showFormForUpdateCustomer(@RequestParam(CustomerAttributeNames.CUSTOMER_ID) int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute(CustomerAttributeNames.CUSTOMER, customer);

        return CustomerViewNames.CUSTOMER_FORM;
    }

    // --post methods--
    @PostMapping(CustomerMappings.CUSTOMER_SAVE)
    public String saveCustomer(@ModelAttribute(CustomerAttributeNames.CUSTOMER) Customer customer) {
        customerService.save(customer);

        return "redirect:" + CustomerMappings.CUSTOMERS_LIST;
    }
}
