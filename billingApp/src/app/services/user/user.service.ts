import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../../shared/User";

@Injectable()

export class UserService {

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<any> {
    return this.http.post('http://localhost:8080/api/ua/getall', null);
  }

  getUser(login: string, password: string): Observable<any> {
    return this.http.post('http://localhost:8080/api/ua/getbydata?login=' + login, password);
  }

  getUserById(id: number): Observable<User> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<User>('http://localhost:8080/api/ua/getbyid', {params: params});
  }

  createUser(user: User, activeBillingAccountId: number) {
    return this.http.post<User>('http://localhost:8080/api/ua/save?activeBillingAccountId='+activeBillingAccountId, user);
  }

  ban(user: User) {
    return this.http.post<User>('http://localhost:8080/api/ua/ban', user);
  }

  unBan(user: User) {
    return this.http.post<User>('http://localhost:8080/api/ua/unban', user);
  }

  changeActiveBillingAccount(user: User, billingAccountId: number) {
    return this.http.post<User>('http://localhost:8080/api/ua/changeBillingAccount?billingAccountId=' + billingAccountId, user);
  }

}
