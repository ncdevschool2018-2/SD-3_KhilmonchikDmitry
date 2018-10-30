import {Component} from '@angular/core';
import {BillingAccount} from '../../../../shared/billingAccount';

@Component({
  selector: 'userSubscriptions',
  templateUrl: './userSubscriptions.component.html',
  styleUrls: ['./userSubscriptions.component.css']
})

export class UserSubscriptionsComponent {
  subscriptions: any[] = [
    { subscription: 'Yandex Music', daysLeft: 38, willBeRenewed: true, status: true },
    { subscription: 'Spotify', daysLeft: 2, willBeRenewed: true, status: true },
    { subscription: 'Apple Music', daysLeft: 181, willBeRenewed: true, status: true },
  ];
}
