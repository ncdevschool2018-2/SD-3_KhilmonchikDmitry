import {Component} from '@angular/core';
import {BillingAccount} from '../../../../shared/BillingAccount';
import {User} from '../../../../shared/User';
import {UserIDService} from "../../../../services/userID.service";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";

@Component({
  selector: 'createBillingAccount',
  templateUrl: './createBillingAccount.component.html',
  styleUrls: ['./createBillingAccount.component.css']
})

export class CreateBillingAccountComponent {

  id;

  constructor(private userIdService: UserIDService, private http: BillingAccountService) {
    this.id = this.userIdService.getID();
  }

  createBillingAccount(name: string, creditCardNumber: string,
                       password: string, passwordRepeated: string) {
    if(this.id >= 0) {
      let newBillingAccount: BillingAccount;
      if (password === passwordRepeated) {
        newBillingAccount = new BillingAccount(1, this.id[0], '1', '1', '1', 0);
      }
      this.http.createBillingAccount(newBillingAccount);
      console.log(newBillingAccount);
    }
  }
}
