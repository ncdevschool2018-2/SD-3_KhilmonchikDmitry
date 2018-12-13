import {Component, OnInit} from '@angular/core';
import {SubscriptionService} from '../../../../services/subscription/subscription.service';
import {Subscription} from '../../../../shared/Subscription';
import {SubscriptionsShareService} from "../../../../services/subscriptionsShare.service";

@Component({
  selector: 'subscriptionsList',
  templateUrl: './subscriptionsList.component.html',
  styleUrls: ['./subscriptionsList.component.css']
})

export class SubscriptionsListComponent implements OnInit {

  subscriptions: Subscription[];

  constructor(private subscriptionShareService: SubscriptionsShareService) {
  }

  ngOnInit() {
    this.subscriptionShareService.data$.subscribe(
      subscriptions =>
        this.subscriptions = subscriptions
    )
  }
}
