export class BillingAccount {
  constructor (private owner: string, private name: string,
               private password: string, private creditCardNumber: string, private money: number) {}
}
