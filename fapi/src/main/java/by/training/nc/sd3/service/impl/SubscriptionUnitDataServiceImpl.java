package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.SubscriptionUnitViewModel;
import by.training.nc.sd3.models.SubscriptionViewModel;
import by.training.nc.sd3.service.SubscriptionUnitDataService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubscriptionUnitDataServiceImpl implements SubscriptionUnitDataService {

    public List<SubscriptionUnitViewModel> getSubscriptionUnitsById(int id) {

        String description = "Pin a fixed-height footer to the bottom of the viewport in" +
                " desktop browsers with this custom HTML and CSS. A fixed navbar has been added" +
                " with padding-top: 60px; on the body > .container. Back to the default sticky footer minus the navbar.";

        SubscriptionViewModel sub1 = new SubscriptionViewModel(1, "Apple Music", description, Categories.music.ordinal(), 1, 1, 1);
        SubscriptionViewModel sub2 = new SubscriptionViewModel(2, "Spotify", description, Categories.streaming.ordinal(), 1, 1, 1);
        SubscriptionViewModel sub3 = new SubscriptionViewModel(3, "Yandex Music", description, Categories.development.ordinal(), 1, 1, 1);
        SubscriptionViewModel sub4 = new SubscriptionViewModel(4, "Zala", description, Categories.films.ordinal(), 4, 1, 1);
        SubscriptionViewModel sub5 = new SubscriptionViewModel(5, "Twitch", description, Categories.office.ordinal(), 5, 1, 1);

        SubscriptionUnitViewModel subscrUnit1 = new SubscriptionUnitViewModel(1, sub1, 190,true, true);
        SubscriptionUnitViewModel subscrUnit2 = new SubscriptionUnitViewModel(2, sub2, 30,false, true);
        SubscriptionUnitViewModel subscrUnit3 = new SubscriptionUnitViewModel(3, sub3, 18,true, false);
        SubscriptionUnitViewModel subscrUnit4 = new SubscriptionUnitViewModel(2, sub4, 45,true, false);
        SubscriptionUnitViewModel subscrUnit5 = new SubscriptionUnitViewModel(2, sub5, 90,true, true);
        List<SubscriptionUnitViewModel> subscrUnits = new LinkedList<>();
        subscrUnits.add(subscrUnit1);
        subscrUnits.add(subscrUnit2);
        subscrUnits.add(subscrUnit3);
        subscrUnits.add(subscrUnit4);
        subscrUnits.add(subscrUnit5);

        List<SubscriptionUnitViewModel> result = new LinkedList<>();

        for(int i = 0; i < subscrUnits.size(); i++) {
            if(subscrUnits.get(i).getUserId() == id)
                result.add(subscrUnits.get(i));
        }
        return result;
    }

}
