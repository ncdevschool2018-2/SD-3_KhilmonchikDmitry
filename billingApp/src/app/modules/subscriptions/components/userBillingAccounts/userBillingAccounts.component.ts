import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {BillingAccount} from "../../../../shared/BillingAccount";
import {UserIDService} from "../../../../services/userID.service";
import {User} from "../../../../shared/User";
import {UserService} from "../../../../services/user/user.service";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'userBillingAccounts',
  templateUrl: './userBillingAccounts.component.html',
  styleUrls: ['./userBillingAccounts.component.css']
})

export class UserBillingAccountsComponent implements OnInit {

  public billingAccounts: BillingAccount[];
  private displayId;
  private id;
  public user: User;
  private observedUser: User;
  interval: any;

  constructor(private http: BillingAccountService, private userIdService: UserIDService,
              private userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.displayId = this.route.snapshot.paramMap.get('id');
    this.id = this.userIdService.getID()[0];
    this.userService.getUserById(this.id).subscribe(
      user => this.user = user
    );
    this.refreshData();
    this.interval = setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  refreshData() {
    if(this.displayId > -1) {
      this.userService.getUserById(this.id).subscribe(
        user => {
          this.observedUser = user;
        }
      );
      this.http.getBillingAccountsByOwnerId(this.displayId).subscribe(billingAccounts => {
        this.billingAccounts = billingAccounts;
      });
    }
  }

  ban(billingAccount: BillingAccount) {
    this.http.ban(billingAccount).subscribe();
  }

  unBan(billingAccount: BillingAccount) {
    this.http.unBan(billingAccount).subscribe();
  }
}
