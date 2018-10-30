import {Component} from '@angular/core';
import {BillingAccount} from '../../../../shared/billingAccount';
import {User} from '../../../../shared/user';

@Component({
  selector: 'createBillingAccount',
  templateUrl: './createBillingAccount.component.html',
  styleUrls: ['./createBillingAccount.component.css']
})

export class CreateBillingAccountComponent {

  private user: User;

  createBillingAccount(name: string, creditCardNumber: string,
                       password: string, passwordRepeated: string) {
    this.user = new User('1', '1', '1@mail.ru', false);
    let newBillingAccount: BillingAccount;
    if (password === passwordRepeated) {
      newBillingAccount = new BillingAccount(this.user.login, name, password, creditCardNumber, 0);
    }
    console.log(newBillingAccount);
  }
}
