import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { HomeService } from '../service/home.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})


export class TableComponent implements OnInit {


  id: number;
  teachers: Array<any>;
  rooms: Array<any>;
  subjects: Array<any>;
  No:Array<any>;
  stt: any = {
    teacherSelect: '',
    RoomSelect: '',
    SubjectSelect: '',
    timeSelect:'',
    daySelect:'',
    deleteSelect:''
  };

  constructor(private homeservice: HomeService ,
              private httpClient: HttpClient,
              private route: ActivatedRoute,
              private router: Router  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    }


  }

  ngOnInit() {

    this.homeservice.getTeacher().subscribe(data => {
      this.teachers = data;
      console.log(data);
    });
    this.homeservice.getRoom().subscribe(data => {
      this.rooms = data;
      console.log(data);
    });
    this.homeservice.getSubject().subscribe(data => {
      this.subjects = data;
      console.log(data);
    });
    this.homeservice.getStudyTimeTable().subscribe(data => {
      this.No = data;
      console.log(data);
    });
  }


  cancel(){
    this.router.navigated = false;
    this.router.navigate([this.router.url]);
  }
  save() {
    if (this.stt.teacherSelect === '' || this.stt.RoomSelect === '' || this.stt.SubjectSelect === '' || this.stt.timeSelect === ''|| this.stt.daySelect === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/stt/add/'+ this.stt.daySelect + ','+ this.stt.timeSelect + ','  + this.stt.teacherSelect + ',' + this.stt.RoomSelect + ',' +this.stt.SubjectSelect, this.stt)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
            alert('บันทึกเรียบร้อย');
            this.router.navigated = false;
            this.router.navigate([this.router.url]);
          },
          error => {
            console.log('Rrror', error);
          }
        );
    }
  }
  Delete(){
    this.httpClient.post('http://localhost:8080/delete/'+ this.stt.deleteSelect, this.stt)
      .subscribe(
        data => {
          console.log('Delete Request is successful', data);
          this.router.navigated = false;
          this.router.navigate([this.router.url]);
        },
        error => {
          console.log('Rrror', error);
        }
      );
  }

}
