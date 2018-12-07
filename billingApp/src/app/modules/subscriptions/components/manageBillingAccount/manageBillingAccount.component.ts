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
    this.id = this.userIdService.getID()[0];
    this.http.getBillingAccountsByOwnerId(this.id).subscribe(billingAccounts => {
      this.billingAccounts = billingAccounts;
    });
  }

  deleteBillingAccount(billingAccountId: number, password: string) {
    let billingAccount: BillingAccount;
    billingAccount = new BillingAccount(billingAccountId, null, null, null, password, null);
    this.http.deleteBillingAccount(billingAccount).subscribe(result => console.log(result));
  }

  addMoney(name: string, password: string, creditCardNumber: string, sum: string) {
    let billingAccount: BillingAccount = new BillingAccount(null, this.id, creditCardNumber, name, password, Number(sum));
    this.http.addMoney(billingAccount).subscribe(
      billingAccount=> console.log(billingAccount)
    );
  }
}
