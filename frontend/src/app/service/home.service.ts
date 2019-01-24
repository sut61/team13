import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HomeService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) {}

  getStudent(): Observable<any> {
    return this.http.get(this.API + '/Students');
  }
  getMajor(): Observable<any> {
    return this.http.get(this.API + '/Majors');
  }

  getProfessor(): Observable<any> {
    return this.http.get(this.API + '/Professors');
  }
  getgpa(): Observable<any> {
    return this.http.get(this.API + '/gpaa');
  }


}
