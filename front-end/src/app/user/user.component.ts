import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {AddContactInfo} from "../auth/Add-Contact-Info";
import {SignUpInfo} from "../auth/signup-info";


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  board: string;
  errorMessage: string;
  contacts:any;
  addContactInfo: AddContactInfo;
  form: any = {};


  constructor(private userService:UserService) { }

  onSubmits() {

    console.log(this.form);
    this.addContactInfo = new AddContactInfo(
      this.form.firstNameDto,
      this.form.lastNameDto,
      this.form.numberPhoneDto);

    this.userService.addNewContact(this.addContactInfo).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

  ngOnInit() {
    this.userService.getAllContacts();
    console.log(this.getAllContacts())
  }

  processForm(){

    }

  getAllContacts(){
      this.userService.getAllContacts().subscribe(
        data => {this.contacts = data},
        err => console.log(err),
        () => console.log("Contacts loaded!")
      );}


}
