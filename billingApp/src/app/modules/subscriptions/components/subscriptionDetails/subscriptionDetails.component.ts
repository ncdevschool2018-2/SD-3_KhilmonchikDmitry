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
  id;

  constructor(private http: SubscriptionService, private route: ActivatedRoute,
              private userIdService: UserIDService, private subscriptionUnitService: SubscriptionUnitService) {
    this.subscription = new Subscription();
  }

  ngOnInit() {
    this.getSubscription();
    this.id = this.userIdService.getID()[0];
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
}
