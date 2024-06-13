package egovframework.msa.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

	@GetMapping("/{customerId}")
	public String getCustomerDetail(@PathVariable String customerId) {
		//throw new RuntimeException("I/O Exception");
		log.info("request customerId :" + customerId);
		return "[Customer id = " + customerId + " at " + System.currentTimeMillis() + "]";
	}

}
