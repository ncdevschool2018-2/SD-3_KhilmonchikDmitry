import {Component, OnInit} from '@angular/core';
import {BillingAccount} from "../../../../shared/BillingAccount";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {UserIDService} from "../../../../services/userID.service";

@Component({
  selector: 'manageBillingAccount',
  templateUrl: './manageBillingAccount.component.html',
  styleUrls: ['./manageBillingAccount.component.css']
})

export class ManageBillingAccountComponent implements OnInit {

  private billingAccounts: BillingAccount[];
  private id;

  constructor(private http: BillingAccountService, private userIdService: UserIDService) {
  }

  ngOnInit() {
    this.id = this.userIdService.getID();
    this.http.getBillingAccountsByOwnerId(this.id).subscribe(billingAccounts => {
      this.billingAccounts = billingAccounts;
    });
  }

}
