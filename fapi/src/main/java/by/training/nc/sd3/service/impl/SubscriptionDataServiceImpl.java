package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.SubscriptionViewModel;
import by.training.nc.sd3.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    public List<SubscriptionViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionViewModel[] subscriptions = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/", SubscriptionViewModel[].class);
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    public SubscriptionViewModel getSubscriptionById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscriptions/" + id + "/", SubscriptionViewModel.class);
    }

    @Override
    public List<SubscriptionViewModel> getSubscriptionByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionViewModel[] subscriptions = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/by-category?category={category}",
                SubscriptionViewModel[].class, (long) Categories.valueOf(category).ordinal());
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    @Override
    public SubscriptionViewModel getSubscriptionByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscriptions/by-name?name={name}",
                SubscriptionViewModel.class, name);
    }
}
