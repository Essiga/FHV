package at.fhv.se.banking.application.impl;

import at.fhv.se.banking.application.api.CustomerListingService;
import at.fhv.se.banking.application.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerListingServiceImpl implements CustomerListingService {


    @Override
    public List<CustomerDTO> getCustomerList() {
        return null;
    }
}
