export class User {

  constructor (public id: number, public name: string, public password: string,
               public email: string, public isAdmin: boolean,
               public isBanned: boolean = false) {}
}
