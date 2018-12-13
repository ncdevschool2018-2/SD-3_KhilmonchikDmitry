import {Component, OnInit} from '@angular/core';
import {User} from '../../../../shared/User';
import {UserService} from "../../../../services/user/user.service";

@Component({
  selector: 'adminAccount',
  templateUrl: './adminAccount.component.html',
  styleUrls: ['./adminAccount.component.css']
})

export class AdminAccountComponent implements OnInit {
  users: User[];
  interval: any;

  constructor(private http: UserService) {
  }

  ngOnInit() {
    this.refreshData();
    this.interval = setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  refreshData() {
    this.http.getAllUsers().subscribe(users=> this.users = users);
  }
}
