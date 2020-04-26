import {Component} from '@angular/core';
import {User} from '../../../../shared/User';
import {HttpService} from '../../../../services/http.service';
import {BillingAccount} from '../../../../shared/BillingAccount';
import {UserService} from "../../../../services/user/user.service";
import {BillingAccountService} from "../../../../services/billingAccount/billingAccount.service";
import {Observable} from "rxjs";
import {UserIDService} from "../../../../services/userID.service";
import {Router} from "@angular/router";

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {
  user: User;
  billingAccount: BillingAccount;
  wrongData: boolean;

  constructor(private userHttp: UserService, private billingHttp: BillingAccountService,
              private userIdService: UserIDService, private router: Router) {
    this.wrongData = false;
  }

  createUser(login: string, password: string, passwordRepeated: string, email: string) {
    var emailRegExp = new RegExp('(?:[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])')
    if (password === passwordRepeated && password !== '' && login !== '' && email !== '' &&
    emailRegExp.test(email) && password.length > 5 && login.length > 5) {
      this.user = new User(null, login, password, email, false);
    } else {
      this.user = null;
    }
  }

  createBillingAccount(creditCardNumber: string, billingAccountName: string,
                       billingAccountPassword: string, billingAccountPasswordRepeated: string) {
    if (billingAccountPassword === billingAccountPasswordRepeated && billingAccountPassword !== '' && billingAccountName !== ''
      && creditCardNumber !== '' && billingAccountPassword.length > 5 &&
      billingAccountPassword.length > 5 && creditCardNumber.length > 5) {
      this.billingAccount = new BillingAccount(null, null, creditCardNumber, billingAccountName, billingAccountPassword, 0);
    } else {
      this.billingAccount = null;
    }
  }

  createAccount(login: string, password: string, passwordRepeated: string, email: string,
                creditCardNumber: string, billingAccountName: string,
                billingAccountPassword: string, billingAccountPasswordRepeated: string) {
    this.createUser(login, password, passwordRepeated, email);
    this.createBillingAccount(creditCardNumber, billingAccountName, billingAccountPassword,
      billingAccountPasswordRepeated);
    if(this.user === null || this.billingAccount === null) {
      console.log(this.user);
      console.log(this.billingAccount);
      this.wrongData = true;
      return;
    }
    this.billingHttp.createBillingAccount(this.billingAccount).subscribe(
      billingAccount => {
        this.userHttp.createUser(this.user, billingAccount.id).subscribe(
          user => {
            this.userIdService.setID(user.id);
            this.router.navigate([''])
          }
        )
      }
    );
  }
}
