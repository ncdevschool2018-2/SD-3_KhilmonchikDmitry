export class User {
  constructor (private login: string, private password: string, private email: string, private isAdmin: boolean = false) {}
}
