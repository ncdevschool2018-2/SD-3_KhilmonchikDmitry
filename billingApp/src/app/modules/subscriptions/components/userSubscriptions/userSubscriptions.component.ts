import {Component, OnInit} from '@angular/core';
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";

@Component({
  selector: 'userSubscriptions',
  templateUrl: './userSubscriptions.component.html',
  styleUrls: ['./userSubscriptions.component.css']
})

export class UserSubscriptionsComponent implements OnInit {
  subscriptionUnits: SubscriptionUnit[];
  id;

  constructor(private http: SubscriptionUnitService, private userIdService: UserIDService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.getSubscriptionUnitsById();
  }

  getSubscriptionUnitsById(): void {
    this.http.getSubscriptionUnitsById(this.id).subscribe( subscriptionUnits => {
      this.subscriptionUnits = subscriptionUnits;
      console.log(subscriptionUnits);
    });
  }
}
