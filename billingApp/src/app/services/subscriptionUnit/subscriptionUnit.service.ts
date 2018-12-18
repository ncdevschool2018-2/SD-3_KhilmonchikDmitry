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
    return this.http.get<SubscriptionUnit[]>('/api/subsunits/get-by-userid', {params: params});
  }

  public saveSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    return this.http.post<SubscriptionUnit>('/api/subsunits/save', subscriptionUnit);
  }

  public deleteSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    return this.http.delete('/api/subsunits/delete/' + subscriptionUnit.id + '?id=' + subscriptionUnit.id);
  }

  public changeStatusSubscriptionUnit(subscriptionUnit: SubscriptionUnit) {
    return this.http.post<SubscriptionUnit>('/api/subsunits/change-status', subscriptionUnit);
  }

}
