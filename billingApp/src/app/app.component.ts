import {Component, OnInit} from '@angular/core';
import {HttpService} from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'billingApp';
  subscriptions: any;

  ngOnInit() {
    this.http.getSubscriptions()
      .subscribe(subscriptions => this.subscriptions = subscriptions, () => alert('error'));
  }

  constructor(private http: HttpService) {
  }
}
