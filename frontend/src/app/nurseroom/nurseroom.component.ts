import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-nurseroom',
  templateUrl: './nurseroom.component.html',
  styleUrls: ['./nurseroom.component.css']
})
export class NurseRoomComponent implements OnInit {
  prefixs = [];
  symptoms = [];
  treatments = [];
  hospitals = [];
  
  onClickSubmit(data) {
      console.log(data);
      this.http.post("http://localhost:8080/PatientName/addPatientName/",data).subscribe(
      data => {
        console.log("POST Request is successful ", data);
        alert("บันทึกสำเร็จ")
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด " + error)
      }

    );
}
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/Prefix").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.prefixs.push({
            value: data[index].prefixId,
            viewValue: data[index].prefix
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/Symptom").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.symptoms.push({
            value: data[index].symptomId,
            viewValue: data[index].symptom
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/Treatment").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.treatments.push({
            value: data[index].treatmentId,
            viewValue: data[index].treatment
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/Hospital").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.hospitals.push({
            value: data[index].hospitalId,
            viewValue: data[index].hospital
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );
  }

}
