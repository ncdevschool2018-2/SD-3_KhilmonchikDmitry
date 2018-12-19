import {Component} from '@angular/core';
import {BillingAccount} from '../../../../shared/BillingAccount';
import {User} from '../../../../shared/User';
import {UserIDService} from "../../../../services/userID.service";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {Router} from "@angular/router";

@Component({
  selector: 'createBillingAccount',
  templateUrl: './createBillingAccount.component.html',
  styleUrls: ['./createBillingAccount.component.css']
})

export class CreateBillingAccountComponent {

  id;
  wrongData: boolean;

  constructor(private userIdService: UserIDService, private http: BillingAccountService, private router: Router) {
    this.id = this.userIdService.getID()[0];
    this.wrongData = false;
  }

  createBillingAccount(name: string, creditCardNumber: string,
                       password: string, passwordRepeated: string) {
    if(this.id >= 0) {
      let newBillingAccount: BillingAccount;
      if (password === passwordRepeated) {
        newBillingAccount = new BillingAccount(null, this.id, creditCardNumber, name, password, 0);
        this.router.navigate(['/user/' + this.id]);
        this.http.createBillingAccount(newBillingAccount).subscribe(
          error => {
            this.wrongData = true;
          }
        );
      } else {
        this.wrongData = true;
      }
    }
  }
}
