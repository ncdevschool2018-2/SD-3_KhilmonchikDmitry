import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpService} from './http.service';
import {map} from 'rxjs/operators';

const INIT_DATA = [];

@Injectable()
export class SubscriptionsShareService {
  private ethalon = new BehaviorSubject(INIT_DATA);
  private subscriptionsSource = new BehaviorSubject(INIT_DATA);
  data$: Observable<any> = this.subscriptionsSource.asObservable();

  constructor(private http: HttpService) {}

  loadSubscriptions() {
    this.http.getSubscriptions()
      .subscribe(subscriptions => {
        this.subscriptionsSource.next(subscriptions);
        this.ethalon.next(subscriptions);
      });
  }

  sortSubscriptions(category: string) {
    this.subscriptionsSource.next(this.ethalon.getValue().filter(subscription => subscription.category === category));
  }

  searchSubscriptions(name: string) {
    // this.subscriptionsSource.next(this.ethalon.getValue().filter(subscription => subscription.name === name));
    console.log(name);
    return this.http.getSubscriptions()
      .pipe(
        map(subscriptions => {
          return subscriptions.filter(subscription => subscription.name === name);
        })
      );
  }
}
