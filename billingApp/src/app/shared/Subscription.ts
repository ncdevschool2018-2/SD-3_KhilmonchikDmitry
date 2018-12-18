export class Subscription {
  public id: number;
  public name: String;
  public description: String;
  public category: number;
  public perMonth: number;
  public perThreeMonths: number;
  public perYear: number;
  public isBanned: boolean;

  constructor(id: number, name: String, description: String, category: number,
              perMonth: number, perThreeMonths: number, perYear: number, isBanned: boolean) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
    this.perMonth = perMonth;
    this.perThreeMonths = perThreeMonths;
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
    return this.perThreeMonths;
  }

  setPerThreeMonth(perThreeMonth: number) {
    this.perThreeMonths = perThreeMonth;
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
