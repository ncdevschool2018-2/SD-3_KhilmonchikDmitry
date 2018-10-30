import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {SubscriptionsModule} from './modules/subscriptions/subscriptions.module';
import {HttpClientModule} from '@angular/common/http';
import {HttpService} from './services/http.service';
import {SubscriptionsShareService} from './services/subscriptionsShare.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    SubscriptionsModule,
    HttpClientModule
  ],
  providers: [
    HttpService,
    SubscriptionsShareService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
