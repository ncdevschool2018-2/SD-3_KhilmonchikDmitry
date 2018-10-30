export class User {
  constructor (public login: string, public password: string, public email: string, public isAdmin: boolean = false) {}
}
