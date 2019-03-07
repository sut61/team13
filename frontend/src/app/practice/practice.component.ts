import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.css']
})
export class PracticeComponent implements OnInit {

  roomm: Array<any>;
  roommSelect = null;

  classroom: Array<any>;
  classroomSelect = null;

  building: Array<any>;
  buildingSelect = null;

  name :string;
  particulars : String;
  day : null;

  constructor(private homeservice: HomeService ,
              private httpClient: HttpClient,
              private route: ActivatedRoute,
              private router: Router  ) {

    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;

    }
  }
  ngOnInit() {
    this.homeservice.getclassroom().subscribe(data => {
      this.classroom = data;
      console.log(this.classroom);
    });

    this.homeservice.getroomm().subscribe(data => {
      this.roomm = data;
      console.log(this.roomm);
    });

    this.homeservice.getbuilding().subscribe(data => {
      this.building = data;
      console.log(this.building);
    });
  }

  save(){
  if(this.roommSelect == null || this.classroomSelect == null || this.name == null || this.buildingSelect == null|| this.particulars == null|| this.day == null){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      }else {
    this.httpClient.post('http://localhost:8080/practice/'+ this.buildingSelect+'/'+ this.classroomSelect+'/'+ this.roommSelect+'/'+ this.name+'/'+ this.particulars+'/'+ this.day+'/',{}).subscribe()
    alert('บันทึกสำเร็จ');

  }

}
}
