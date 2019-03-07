import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  gender: Array<any>;
  gederSelect = null;

  nationality: Array<any>;
  nationalitySelect = null;

  religions: Array<any>;
  religionSelect = null;

  username :string;
  num : String;


  constructor(private homeservice: HomeService ,
              private httpClient: HttpClient,
              private route: ActivatedRoute,
              private router: Router  ) {

    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;

    }
  }
  ngOnInit() {
    this.homeservice.getgender().subscribe(data => {
      this.gender = data;
      console.log(this.gender);
    });

    this.homeservice.getreligion().subscribe(data => {
      this.religions = data;
      console.log(this.religions);
    });

    this.homeservice.getnationality().subscribe(data => {
      this.nationality = data;
      console.log(this.nationality);
    });
  }

  save(){
 if(this.gederSelect == null || this.nationalitySelect == null || this.username == null || this.religionSelect == null|| this.num == null){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      }else {
    this.httpClient.post('http://localhost:8080/students/' +this.gederSelect+'/'+this.nationalitySelect+'/'+this.religionSelect+'/'+ this.username+'/'+this.num+'/',{}).subscribe()
    alert('บันทึกสำเร็จ');

  }
}

}

