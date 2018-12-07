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
    return this.http.get<BillingAccount[]>('http://localhost:8080/api/ba/getbyownerid', {params: params});
  }

  public createBillingAccount(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('http://localhost:8080/api/ba/save', billingAccount);
  }

  public deleteBillingAccount(billingAccount: BillingAccount) {
    return this.http.delete('http://localhost:8080/api/ba/delete/' + billingAccount.id + '?id=' + billingAccount.id +
      '&password=' + billingAccount.password);
  }

  public checkBillingAccountPassword(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('http://localhost:8080/api/ba/checkpasswordbyid', billingAccount);
  }

  public addMoney(billingAccount: BillingAccount) {
    return this.http.post<BillingAccount>('http://localhost:8080/api/ba/addMoney', billingAccount);
  }

}
