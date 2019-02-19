import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {HomeService} from'../service/home.service';

@Component({
  selector: 'app-personnal',
  templateUrl: './personnal.component.html',
  styleUrls: ['./personnal.component.css'],
providers: [ HomeService ]
})
export class PersonnalComponent implements OnInit {

    positions: Array<any>;
    positionsSelect = null;

    degrees: Array<any>;
    degreesSelect = null;

    genders: Array<any>;
    gendersSelect = null;

    religions: Array<any>;
    religionsSelect = null;

    educations: Array<any>;
    educationsSelect = null;

    jobId : string;
    identificationNumber : string;
    fname : string;
    lname : string;
    birthday = null;
    nationality : string;
    extraction  : string;
    major : string;
    phone : string;
    email : string;
  constructor(  private homeservice: HomeService ,
                private httpClient: HttpClient,
                private route: ActivatedRoute,
                private router: Router ) { }

  ngOnInit() {

   this.homeservice.getpo().subscribe(data => {
         this.positions = data;
        console.log(this.positions);
    });

    this.homeservice.getdegree().subscribe(data => {
         this.degrees = data;
        console.log(this.degrees);
    });

     this.homeservice.getgender().subscribe(data => {
         this.genders = data;
        console.log(this.genders);
    });

    this.homeservice.getreligion().subscribe(data => {
         this.religions = data;
        console.log(this.religions);
    });

     this.homeservice.geteducation().subscribe(data => {
         this.educations = data;
        console.log(this.educations);
    });
  }
  save(){
 if(this.religionsSelect === null || this.educationsSelect === null || this.gendersSelect === null || this.positionsSelect === null|| this.degreesSelect === null || this.birthday === null || this.fname === null || this.lname === null || this.jobId === null|| this.nationality === null|| this.extraction === null || this.identificationNumber === null || this.major === null|| this.phone === null || this.email === null ){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      }else {
  this.httpClient.post('http://localhost:8080/personnals/'+this.religionsSelect+'/'+this.educationsSelect+'/'+this.gendersSelect+'/'+this.positionsSelect+'/'+this.degreesSelect+'/'+this.birthday+'/'+this.fname+'/'+this.lname+'/'+this.jobId+'/'+this.nationality+'/'+this.extraction+'/'+this.identificationNumber+'/'+this.major+'/'+this.phone+'/'+this.email,{}).subscribe()
  alert('บันทึกสำเร็จ');
  }

}cancel(){
   this.router.navigate(['mainhome']);
     }
}

