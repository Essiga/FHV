package at.fhv.se.banking.application.api;

import at.fhv.se.banking.application.dto.CustomerDTO;

import java.util.List;

public interface CustomerListingService {

    public List<CustomerDTO> getCustomerList();
}
