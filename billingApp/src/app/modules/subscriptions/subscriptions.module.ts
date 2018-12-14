import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SubscriptionsListComponent} from './components/subscriptionsList/subscriptionsList.component';
import {ButtonsModule} from 'ngx-bootstrap';
import {NgxPaginationModule} from 'ngx-pagination';
import {HeaderComponent} from './components/header/header.component';
import {RouterModule} from '@angular/router';
import {SubscriptionDetailsComponent} from './components/subscriptionDetails/subscriptionDetails.component';
import {LoginComponent} from './components/login/login.component.';
import {RegistrationComponent} from './components/registration/registration.component';
import {CreateBillingAccountComponent} from './components/createBillingAccount/createBillingAccount.component';
import {UserSubscriptionsComponent} from './components/userSubscriptions/userSubscriptions.component';
import {UserBillingAccountsComponent} from './components/userBillingAccounts/userBillingAccounts.component';
import {ProfileDetailsComponent} from './components/profileDetails/profileDetails.component';
import {AdminAccountComponent} from './components/adminAccount/adminAccount.component';
import {ManageBillingAccountComponent} from './components/manageBillingAccount/manageBillingAccount.component';
import {CreateSubscriptionComponent} from "./components/createSubscription/createSubscription.component";

@NgModule({
  imports: [
    CommonModule,
    ButtonsModule,
    NgxPaginationModule,
    RouterModule
  ],
  exports: [
    SubscriptionsListComponent,
    HeaderComponent,
    SubscriptionDetailsComponent,
    LoginComponent,
    RegistrationComponent,
    CreateBillingAccountComponent,
    UserSubscriptionsComponent,
    UserBillingAccountsComponent,
    ProfileDetailsComponent,
    AdminAccountComponent,
    ManageBillingAccountComponent,
    CreateSubscriptionComponent
  ],
  declarations: [
    SubscriptionsListComponent,
    HeaderComponent,
    SubscriptionDetailsComponent,
    LoginComponent,
    RegistrationComponent,
    CreateBillingAccountComponent,
    UserSubscriptionsComponent,
    UserBillingAccountsComponent,
    ProfileDetailsComponent,
    AdminAccountComponent,
    ManageBillingAccountComponent,
    CreateSubscriptionComponent
  ],
  providers: []
})
export class SubscriptionsModule {

}
