package egovframework.msa.sample.serviceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import egovframework.msa.sample.service.CustomerApiService;
@Service
public class CustomerApiServiceImpl implements CustomerApiService {
	private static final Logger log = LoggerFactory.getLogger(CustomerApiServiceImpl.class);
	private final WebClient.Builder webClient;
	public CustomerApiServiceImpl(WebClient.Builder webClient) {
		this.webClient = webClient;
	}
	@Override
	public String getCustomerDetail(String customerId) {
		//return customerId;
		return webClient.build().get()
		.uri("http://localhost:8082/customers/" + customerId)
		.retrieve()
		.bodyToMono(String.class)
		.flux()
		.toStream()
		.findFirst()
		.orElse(null);
	}
}