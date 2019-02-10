import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  styleUrls: ['./meeting.component.css']
})
export class MeetingComponent implements OnInit {

 category: Array<any>;
  categorySelect = null;

  person: Array<any>;
  personSelect = null;

  statusmeet: Array<any>;
  statusmeetSelect = null;

  topic : String;
  descrip : String;
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
    this.homeservice.getCategory().subscribe(data => {
      this.category = data;
      console.log(this.category);
    });

    this.homeservice.getPerson().subscribe(data => {
      this.person= data;
      console.log(this.person);
    });

    this.homeservice.getStatusmeet().subscribe(data => {
      this.statusmeet = data;
      console.log(this.statusmeet);
    });
  }

  save(){
  if(this.categorySelect === null || this.personSelect === null || this.statusmeetSelect === null || this.topic === null|| this.descrip === null|| this.day === null){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      }else {
    this.httpClient.post('http://localhost:8080/meeting/' +this.categorySelect+'/'+this.personSelect+'/'+this.statusmeetSelect+'/'+ this.topic+'/'+this.descrip+'/'+this.day+'/',{}).subscribe()
    alert('บันทึกสำเร็จ');

  }

}
}
