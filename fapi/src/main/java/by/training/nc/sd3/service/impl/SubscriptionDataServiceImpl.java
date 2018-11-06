package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.SubscriptionViewModel;
import by.training.nc.sd3.service.SubscriptionDataService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    public List<SubscriptionViewModel> getAll() {
        String description = "Pin a fixed-height footer to the bottom of the viewport in" +
                " desktop browsers with this custom HTML and CSS. A fixed navbar has been added" +
                " with padding-top: 60px; on the body > .container. Back to the default sticky footer minus the navbar.";
        SubscriptionViewModel sub1 = new SubscriptionViewModel("Apple Music", description, 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel("Spotify", description, 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel("Yandex Music", description, 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel("Zala", description, 1, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel("Twitch", description, 1, 1, 1);
        List<SubscriptionViewModel> subsList = new LinkedList<SubscriptionViewModel>();

        subsList.add(sub1);
        subsList.add(sub2);
        subsList.add(sub3);
        subsList.add(sub4);
        subsList.add(sub5);

        return subsList;
    }

}
