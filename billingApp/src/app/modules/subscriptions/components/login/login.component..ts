import {Component} from '@angular/core';
import {User} from '../../../../shared/User';
import {UserIDService} from '../../../../services/userID.service';
import {UserService} from "../../../../services/user/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  public usersList: User[];
  private user: User;

  constructor(private http: UserService,
              private userIDService: UserIDService,
              private router: Router) {
  }

  signIn(login: string, password: string): void {
    this.http.getUser(login, password).subscribe(
      userRet => {
        console.log(userRet);
        if(userRet !== null) {
          this.user = userRet;
          this.userIDService.setID(userRet.id);
        } else {

        }
      });
  }

}
