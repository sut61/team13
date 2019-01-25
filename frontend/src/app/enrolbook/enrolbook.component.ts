import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HomeService } from '../service/home.service';
import { Router } from '@angular/router';
export interface PeriodicElement { }

@Component({
  selector: 'app-enrolbook',
  templateUrl: './enrolbook.component.html',
  styleUrls: ['./enrolbook.component.css']
})
export class EnrolbookComponent implements OnInit {

  memberType: Array<any>;
  memberTypeSelect = '';

  genders: Array<any>;
  bookTypeSelect = [];
  bookcaseSelect = [];
  author:String;
  quantity:String;
  bookname:string;
  booktypes:string;
  bookcases:string


  constructor(private homeservice: HomeService,private httpClient: HttpClient,
              private router: Router,) { }

  ngOnInit() {
    this.homeservice.getBooktype().subscribe(data => {
      this.booktypes = data;
      console.log(this.booktypes);
    });
    this.homeservice.getbookcase().subscribe(data => {
      this.bookcases = data;
      console.log(this.bookcases);
    });
  }
  insert() {



    this.httpClient.post('http://localhost:8080/Books/' + this.bookname + '/' + this.quantity + '/' + this.author+ '/' +
      this.bookTypeSelect + '/' + this.bookcaseSelect , {})
      .subscribe(data => {
          console.log('successful',data);
          alert("สำเร็จ");
        },
        error => {
          console.log('Error',error);

        });

  }

}
