package io.von.jpa;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	public List<Customer> getAll() {
		return customerService.getAll();
	}

	@PostMapping("/")
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@PutMapping("/")
	public String updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int customerId) {
		return customerService.deleteCustomer(customerId);
	}

	@GetMapping("/pages")
	public Map<String, Object> getPages(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "customerId") String sortBy) {
		return customerService.getPages(pageNo, pageSize, sortBy);
	}

}
