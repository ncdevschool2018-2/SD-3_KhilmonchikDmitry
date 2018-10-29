import {Component, Input, OnInit} from '@angular/core';
import {SubscriptionsShareService} from '../../../../services/subscriptionsShare.service';

@Component({
  selector: 'subscriptionsList',
  templateUrl: './subscriptionsList.component.html',
  styleUrls: ['./subscriptionsList.component.css']
})

export class SubscriptionsListComponent implements OnInit {

  @Input() subscriptionsObs = this.ShareService.data$;
  subscriptions;

  constructor(private ShareService: SubscriptionsShareService) {
  }

  ngOnInit() {
    this.ShareService.loadSubscriptions();
    this.subscriptionsObs.subscribe( subscriptions => this.subscriptions = subscriptions);
  }
}
