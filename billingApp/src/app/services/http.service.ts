import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../shared/user';
import {BillingAccount} from '../shared/billingAccount';

@Injectable()
export class HttpService {

  readonly usersUrl = 'assets/users.json';
  readonly subscriptionsUrl = 'assets/subscriptions.json';
  readonly billingAccountsUrl = 'assets/billing_accounts.json';

  constructor(private http: HttpClient) {}

  getSubscriptions(): Observable<any> {
    return this.http.get(this.subscriptionsUrl);
  }

  postToUsers(user: User): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post<User>(this.usersUrl, user, httpOptions);
  }

  postToBillingAccounts(billingAccount: BillingAccount): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post<BillingAccount>(this.billingAccountsUrl, billingAccount, httpOptions);
  }
}
