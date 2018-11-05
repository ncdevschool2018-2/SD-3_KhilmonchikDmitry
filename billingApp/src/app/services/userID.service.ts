import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';

const INIT_DATA = [];

@Injectable()
export class UserIDService {
  private loggedUserID = new BehaviorSubject(INIT_DATA);
  data$: Observable<any> = this.loggedUserID.asObservable();

  constructor() {
    this.loggedUserID.next([-1]);
  }

  getID() {
      return this.loggedUserID.getValue();
  }

  setID(id: number) {
    this.loggedUserID.next([id]);
  }
}
