import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubscriptionsListComponent } from './modules/subscriptions/components/subscriptionsList/subscriptionsList.component';
import {SubscriptionDetailsComponent} from './modules/subscriptions/components/subscriptionDetails/subscriptionDetails.component';

const routes: Routes = [
  { path: 'subscriptions', component: SubscriptionsListComponent },
  { path: '', redirectTo: '/subscriptions',
  pathMatch: 'full'},
  { path: 'details/:id', component: SubscriptionDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
