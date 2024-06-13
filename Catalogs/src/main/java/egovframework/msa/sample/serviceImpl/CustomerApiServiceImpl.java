package egovframework.msa.sample.serviceImpl;
import org.springframework.stereotype.Service;

import egovframework.msa.sample.service.CustomerApiService;
@Service
public class CustomerApiServiceImpl implements CustomerApiService {
	@Override
	public String getCustomerDetail(String customerId) {
		return customerId;
	}
}