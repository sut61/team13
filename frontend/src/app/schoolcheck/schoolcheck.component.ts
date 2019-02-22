import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {HomeService} from '../service/home.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-schoolcheck',
  templateUrl: './schoolcheck.component.html',
  styleUrls: ['./schoolcheck.component.css'],
  providers: [ HomeService ]
})
export class SchoolcheckComponent implements OnInit {
  students: Array<any>;
  status: Array<any>;
  classrooms: Array<any>;
  parent: Array<any>;
  StudentSelect = null;
  ClassroomSelect = null;
  StatusSelect = null;

  datecome = null;
  ParentSelect : null;
  Parrents : string;

  No:Array<any>;
  constructor(private homeservice: HomeService ,
              private httpClient: HttpClient,
              private route: ActivatedRoute,
              private router: Router ) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    }
  }
  ngOnInit() {
    this.homeservice.getStudent().subscribe(data => {
      this.students = data;
      console.log(this.students);
    });
    this.homeservice.getClassrooms().subscribe(data => {
      this.classrooms = data;
      console.log(this.classrooms);
    });
    this.homeservice.getStatus().subscribe(data => {
      this.status = data;
      console.log(this.status);
    });
    this.homeservice.getSchoolcheck().subscribe(data => {
      this.No = data;
      console.log(data);
    });
    this.homeservice.getParent().subscribe(data => {
      this.parent = data;
      console.log(data);
    });

  }
  cancel(){
    this.router.navigated = false;
    this.router.navigate([this.router.url]);
    alert('ยกเลิก');
  }
  save(){
    if( this.ParentSelect === null || this.StatusSelect === null || this.ClassroomSelect === null || this.datecome === null || this.StudentSelect === null){
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {
      this.httpClient.post('http://localhost:8080/schoolcheck/'+this.StudentSelect+'/'+this.ClassroomSelect+'/'+this.datecome+'/'+this.StatusSelect+'/'+this.ParentSelect+'/'+this.Parrents,{}).subscribe()
      alert('บันทึกสำเร็จ');

    }
  }

}
