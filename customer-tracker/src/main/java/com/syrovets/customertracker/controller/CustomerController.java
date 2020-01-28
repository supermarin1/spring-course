package com.syrovets.customertracker.controller;

import com.syrovets.customertracker.entity.Customer;
import com.syrovets.customertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String addCustomer(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String updateCustomer(@RequestParam("customerId") int id, Model model){
        Customer customer = customerService.getCustomer(id);
        System.out.println("From db: " + customer.toString());

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){
        customerService.delete(id);

        return "redirect:/customer/list";
    }
}
