package com.oguzhanun.springdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oguzhanun.springdemo.entity.Customer;
import com.oguzhanun.springdemo.services.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	boolean duzeltildi=false;
	//@Autowired
	//private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;
	
	//@Autowired
	//private Customer customer;
	
	@InitBinder("customer")
	public void initBinder(WebDataBinder binder) {
		
		//binder.setRequiredFields("firstName");
		
		System.out.println("required fields: "+binder.getRequiredFields());
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		//System.out.println("**************"+ binder.getTarget());
		duzeltildi=true;
		//Customer customer = (Customer) binder.getTarget();
		//System.out.println("initBinder içinde: "+ customer.getFirstName().length());
	}
	
	@RequestMapping("/list")  //@GetMapping("/list") veya @PostMapping("/list") de kullanılabilirdi. Bu durumda form metodu olarak hangi anotasyon yazıldı ise o geçerli olur...
	public String listCustomers(Model model) {
		
		
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
		
		
		/*if(!duzeltildi) {
		
			WebDataBinder webDataBinder = new WebDataBinder(customer);
			initBinder(webDataBinder);
			saveCustomer(customer,bindingResult,model);
		}*/
		
		
		System.out.println("Binding Result : " + bindingResult);
		
		if(bindingResult.hasErrors() ) {   //|| customer.getFirstName().trim().isEmpty() || customer.getLastName().trim().isEmpty()
			//customer.setFirstName("lütfen isim giriniz...");
			//customer.setLastName("lütfen dallamalık yapmayınız...");
			model.addAttribute(customer);
			//System.out.println(customer.getFirstName().length());
			return "customer-form";
		} else {
			customerService.setCustomer(customer);
			
			return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("searchWord") String searchWord, Model model) {
		
		List<Customer> customers = customerService.searchCustomer(searchWord);
		//System.out.println(customers.get(0));
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
