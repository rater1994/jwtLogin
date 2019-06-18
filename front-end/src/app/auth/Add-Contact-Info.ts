export class AddContactInfo {
  firstNameDto: string;
  lastNameDto: string;
  numberPhoneDto: string;

  constructor(firstName: string, lastName: string, numberPhone: string) {
    this.firstNameDto = firstName;
    this.lastNameDto = lastName;
    this.numberPhoneDto = numberPhone;
  }
}
