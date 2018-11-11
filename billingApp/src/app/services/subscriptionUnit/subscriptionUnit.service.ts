import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SubscriptionUnit} from "../../shared/SubscriptionUnit";

@Injectable()

export class SubscriptionUnitService {

  constructor(private http: HttpClient) {
  }

  public getSubscriptionUnitsById(id: number): Observable<SubscriptionUnit[]> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<SubscriptionUnit[]>('http://localhost:8080/api/subsunits/getbyid', {params: params});
  }

}
