import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HomeService {
public API = '//localhost:8080';
getBooktype(): Observable<any>{
    return this.http.get(this.API + '/booktype'); }

  getbookcase(): Observable<any>{
    return this.http.get(this.API + '/bookcase');
  }

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
getpo(): Observable<any>{
    return this.http.get(this.API + '/position')
  }

  getdegree(): Observable<any>{
    return this.http.get(this.API + '/degree')
  }

  getgender(): Observable<any>{
    return this.http.get(this.API + '/gender')
  }

  getreligion(): Observable<any>{
    return this.http.get(this.API + '/religion')
  }

  geteducation(): Observable<any>{
    return this.http.get(this.API + '/education')
  }
  getnationality(): Observable<any>{
    return this.http.get(this.API + '/Nationality')
  }
  getTeacher(): Observable<any> {
    return this.http.get(this.API + '/personel');
  }
  getRoom():  Observable<any> {
    return this.http.get(this.API + '/Rooms');
  }
  getSubject(): Observable<any> {
    return this.http.get(this.API + '/Majors');
  }

  getStudyTimeTable(): Observable<any> {
    return this.http.get(this.API + '/Studytimetables');
  }
  getStatus(): Observable<any> {
    return this.http.get(this.API + '/Status');
  }
  getClassrooms(): Observable<any> {
    return this.http.get(this.API + '/Classrooms');
  }
  getParent(): Observable<any> {
    return this.http.get(this.API + '/Parents');
  }
  getSchoolcheck(): Observable<any> {
    return this.http.get(this.API + '/SchoolCh');
  }

 getbuilding(): Observable<any> {
    return this.http.get(this.API + '/Building');
  }
  getcla(): Observable<any> {
    return this.http.get(this.API + '/Cla');
  }
  getroomm(): Observable<any> {
    return this.http.get(this.API + '/Roomm');
    }
 getSportsE(): Observable<any> {
    return this.http.get(this.API + '/SportEquipment');
  }
  getPiece(): Observable<any> {
    return this.http.get(this.API + '/Piece');
    }
    getCategory(): Observable<any>{
      return this.http.get(this.API + '/Category');
    }
    getPerson(): Observable<any>{
      return this.http.get(this.API + '/Person');
    }
    getStatusmeet(): Observable<any>{
      return this.http.get(this.API + '/Statusmeet');
    }
}

