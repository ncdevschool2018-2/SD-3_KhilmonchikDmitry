import {Component, Input, OnInit, Output} from '@angular/core';
import {SubscriptionsShareService} from '../../../../services/subscriptionsShare.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {
  @Input() subscriptionsObs = this.ShareService.data$;
  subscriptions;

  constructor(private ShareService: SubscriptionsShareService) {
  }

  ngOnInit() {
    this.ShareService.loadSubscriptions();
    this.subscriptionsObs.subscribe( subscriptions => this.subscriptions = subscriptions);
  }

  newSubscriptions(category: string) {
    this.ShareService.sortSubscriptions(category);
  }

  searchSubscriptions(name: string) {
    this.ShareService.searchSubscriptions(name);
  }
}
