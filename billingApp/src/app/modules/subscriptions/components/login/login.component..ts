import {Component} from '@angular/core';
import {User} from '../../../../shared/user';
import {HttpService} from '../../../../services/http.service';
import {UserIDService} from '../../../../services/userID.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  public usersList: User[];

  constructor(private http: HttpService, private userIDService: UserIDService) {
  }

  eee(login: string, password: string) {
    this.userIDService.setID(2);
  }

}
