export class BillingAccount {
  constructor (public id: number, public ownerId: number, public creditCardNumber: string,
               public name: string, public password: string,
               public money: number, public isBanned: boolean = false) {}
}
