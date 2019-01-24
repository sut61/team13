import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import{HomeService}from'../service/home.service';

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
  constructor(  private  controller:HomeService ,
                private   httpClient:HttpClient, private router:Router) { }

  ngOnInit() {

   this.controller.getpo().subscribe(data => {
         this.positions = data;
        console.log(this.positions);
    });

    this.controller.getdegree().subscribe(data => {
         this.degrees = data;
        console.log(this.degrees);
    });

     this.controller.getgender().subscribe(data => {
         this.genders = data;
        console.log(this.genders);
    });

    this.controller.getreligion().subscribe(data => {
         this.religions = data;
        console.log(this.religions);
    });

     this.controller.geteducation().subscribe(data => {
         this.educations = data;
        console.log(this.educations);
    });
  }

insert(){

  this.httpClient.post('http://localhost:8080/personnal/'+this.religionsSelect+'/'+this.educationsSelect+'/'+this.gendersSelect+'/'+this.positionsSelect+'/'+this.degreesSelect+'/'+this.birthday+'/'+this.fname+'/'+this.lname+'/'+this.jobId+'/'+this.nationality+'/'+this.extraction+'/'+this.identificationNumber+'/'+this.major+'/'+this.phone+'/'+this.email,{}).subscribe()

}
cancel(){
   this.router.navigate(['mainhome'])
}
}
