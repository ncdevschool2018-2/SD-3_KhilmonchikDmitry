import {Component, OnInit, Output} from '@angular/core';
import {HttpService} from '../../../../services/http.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'subscriptionsDetails',
  templateUrl: './subscriptionDetails.component.html',
  styleUrls: ['./subscriptionDetails.component.css']
})

export class SubscriptionDetailsComponent implements OnInit {
  @Output() subsctiption;

  constructor(private http: HttpService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getSubscription();
  }

  getSubscription() {
    let id: any = this.route.snapshot.paramMap.get('id');
    id--;
    this.http.getSubscriptions().subscribe(subscriptions => this.subsctiption = subscriptions[id]);
  }
}
