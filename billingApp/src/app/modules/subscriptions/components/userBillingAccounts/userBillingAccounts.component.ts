import {Component, OnInit} from '@angular/core';
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {BillingAccount} from "../../../../shared/BillingAccount";
import {UserIDService} from "../../../../services/userID.service";
import {User} from "../../../../shared/User";
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'userBillingAccounts',
  templateUrl: './userBillingAccounts.component.html',
  styleUrls: ['./userBillingAccounts.component.css']
})

export class UserBillingAccountsComponent implements OnInit {

  public billingAccounts: BillingAccount[];
  private id;
  public user: User;
  interval: any;

  constructor(private http: BillingAccountService, private userIdService: UserIDService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.refreshData();
    this.interval = setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  refreshData() {
    this.userService.getUserById(this.id).subscribe(
      user => {
        this.user = user;
      }
    );
    this.http.getBillingAccountsByOwnerId(this.id).subscribe(billingAccounts => {
      this.billingAccounts = billingAccounts;
      console.log(this.billingAccounts);
    });
  }

  ban(billingAccount: BillingAccount) {
    this.http.ban(billingAccount).subscribe(
      billingAccount1 => console.log(billingAccount1)
    );
  }

  unBan(billingAccount: BillingAccount) {
    this.http.unBan(billingAccount).subscribe();
  }
}
