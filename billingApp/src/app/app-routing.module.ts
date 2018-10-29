import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubscriptionsListComponent } from './modules/subscriptions/components/subscriptionsList/subscriptionsList.component';
import {SubscriptionDetailsComponent} from './modules/subscriptions/components/subscriptionDetails/subscriptionDetails.component';
import {LoginComponent} from './modules/subscriptions/components/login/login.component.';
import {RegistrationComponent} from './modules/subscriptions/components/registration/registration.component';

const routes: Routes = [
  { path: 'subscriptions', component: SubscriptionsListComponent },
  { path: '', redirectTo: '/subscriptions',
  pathMatch: 'full'},
  { path: 'details/:id', component: SubscriptionDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
