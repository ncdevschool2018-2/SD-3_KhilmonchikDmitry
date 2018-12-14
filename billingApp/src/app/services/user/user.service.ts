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

  getUser(login: string, password: string): Observable<User> {

    let params = new HttpParams().set('login', login);
    params = params.set('password', password);
    return this.http.get<User>('http://localhost:8080/api/ua/getbydata', {params: params});
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

}
