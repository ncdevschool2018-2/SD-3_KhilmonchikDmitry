import {Component, Input, OnInit, Output} from '@angular/core';
import {UserIDService} from '../../../../services/userID.service';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {Subscription} from "../../../../shared/Subscription";
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  @Input() loggedUserIDObs = this.userIDService.data$;
  loggedUserID;
  @Output() subscriptions: Subscription[];
  @Output() subscription: Subscription;

  constructor(private http: SubscriptionService, private userIDService: UserIDService,
              private subscriptionShareService: SubscriptionsShareService) {
    this.userIDService.setID(-1);
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
  }

  getAllSubscriptions() {
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
  }

  ngOnInit() {
    this.loggedUserIDObs.subscribe(loggedUserID => {
      this.loggedUserID = loggedUserID;
      console.log(this.loggedUserID);
    });
  }

  search(name: string): Subscription {
    this.http.getSubscriptionByName(name).subscribe(subscription => {
      this.subscriptionShareService.setSubscriptions([subscription]);
    });
    return this.subscription;
  }

  filter(category: string): Subscription[] {
    this.http.getSubscriptionByCategory(category).subscribe(subscriptions => {
      this.subscriptionShareService.setSubscriptions(subscriptions);
    });
    return this.subscriptions;
  }

  logOut() {
    this.userIDService.setID(-1);
  }
}
