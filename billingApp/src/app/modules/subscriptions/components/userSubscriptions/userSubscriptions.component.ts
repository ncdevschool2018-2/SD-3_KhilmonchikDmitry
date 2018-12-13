import {Component, OnInit} from '@angular/core';
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'userSubscriptions',
  templateUrl: './userSubscriptions.component.html',
  styleUrls: ['./userSubscriptions.component.css']
})

export class UserSubscriptionsComponent implements OnInit {
  subscriptionUnits: SubscriptionUnit[];
  id;
  user;
  interval: any;

  constructor(private http: SubscriptionUnitService, public userIdService: UserIDService,
              public userService: UserService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.refreshData();
    this.interval = setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  refreshData() {
    this.userService.getUserById(this.id).subscribe(
      u => this.user = u
    );
    this.getSubscriptionUnitsById();
  }

  getSubscriptionUnitsById(): void {
    this.http.getSubscriptionUnitsById(this.id).subscribe( subscriptionUnits => {
      this.subscriptionUnits = subscriptionUnits;
      console.log(subscriptionUnits);
    });
  }

  unsubscribe(subscriptionUnit: SubscriptionUnit) {
    this.http.deleteSubscriptionUnit(subscriptionUnit).subscribe(
      res => console.log(res)
    );
  }

  changeStatus(subscriptionUnit: SubscriptionUnit) {
    this.http.changeStatusSubscriptionUnit(subscriptionUnit).subscribe();
  }
}
