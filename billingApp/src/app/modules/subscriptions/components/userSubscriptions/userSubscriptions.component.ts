import {Component, OnInit} from '@angular/core';
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";
import {UserService} from "../../../../services/user/user.service";
import {User} from "../../../../shared/User";

@Component({
  selector: 'userSubscriptions',
  templateUrl: './userSubscriptions.component.html',
  styleUrls: ['./userSubscriptions.component.css']
})

export class UserSubscriptionsComponent implements OnInit {
  subscriptionUnits: SubscriptionUnit[];
  id;
  user: User;

  constructor(private http: SubscriptionUnitService, private userIdService: UserIDService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.userService.getUserById(this.id).subscribe(
      user => {
        this.user = user;
        console.log(this.user);
      }
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
}
