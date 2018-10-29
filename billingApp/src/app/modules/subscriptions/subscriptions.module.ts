import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { SubscriptionsListComponent } from './components/subscriptionsList/subscriptionsList.component';
import {ButtonsModule} from 'ngx-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';
import {HeaderComponent} from './components/header/header.component';
import {RouterModule} from '@angular/router';
import {SubscriptionDetailsComponent} from './components/subscriptionDetails/subscriptionDetails.component';
import {LoginComponent} from './components/login/login.component.';
import {RegistrationComponent} from './components/registration/registration.component';

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
    RegistrationComponent
  ],
  declarations: [
    SubscriptionsListComponent,
    HeaderComponent,
    SubscriptionDetailsComponent,
    LoginComponent,
    RegistrationComponent
  ],
  providers: []
})
export class SubscriptionsModule {

}
