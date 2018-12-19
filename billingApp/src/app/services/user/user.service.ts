import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../../shared/User";

@Injectable()

export class UserService {

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<any> {
    return this.http.post('/api/ua/get-all', null);
  }

  getUser(login: string, password: string): Observable<any> {
    return this.http.post('/api/ua/get-by-data?login=' + login, password);
  }

  getUserById(id: number): Observable<User> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<User>('/api/ua/get-by-id', {params: params});
  }

  createUser(user: User, activeBillingAccountId: number) {
    return this.http.post<User>('/api/ua/save?activeBillingAccountId='+activeBillingAccountId, user);
  }

  ban(user: User) {
    return this.http.post<User>('/api/ua/ban', user);
  }

  unBan(user: User) {
    return this.http.post<User>('/api/ua/unban', user);
  }

  changeActiveBillingAccount(user: User, billingAccountId: number) {
    return this.http.post<User>('/api/ua/change-BillingAccount?billingAccountId=' + billingAccountId, user);
  }

  getSubscriptionsQuantity(id: number) {
    return this.http.get<number>('/api/ua/subscription-unit/quantity?id=' + id);
  }

}
