import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { HomeService } from '../service/home.service';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

export interface Major {
  value: string;
  viewValue: string;
}

export interface Grade {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-grade',
  templateUrl: './grade.component.html',
  styleUrls: ['./grade.component.css']
})
export class GradeComponent implements OnInit {
  majorrs: Array<any>;
  professors: Array<any>;
  students: Array<any>;
  gpa: Array<any>;

  MajorSelect= '';

  StudentSelect ='';


  GpaSelect ='';


  ProSelect = '' ;
  point:number;

  constructor(private homeservice: HomeService ,
              private httpClient: HttpClient,
              private route: ActivatedRoute,
              private router: Router  ) {


    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    }


  }

  ngOnInit() {
    this.homeservice.getStudent().subscribe(data => {
      this.students = data;
      console.log(this.students);
    });
    this.homeservice.getMajor().subscribe(data => {
      this.majorrs = data;
      console.log(this.majorrs);
    });
    this.homeservice.getProfessor().subscribe(data => {
      this.professors = data;
      console.log(this.professors);
    });
    this.homeservice.getgpa().subscribe(data => {
      this.gpa = data;
      console.log(this.gpa);
    });

  }
  cancel(){
    this.router.navigated = false;
    this.router.navigate([this.router.url]);
    alert('ยกเลิก');
  }
  save(){
    this.httpClient.post('http://localhost:8080/grade/'+this.point+'/'+this.GpaSelect+'/'+this.MajorSelect+'/'+this.ProSelect+'/'+this.StudentSelect,{}).subscribe()
    alert('บันทึกสำเร็จ');
  }

}
