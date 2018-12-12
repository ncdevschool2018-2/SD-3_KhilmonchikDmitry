import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {UserService} from "./user/user.service";

const INIT_DATA = [];

@Injectable()
export class UserIDService {
  private loggedUserID = new BehaviorSubject(INIT_DATA);
  data$: Observable<any> = this.loggedUserID.asObservable();
  private isAdmin = new BehaviorSubject(INIT_DATA);
  admin: Observable<any> = this.isAdmin.asObservable();

  constructor(private userService: UserService) {
    this.loggedUserID.next([-1]);
    this.isAdmin.next([false]);
  }

  getID() {
    return this.loggedUserID.getValue();
  }

  getIsAdmin(): boolean {
    return this.isAdmin.getValue()[0];
  }

  setID(id: number) {
    this.loggedUserID.next([id]);
    if(id > -1) {
      this.userService.getUserById(id).subscribe(
        user => this.isAdmin.next([user.isAdmin])
      )
    } else {
      this.isAdmin.next([false]);
    }
  }
}
