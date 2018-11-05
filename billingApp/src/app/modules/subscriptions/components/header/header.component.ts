import {Component, Input, OnInit, Output} from '@angular/core';
import {SubscriptionsShareService} from '../../../../services/subscriptionsShare.service';
import {UserIDService} from '../../../../services/userID.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {
  @Input() subscriptionsObs = this.ShareService.data$;
  subscriptions;
  @Input() loggedUserIDObs = this.userIDService.data$;
  loggedUserID;

  constructor(private ShareService: SubscriptionsShareService, private userIDService: UserIDService) {
  }

  ngOnInit() {
    this.ShareService.loadSubscriptions();
    this.subscriptionsObs.subscribe( subscriptions => this.subscriptions = subscriptions);
    this.loggedUserIDObs.subscribe(loggedUserID => this.loggedUserID = loggedUserID);
  }

  newSubscriptions(category: string) {
    this.ShareService.sortSubscriptions(category);
  }

  searchSubscriptions(name: string) {
    this.ShareService.searchSubscriptions(name);
  }

  logOut() {
    this.userIDService.setID(-1);
  }
}
