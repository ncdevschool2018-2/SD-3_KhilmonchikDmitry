import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {toNumber} from "ngx-bootstrap/timepicker/timepicker.utils";
import {Subscription} from "../../../../shared/Subscription";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";
import {UserService} from "../../../../services/user/user.service";
import {User} from "../../../../shared/User";

@Component({
  selector: 'subscriptionsDetails',
  templateUrl: './subscriptionDetails.component.html',
  styleUrls: ['./subscriptionDetails.component.css']
})

export class SubscriptionDetailsComponent implements OnInit {
  subscription: Subscription;
  isSubscribed: boolean;
  notEnoughMoney: boolean;
  id;
  user: User;
  subscriptionId: any;

  constructor(private http: SubscriptionService, private route: ActivatedRoute,
              private userIdService: UserIDService,
              private subscriptionUnitService: SubscriptionUnitService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.notEnoughMoney = false;
    this.refreshData();
  }

  refreshData() {
    this.getSubscription();
    this.isSubscribed = false;
    this.id = this.userIdService.getID()[0];
    if (this.id > -1) {
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subscriptionUnits => {
          for (let i = 0; i < subscriptionUnits.length; i++) {
            if (subscriptionUnits[i].subscription.name === this.subscription.name)
              this.isSubscribed = true;
          }
        }
      );
      this.userService.getUserById(this.id).subscribe(
        user => {
          this.user = user;
          this.user.isAdmin = user.isAdmin;
        }
      );
    }
  }

  ban() {
    this.http.banSubscription(toNumber(this.subscriptionId)).subscribe(
      subscription => this.subscription = subscription
    );
  }

  unBan() {
    this.http.unBanSubscription(toNumber(this.subscriptionId)).subscribe(
      subscription => this.subscription = subscription
    );
  }

  getSubscription() {
    this.subscriptionId = this.route.snapshot.paramMap.get('id');
    this.http.getSubscriptionById(toNumber(this.subscriptionId)).subscribe(subscription => {
      this.subscription = subscription;
    });
  }

  periodDecision(selectDOMElement) {
    let days: number;
    if (selectDOMElement.selectedIndex === 0)
      days = 30;
    else if (selectDOMElement.selectedIndex === 1)
      days = 90;
    else if (selectDOMElement.selectedIndex === 2)
      days = 365;
    this.subscribe(days)
  }

  subscribe(days: number) {
    if (!this.user.isBanned) {
      let subscriptionUnit = new SubscriptionUnit(null, this.id, this.subscription, days, true, true);
      this.subscriptionUnitService.saveSubscriptionUnit(subscriptionUnit).subscribe(
        subscriptionUnit => {
          if (subscriptionUnit !== null) {
            this.isSubscribed = true;
            this.notEnoughMoney = false;
          } else {
            this.notEnoughMoney = true;
          }
        });
    }
  }

  unsubscribe() {
    if (!this.user.isBanned) {
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subscriptionUnits => {
          for (let i = 0; i < subscriptionUnits.length; i++) {
            if (subscriptionUnits[i].subscription.name === this.subscription.name) {
              this.subscriptionUnitService.deleteSubscriptionUnit(subscriptionUnits[i]).subscribe(
                subscriptionUnit => this.isSubscribed = false
              );
            }
          }
        }
      );
    }
  }
}
