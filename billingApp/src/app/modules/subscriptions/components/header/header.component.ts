import {Component, OnInit} from '@angular/core';
import {UserIDService} from '../../../../services/userID.service';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {Subscription} from "../../../../shared/Subscription";
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  loggedUserIDObs = this.userIDService.data$;
  loggedUserID;
  subscriptions: Subscription[];
  subscription: Subscription;
  isAdmin: boolean = false;
  interval;

  constructor(private http: SubscriptionService, public userIDService: UserIDService,
              private subscriptionShareService: SubscriptionsShareService,
              private userService: UserService) {
    this.userIDService.setID(-1);
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
  }

  ngOnInit() {
    this.loggedUserIDObs.subscribe(loggedUserID => {
      this.loggedUserID = loggedUserID[0];
      this.getIsAdmin();
    });
  }

  getIsAdmin() {
    if(this.loggedUserID > -1) {
      this.userService.getUserById(this.loggedUserID).subscribe(
        user => this.isAdmin = user.isAdmin
      )
    }
  }

  getAllSubscriptions() {
    this.http.getSubscriptions().subscribe(
      subscriptions =>
        this.subscriptionShareService.setSubscriptions(subscriptions)
    )
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
    this.isAdmin = false;
  }
}
