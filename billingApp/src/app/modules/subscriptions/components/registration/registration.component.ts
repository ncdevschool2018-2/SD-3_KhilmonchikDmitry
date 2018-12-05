import {Component} from '@angular/core';
import {User} from '../../../../shared/User';
import {HttpService} from '../../../../services/http.service';
import {BillingAccount} from '../../../../shared/BillingAccount';
import {UserService} from "../../../../services/user/user.service";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {Observable} from "rxjs";

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {
  user: User;
  billingAccount: BillingAccount;

  constructor(private userHttp: UserService, private billingHttp: BillingAccountService) {
  }

  createUser(login: string, password: string, passwordRepeated: string, email: string) {
    if (password === passwordRepeated && password !== '' && login !== '' && email !== '') {
      this.user = new User(null, login, password, email);
    }
    if (password !== passwordRepeated) {
      console.log('passwords do not match!');
    }
  }

  createBillingAccount(creditCardNumber: string, billingAccountName: string,
                       billingAccountPassword: string, billingAccountPasswordRepeated: string) {
    if (billingAccountPassword === billingAccountPasswordRepeated && billingAccountPassword !== '' && billingAccountName !== ''
      && creditCardNumber !== '') {
      this.billingAccount = new BillingAccount(null, null, creditCardNumber, billingAccountName, billingAccountPassword, 0);
    }
  }

  createAccount(login: string, password: string, passwordRepeated: string, email: string,
                creditCardNumber: string, billingAccountName: string,
                billingAccountPassword: string, billingAccountPasswordRepeated: string) {
    this.createUser(login, password, passwordRepeated, email);
    this.createBillingAccount(creditCardNumber, billingAccountName, billingAccountPassword,
      billingAccountPasswordRepeated);
    this.billingHttp.createBillingAccount(this.billingAccount).subscribe(
      billingAccount => {
        this.userHttp.createUser(this.user, billingAccount.id).subscribe(
          user =>
            console.log(user)
        )
      }
    );
  }
}
