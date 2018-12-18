import {Component, OnInit} from '@angular/core';
import {BillingAccount} from "../../../../shared/BillingAccount";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {UserIDService} from "../../../../services/userID.service";
import {UserService} from "../../../../services/user/user.service";
import {isSuccess} from "@angular/http/src/http_utils";
import {Router} from "@angular/router";

@Component({
  selector: 'manageBillingAccount',
  templateUrl: './manageBillingAccount.component.html',
  styleUrls: ['./manageBillingAccount.component.css']
})

export class ManageBillingAccountComponent implements OnInit {

  private billingAccounts: BillingAccount[];
  public id;
  public wrongData: boolean;

  constructor(private http: BillingAccountService,
              private userIdService: UserIDService,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.wrongData = false;
    this.id = this.userIdService.getID()[0];
    this.http.getBillingAccountsByOwnerId(this.id).subscribe(billingAccounts => {
      this.billingAccounts = billingAccounts;
    });
  }

  deleteBillingAccount(billingAccountId: number, password: string) {
    let billingAccount: BillingAccount;
    billingAccount = new BillingAccount(billingAccountId, null, null, null, password, null);
    this.http.deleteBillingAccount(billingAccount).subscribe();
  }

  addMoney(name: string, password: string, creditCardNumber: string, sum: string) {
    let billingAccount: BillingAccount = new BillingAccount(null, this.id, creditCardNumber, name, password, Number(sum));
    this.http.addMoney(billingAccount).subscribe(
      billingAccount => {
        if(billingAccount !== null) {
          this.router.navigate(['../user/' + this.id]);
          this.wrongData = false;
        } else {
          this.wrongData = true;
        }
      }
    );
  }

  changeActiveBillingAccount(billingAccount: BillingAccount) {
    this.userService.getUserById(this.id).subscribe(
      user => {
        this.userService.changeActiveBillingAccount(user, billingAccount.id).subscribe();
      }
    )
  }
}
