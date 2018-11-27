package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.SubscriptionUnitViewModel;
import by.training.nc.sd3.service.SubscriptionUnitDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionUnitDataServiceImpl implements SubscriptionUnitDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    public List<SubscriptionUnitViewModel> getSubscriptionUnitsByUserId(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        SubscriptionUnitViewModel[] subscriptionUnits = restTemplate.getForObject(backendServerUrl + "/api/subscription-units/get-by-user-id?userId={id}",
                SubscriptionUnitViewModel[].class, id);
        return subscriptionUnits == null ? Collections.emptyList() : Arrays.asList(subscriptionUnits);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(backendServerUrl + "/api/subscription-units/delete/{id}?id={id}",
                Void.class, id, id);
    }

}
