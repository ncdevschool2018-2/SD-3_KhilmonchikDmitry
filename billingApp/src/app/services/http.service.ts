import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../shared/User';
import {BillingAccount} from '../shared/BillingAccount';
import {map} from 'rxjs/operators';

@Injectable()
export class HttpService {

  readonly usersUrl = 'assets/users.json';
  readonly subscriptionsUrl = 'assets/subscriptions.json';
  readonly billingAccountsUrl = 'assets/billing_accounts.json';

  constructor(private http: HttpClient) {}

  getSubscriptions(): Observable<any> {
    return this.http.get(this.subscriptionsUrl);
  }

  getSubscriptionsByFilter(name: string): Observable<any> {
    return this.http.get(this.subscriptionsUrl)
      .pipe(
        map(subscriptions => {
          return (<any>subscriptions).filter(subscription => subscription.name === name);
        })
      );
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

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }
}
