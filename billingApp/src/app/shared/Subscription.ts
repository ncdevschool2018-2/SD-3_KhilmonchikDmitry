export class Subscription {
  public id: number;
  public name: String;
  public description: String;
  public perMonth: number;
  public perThreeMonth: number;
  public perYear: number;
  public isBanned: boolean;

  public SubscriptionViewModel(name: String, description: String, perMonth: number, id: number,
                               perThreeMonth: number, perYear: number, isBanned: boolean) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.perMonth = perMonth;
    this.perThreeMonth = perThreeMonth;
    this.perYear = perYear;
    this.isBanned = isBanned;
  }

  getName() {
    return this.name;
  }

  setName(name: String) {
    this.name = name;
  }

  setDescription(description: String) {
    this.description = description;
  }

  getPerMonth() {
    return this.perMonth;
  }

  setPerMonth(perMonth: number) {
    this.perMonth = perMonth;
  }

  getPerThreeMonth() {
    return this.perThreeMonth;
  }

  setPerThreeMonth(perThreeMonth: number) {
    this.perThreeMonth = perThreeMonth;
  }

  getPerYear() {
    return this.perYear;
  }

  setPerYear(perYear: number) {
    this.perYear = perYear;
  }

  getDescription() {
    return this.description;
  }
}
