import {Component, OnInit} from '@angular/core';
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";
import {UserService} from "../../../../services/user/user.service";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {ActivatedRoute} from "@angular/router";
import {User} from "../../../../shared/User";

@Component({
  selector: 'userSubscriptions',
  templateUrl: './userSubscriptions.component.html',
  styleUrls: ['./userSubscriptions.component.css']
})

export class UserSubscriptionsComponent implements OnInit {
  subscriptionUnits: SubscriptionUnit[];
  private observedId;
  private id;
  public user: User;
  private observedUser: User;
  interval: any;

  constructor(private http: SubscriptionUnitService, private userIdService: UserIDService,
              public userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.observedId = this.route.snapshot.paramMap.get('id');
    this.id = this.userIdService.getID()[0];
    this.userService.getUserById(this.id).subscribe(
      user => this.user = user
    );
    this.refreshData();
    this.interval = setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  refreshData() {
    if(this.id > -1) {
      this.userService.getUserById(this.id).subscribe(
        u => {
          this.observedUser = u;
        }
      );
      this.getSubscriptionUnitsById();
    }
  }

  getSubscriptionUnitsById(): void {
    this.http.getSubscriptionUnitsById(this.observedId).subscribe( subscriptionUnits => {
      this.subscriptionUnits = subscriptionUnits;
    });
  }

  unsubscribe(subscriptionUnit: SubscriptionUnit) {
    this.http.deleteSubscriptionUnit(subscriptionUnit).subscribe();
  }

  changeStatus(subscriptionUnit: SubscriptionUnit) {
    this.http.changeStatusSubscriptionUnit(subscriptionUnit).subscribe();
  }
}
