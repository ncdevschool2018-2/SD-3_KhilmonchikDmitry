import {Component} from '@angular/core';
import {User} from '../../../../shared/user';
import {HttpService} from '../../../../services/http.service';
import {BillingAccount} from '../../../../shared/billingAccount';

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {
  user: User;
  billingAccount: BillingAccount;

  constructor (private http: HttpService) { }

  createUser(login: string, password: string, passwordRepeated: string, email: string, creditCardNumber: string, billingAccountName: string,
             billingAccountPassword: string, billingAccountPasswordRepeated: string) {
    console.log(login, email, password, passwordRepeated, billingAccountName, creditCardNumber,
      billingAccountPassword, billingAccountPasswordRepeated);
    if (password === passwordRepeated && billingAccountPassword === billingAccountPasswordRepeated
      && password !== '' && login !== '' && email !== '' && billingAccountPassword !== '' && billingAccountName !== ''
      && creditCardNumber !== '') {
      this.user = new User(login, password, email);
      this.billingAccount = new BillingAccount(login, name, billingAccountPassword, creditCardNumber, 0);
      this.http.postToUsers(this.user);
      this.http.postToBillingAccounts(this.billingAccount);
    }
    if (password !== passwordRepeated) {
      console.log('passwords do not match!');
    }
    if (billingAccountPassword !== billingAccountPasswordRepeated) {
      console.log('billing account passwords do not match!');
    }
    switch ('') {
      case login:
        console.log('login empty');
        break;
      case password:
        console.log('password empty');
        break;
      case email:
        console.log('email empty');
        break;
      case billingAccountPassword:
        console.log('billingAccountPassword empty');
        break;
      case billingAccountName:
        console.log('billingAccountName empty');
        break;
      case creditCardNumber:
        console.log('creditCardNumber empty');
        break;
    }
  }
}
