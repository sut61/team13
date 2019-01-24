import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  onClickSubmit(body){


    this.http.post("http://localhost:8080/user/login",body).subscribe(
      data => {
        console.log("Login  success");
        localStorage.setItem("user",JSON.stringify(data));
        //this.location.go();
        this.router.navigate(["./home/mainhome"]);
      },
      error => {
        console.log("Error", error);
        alert("username หรือ password ผิด");
      }
    );
  }

  constructor(private http: HttpClient, private router: Router ) { }

  ngOnInit() {   if(localStorage.getItem("user") != null)
    this.router.navigate(["all"]);
  }

}
