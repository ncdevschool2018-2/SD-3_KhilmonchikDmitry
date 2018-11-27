import {Subscription} from "./Subscription";

export class SubscriptionUnit {
  public userId: number;
  public subscription: Subscription;
  public daysLeft: number;
  public willBeRenewed: boolean;
  public status: boolean;


  constructor(userId: number, subscription: Subscription, daysLeft: number, willBeRenewed: boolean, status: boolean) {
    this.userId = userId;
    this.subscription = subscription;
    this.daysLeft = daysLeft;
    this.willBeRenewed = willBeRenewed;
    this.status = status;
  }
}
