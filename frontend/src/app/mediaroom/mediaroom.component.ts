import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Component({
  selector: 'app-mediaroom',
  templateUrl: './mediaroom.component.html',
  styleUrls: ['./mediaroom.component.css']
})
export class MediaroomComponent implements OnInit {
  prefixs = [];
  activitys = [];
  mediaRooms = [];
  text: String;

  onClickSubmit(data) {
    console.log(data);
    this.http.post("http://localhost:8080/Applicant/addApplicant/",data).subscribe(
      data => {
        console.log("POST Request is successful ", data);
        //alert("บันทึกสำเร็จ")
        this.text="บันทึกสำเร็จ"
      },
      error => {
        console.log("Error", error);
        //alert("บันทึกผิดพลาด" + error)
        this.text="กรุณากรอกข้อมูลให้ครบ"
      }

    );
  }

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/Prefix').subscribe(
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

    this.http.get("http://localhost:8080/Activity").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.activitys.push({
            value: data[index].activityId,
            viewValue: data[index].activity
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/MediaRoom").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.mediaRooms.push({
            value: data[index].mediaRoomId,
            viewValue: data[index].mediaRoom
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );
  }

}
