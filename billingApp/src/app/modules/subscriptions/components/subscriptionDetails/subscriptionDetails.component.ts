import {Component, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {toNumber} from "ngx-bootstrap/timepicker/timepicker.utils";
import {Subscription} from "../../../../shared/Subscription";
import {UserIDService} from "../../../../services/userID.service";
import {SubscriptionUnitService} from "../../../../services/subscriptionUnit/subscriptionUnit.service";
import {SubscriptionUnit} from "../../../../shared/SubscriptionUnit";

@Component({
  selector: 'subscriptionsDetails',
  templateUrl: './subscriptionDetails.component.html',
  styleUrls: ['./subscriptionDetails.component.css']
})

export class SubscriptionDetailsComponent implements OnInit {
  @Output() subscription: Subscription;
  isSubscribed: boolean;
  id;

  constructor(private http: SubscriptionService, private route: ActivatedRoute,
              private userIdService: UserIDService,
              private subscriptionUnitService: SubscriptionUnitService) {
    this.subscription = new Subscription();
  }

  ngOnInit() {
    this.getSubscription();
    this.isSubscribed = false;
    this.id = this.userIdService.getID()[0];
    if(this.id > -1) {
      let subsctiptionUnits: SubscriptionUnit[];
      this.subscriptionUnitService.getSubscriptionUnitsById(this.id).subscribe(
        subsctiptionUnits => {
          for(let i = 0; i < subsctiptionUnits.length; i++) {
            if(subsctiptionUnits[i].subscription.name === this.subscription.name)
              this.isSubscribed = true;
          }
        }
      );
    }
  }

  getSubscription() {
    let id: any = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.http.getSubscriptionById(toNumber(id)).subscribe(subscription => {
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
