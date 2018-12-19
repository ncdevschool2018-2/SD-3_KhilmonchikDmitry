import {Component, OnInit} from '@angular/core';
import {User} from '../../../../shared/User';
import {UserService} from "../../../../services/user/user.service";
import {UserIDService} from "../../../../services/userID.service";

@Component({
  selector: 'adminAccount',
  templateUrl: './adminAccount.component.html',
  styleUrls: ['./adminAccount.component.css']
})

export class AdminAccountComponent implements OnInit {
  users: User[];
  quantities: number[];
  interval: any;

  constructor(private userService: UserService, private userIdService: UserIDService) {
    this.quantities = new Array<number>();
  }

  ngOnInit() {
    if (this.userIdService.getID()[0] > -1) {
      this.refreshData();
      this.interval = setInterval(() => {
        this.refreshData();
      }, 5000);
    }
  }

  unBan(user: User) {
    if (user.isBanned)
      this.userService.unBan(user).subscribe();
  }

  ban(user: User) {
    if (!user.isBanned)
      this.userService.ban(user).subscribe();
  }

  refreshData() {
    this.userService.getAllUsers().subscribe(users => {
      this.users = users;
      this.getUserSubscriptionCount()
    });
  }

  getUserSubscriptionCount() {
    for (let i = 0; i < this.users.length; i++) {
      this.userService.getSubscriptionsQuantity(this.users[i].id).subscribe(
        quantity => {
          this.quantities[i] = quantity.valueOf();
        });
    }
  }
}
