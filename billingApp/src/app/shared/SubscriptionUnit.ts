import {Subscription} from "./Subscription";

export class SubscriptionUnit {
  public id: number;
  public userId: number;
  public subscription: Subscription;
  public daysLeft: number;
  public willBeRenewed: boolean;
  public status: boolean;

  constructor(id: number, userId: number, subscription: Subscription, daysLeft: number, willBeRenewed: boolean, status: boolean) {
    this.id = id;
    this.userId = userId;
    this.subscription = subscription;
    this.daysLeft = daysLeft;
    this.willBeRenewed = willBeRenewed;
    this.status = status;
  }
}
