package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.Categories;
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
        SubscriptionViewModel sub1 = new SubscriptionViewModel(1, "Apple Music", description, Categories.music, 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel(2, "Spotify", description, Categories.streaming, 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel(3, "Yandex Music", description, Categories.development, 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel(4, "Zala", description, Categories.films, 4, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel(5, "Twitch", description, Categories.office, 5, 1, 1);
        List<SubscriptionViewModel> subsList = new LinkedList<SubscriptionViewModel>();

        subsList.add(sub1);
        subsList.add(sub2);
        subsList.add(sub3);
        subsList.add(sub4);
        subsList.add(sub5);

        return subsList;
    }

    public SubscriptionViewModel getSubscriptionById(int id) {
        String description = "Pin a fixed-height footer to the bottom of the viewport in" +
                " desktop browsers with this custom HTML and CSS. A fixed navbar has been added" +
                " with padding-top: 60px; on the body > .container. Back to the default sticky footer minus the navbar.";
        SubscriptionViewModel sub1 = new SubscriptionViewModel(1, "Apple Music", description, Categories.music, 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel(2, "Spotify", description, Categories.streaming, 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel(3, "Yandex Music", description, Categories.development, 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel(4, "Zala", description, Categories.films, 4, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel(5, "Twitch", description, Categories.office, 5, 1, 1);
        List<SubscriptionViewModel> subsList = new LinkedList<SubscriptionViewModel>();

        subsList.add(sub1);
        subsList.add(sub2);
        subsList.add(sub3);
        subsList.add(sub4);
        subsList.add(sub5);

        SubscriptionViewModel subscription = null;

        for (int i = 0; i < subsList.size(); i++) {
            if (subsList.get(i).getId() == id) {
                subscription = subsList.get(i);
            }
        }

        return subscription;
    }

    @Override
    public List<SubscriptionViewModel> getSubscriptionByCategory(String category) {
        String description = "Pin a fixed-height footer to the bottom of the viewport in" +
                " desktop browsers with this custom HTML and CSS. A fixed navbar has been added" +
                " with padding-top: 60px; on the body > .container. Back to the default sticky footer minus the navbar.";
        SubscriptionViewModel sub1 = new SubscriptionViewModel(1, "Apple Music", description, Categories.music, 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel(2, "Spotify", description, Categories.streaming, 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel(3, "Yandex Music", description, Categories.development, 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel(4, "Zala", description, Categories.films, 4, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel(5, "Twitch", description, Categories.office, 5, 1, 1);
        List<SubscriptionViewModel> subsList = new LinkedList<SubscriptionViewModel>();

        subsList.add(sub1);
        subsList.add(sub2);
        subsList.add(sub3);
        subsList.add(sub4);
        subsList.add(sub5);

        List<SubscriptionViewModel> subscriptions = new LinkedList<>();

        for (int i = 0; i < subsList.size(); i++) {
            if (subsList.get(i).getCategory().toString().equals(category)) {
                subscriptions.add(subsList.get(i));
            }
        }

        System.out.println(subscriptions);

        return subscriptions;
    }

    @Override
    public SubscriptionViewModel getSubscriptionByName(String name) {
        String description = "Pin a fixed-height footer to the bottom of the viewport in" +
                " desktop browsers with this custom HTML and CSS. A fixed navbar has been added" +
                " with padding-top: 60px; on the body > .container. Back to the default sticky footer minus the navbar.";
        SubscriptionViewModel sub1 = new SubscriptionViewModel(1, "Apple Music", description, Categories.music, 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel(2, "Spotify", description, Categories.streaming, 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel(3, "Yandex Music", description, Categories.development, 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel(4, "Zala", description, Categories.films, 4, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel(5, "Twitch", description, Categories.office, 5, 1, 1);
        List<SubscriptionViewModel> subsList = new LinkedList<SubscriptionViewModel>();

        subsList.add(sub1);
        subsList.add(sub2);
        subsList.add(sub3);
        subsList.add(sub4);
        subsList.add(sub5);

        SubscriptionViewModel subscription = null;

        for (int i = 0; i < subsList.size(); i++) {
            if (subsList.get(i).getName().equals(name)) {
                subscription = subsList.get(i);
            }
        }

        System.out.println(subscription);

        return subscription;
    }
}
