import {Subscription} from "./Subscription";

export class SubscriptionUnit {
  public ownerId: number;
  public subscription: Subscription;
  public daysLeft: number;
  public willBeRenewed: boolean;
  public status: boolean;
}
