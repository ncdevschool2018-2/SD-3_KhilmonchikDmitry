import {Component, OnInit, Output} from '@angular/core';
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
  id;
  user: User;
  subscriptionId: any;


  constructor(private http: SubscriptionService, private route: ActivatedRoute,
              private userIdService: UserIDService,
              private subscriptionUnitService: SubscriptionUnitService,
              private userService: UserService) {
    this.subscription = new Subscription();
  }

  ngOnInit() {
    this.getSubscription();
    this.isSubscribed = false;
    this.id = this.userIdService.getID()[0];
    if(this.id > -1) {
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subscriptionUnits => {
          for(let i = 0; i < subscriptionUnits.length; i++) {
            if(subscriptionUnits[i].subscription.name === this.subscription.name)
              this.isSubscribed = true;
          }
        }
      );
      this.userService.getUserById(this.id).subscribe(
        user => {
          this.user = user;
          console.log(this.user);
        }
      );
    }
  }

  ban() {
    this.http.banSubscription(toNumber(this.subscriptionId)).subscribe();
  }

  unBan() {
    this.http.unBanSubscription(toNumber(this.subscriptionId)).subscribe();
  }

  getSubscription() {
    this.subscriptionId = this.route.snapshot.paramMap.get('id');
    this.http.getSubscriptionById(toNumber(this.subscriptionId)).subscribe(subscription => {
      this.subscription = subscription;
    });
  }

  subscribe() {
    let subscriptionUnit = new SubscriptionUnit(null, this.id, this.subscription, 30, true, true);
    console.log(subscriptionUnit);
    this.subscriptionUnitService.saveSubscriptionUnit(subscriptionUnit).subscribe(
      subscriptionUnit =>
        console.log(subscriptionUnit)
    );
  }

  unsubscribe() {
    this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
      subsctiptionUnits => {
        for(let i = 0; i < subsctiptionUnits.length; i++) {
          if(subsctiptionUnits[i].subscription.name === this.subscription.name) {
            this.subscriptionUnitService.deleteSubscriptionUnit(subsctiptionUnits[i]);
          }
        }
      }
    );
  }
}
