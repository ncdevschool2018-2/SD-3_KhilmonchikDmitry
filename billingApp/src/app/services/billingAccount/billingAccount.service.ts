import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from "rxjs";
import {BillingAccount} from "../../shared/BillingAccount";

@Injectable()
export class BillingAccountService {

  constructor(private http: HttpClient) {
  }

  public getBillingAccountsByOwnerId(id: number): Observable<BillingAccount[]> {
    let params = new HttpParams().set('id', id.toString());
    return this.http.get<BillingAccount[]>('/api/ba/get-by-ownerid', {params: params});
  }

  public createBillingAccount(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('/api/ba/save', billingAccount);
  }

  public deleteBillingAccount(billingAccount: BillingAccount) {
    return this.http.delete('/api/ba/delete/' + billingAccount.id + '?id=' + billingAccount.id +
      '&password=' + billingAccount.password);
  }

  public addMoney(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('/api/ba/add-money', billingAccount);
  }

  public ban(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('/api/ba/ban', billingAccount);
  }

  public unBan(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('/api/ba/unban', billingAccount);
  }

}
