import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Subscription } from '../../shared/Subscription';

@Injectable()

export class SubscriptionService {

  constructor(private http: HttpClient) {
  }

  getSubscriptions(): Observable<Subscription[]> {
    return this.http.get<Subscription[]>('http://localhost:8080/api/subs/get');
  }

  getSubscriptionById(id: number): Observable<Subscription> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<Subscription>('http://localhost:8080/api/subs/getbyid', {params: params});
  }

  getSubscriptionByName(name: string): Observable<Subscription> {
    let params = new HttpParams().set('name', name);
    return this.http.get<Subscription>('http://localhost:8080/api/subs/getbyname', {params: params});
  }

  getSubscriptionByCategory(category: string): Observable<Subscription[]> {
    let params = new HttpParams().set('category', category);
    return this.http.get<Subscription[]>('http://localhost:8080/api/subs/getbycategory', {params: params});
  }

  saveSubscription(subscription: Subscription): Observable<Subscription> {
    return this.http.post<Subscription>('http://localhost:8080/api/subs/save', subscription);
  }

  banSubscription(id: number): Observable<Subscription> {
    return this.http.post<Subscription>('http://localhost:8080/api/subs/ban?id=' + id, id);
  }

  unBanSubscription(id: number): Observable<Subscription> {
    return this.http.post<Subscription>('http://localhost:8080/api/subs/unban?id=' + id, id);
  }

}
