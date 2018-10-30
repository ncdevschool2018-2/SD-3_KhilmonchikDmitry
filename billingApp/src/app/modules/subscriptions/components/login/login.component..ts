import {Component} from '@angular/core';
import {User} from '../../../../shared/user';
import {HttpService} from '../../../../services/http.service';
import {HeaderComponent} from '../header/header.component';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  public usersList: User[];

  constructor(private http: HttpService) {
  }

  eee(login: string, password: string) {
    this.http.getUsers().subscribe(
      users => {
        this.usersList = users as User[];
      }
    );
    console.log(this.usersList);
    let isLogged = false;
    let user: User;
    this.usersList.forEach(function (i) {
      if (i.login === login && i.password === password) {
        isLogged = true;
        user = i;
      }
    });
  }

}
