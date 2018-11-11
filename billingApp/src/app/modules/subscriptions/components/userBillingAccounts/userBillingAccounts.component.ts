import {Component, OnInit} from '@angular/core';
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {BillingAccount} from "../../../../shared/BillingAccount";
import {UserIDService} from "../../../../services/userID.service";

@Component({
  selector: 'userBillingAccounts',
  templateUrl: './userBillingAccounts.component.html',
  styleUrls: ['./userBillingAccounts.component.css']
})

export class UserBillingAccountsComponent implements OnInit{

  private billingAccounts: BillingAccount[];
  private id;
  public selectedBillingAccountIndex: number;

  constructor(private http: BillingAccountService, private userIdService: UserIDService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.http.getBillingAccountsByOwnerId(this.id).subscribe(billingAccounts => {
      this.billingAccounts = billingAccounts;
      console.log(billingAccounts);
    });
    this.selectedBillingAccountIndex = 0;
  }

}
