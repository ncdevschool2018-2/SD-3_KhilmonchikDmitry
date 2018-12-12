import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubscriptionsListComponent } from './modules/subscriptions/components/subscriptionsList/subscriptionsList.component';
import {SubscriptionDetailsComponent} from './modules/subscriptions/components/subscriptionDetails/subscriptionDetails.component';
import {LoginComponent} from './modules/subscriptions/components/login/login.component.';
import {RegistrationComponent} from './modules/subscriptions/components/registration/registration.component';
import {CreateBillingAccountComponent} from './modules/subscriptions/components/createBillingAccount/createBillingAccount.component';
import {ProfileDetailsComponent} from './modules/subscriptions/components/profileDetails/profileDetails.component';
import {ManageBillingAccountComponent} from './modules/subscriptions/components/manageBillingAccount/manageBillingAccount.component';
import {AdminAccountComponent} from "./modules/subscriptions/components/adminAccount/adminAccount.component";

const routes: Routes = [
  { path: 'subscriptions', component: SubscriptionsListComponent },
  { path: '', redirectTo: '/subscriptions',
  pathMatch: 'full'},
  { path: 'details/:id', component: SubscriptionDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'createBillingAccount', component: CreateBillingAccountComponent },
  { path: 'profileDetails', component: ProfileDetailsComponent },
  { path: 'manageBillingAccount', component: ManageBillingAccountComponent },
  { path: 'adminAccount', component: AdminAccountComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
