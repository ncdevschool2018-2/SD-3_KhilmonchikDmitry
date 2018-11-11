import {Component, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {toNumber} from "ngx-bootstrap/timepicker/timepicker.utils";
import {Subscription} from "../../../../shared/Subscription";

@Component({
  selector: 'subscriptionsDetails',
  templateUrl: './subscriptionDetails.component.html',
  styleUrls: ['./subscriptionDetails.component.css']
})

export class SubscriptionDetailsComponent implements OnInit {
  @Output() subscription: Subscription;

  constructor(private http: SubscriptionService, private route: ActivatedRoute) {
    this.subscription = new Subscription();
  }

  ngOnInit() {
    this.getSubscription();
  }

  getSubscription() {
    let id: any = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.http.getSubscriptionById(toNumber(id)).subscribe(subscription => {
      this.subscription = subscription;
    });
  }
}
