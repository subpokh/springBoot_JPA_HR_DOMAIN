package io.von.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	public String addCustomer(Customer customer) {
		String response;
		if (customerRepository.save(customer) != null)
			response = "Customer successfully added";
		else
			response = "Something went wrong. Customer failed to be added.";
		return response;
	}

	public String updateCustomer(Customer customer) {				
		String response;
		if (customerRepository.save(customer)!= null)
			response = "Customer successfully updated";
		else
			response = "Something went wrong. Customer failed to be updated.";
		return response;
	}

	public String deleteCustomer(int customerId) {
		String response;
		try {
			customerRepository.deleteById(customerId);
			response = "Customer successfully deleted";
		} catch (IllegalArgumentException e) {
			response = "Something went wrong. Customer is not deleted.";
		}

		return response;
	}

	public Map<String, Object> getPages(int pageNo, int pageSize, String sortBy) {
		Map<String, Object> response = new HashMap<String, Object>();
		PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Customer> page = customerRepository.findAll(pageable);

		response.put("count", page.getTotalElements());
		response.put("currentPage", page.getNumber());
		response.put("totalPages", page.getTotalPages());
		response.put("data", page.getContent());
		return response;
	}
	

}
