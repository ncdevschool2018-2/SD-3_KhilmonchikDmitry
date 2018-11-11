export class Subscription {
  public name: String;
  public description: String;
  public perMonth: number;
  public perThreeMonth: number;
  public perYear: number;

  public SubscriptionViewModel(name: String, description: String, perMonth: number, perThreeMonth: number, perYear: number) {
    this.name = name;
    this.description = description;
    this.perMonth = perMonth;
    this.perThreeMonth = perThreeMonth;
    this.perYear = perYear;
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
