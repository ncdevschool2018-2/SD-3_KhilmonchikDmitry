import {Component} from '@angular/core';
import {User} from '../../../../shared/user';

@Component({
  selector: 'adminAccount',
  templateUrl: './adminAccount.component.html',
  styleUrls: ['./adminAccount.component.css']
})

export class AdminAccountComponent {
  users: User[] = [
    new User('1', '1', '1@mail.ru'),
    new User('2', '2', '2@mail.ru'),
    new User('3', '3', '3@mail.ru')
  ];
}
