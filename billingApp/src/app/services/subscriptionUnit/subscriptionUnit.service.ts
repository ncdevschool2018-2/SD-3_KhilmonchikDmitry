import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SubscriptionUnit} from "../../shared/SubscriptionUnit";

@Injectable()

export class SubscriptionUnitService {

  constructor(private http: HttpClient) {
  }

  public getSubscriptionUnitsById(id: number): Observable<SubscriptionUnit[]> {
    let params = new HttpParams().set('userId', id.toString());
    return this.http.get<SubscriptionUnit[]>('http://localhost:8080/api/subsunits/getbyuserid', {params: params});
  }

  public saveSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    return this.http.post<SubscriptionUnit>('http://localhost:8080/api/subsunits/save', subscriptionUnit);
  }

  public deleteSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    console.log(subscriptionUnit.id);
    return this.http.delete('http://localhost:8080/api/subsunits/delete/' + subscriptionUnit.id + '?id=' + subscriptionUnit.id);
  }

  public changeStatusSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    return this.http.post<SubscriptionUnit>('http://localhost:8080/api/subsunits/changestatus', subscriptionUnit);
  }

}
