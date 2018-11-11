import {Component, OnInit} from '@angular/core';
import {SubscriptionService} from '../../../../services/subscription/subscription.service';
import {Subscription} from '../../../../shared/Subscription';

@Component({
  selector: 'subscriptionsList',
  templateUrl: './subscriptionsList.component.html',
  styleUrls: ['./subscriptionsList.component.css']
})

export class SubscriptionsListComponent implements OnInit {

  subscriptions: Subscription[];

  constructor(private subscriptionService: SubscriptionService) {
  }

  ngOnInit() {
    this.subscriptionService.getSubscriptions().subscribe(subscriptions => this.subscriptions = subscriptions);
  }
}
