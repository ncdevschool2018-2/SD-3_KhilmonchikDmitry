import {Component} from '@angular/core';
import {User} from '../../../../shared/User';
import {HttpService} from '../../../../services/http.service';
import {UserIDService} from '../../../../services/userID.service';
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  public usersList: User[];
  private user: User;

  constructor(private http: UserService, private userIDService: UserIDService) {
  }

  signIn(login: string, password: string): void {
    this.http.getUser(login, password).subscribe(
      userRet => {this.user = userRet;
      this.userIDService.setID(userRet.id);
      });
  }

}
