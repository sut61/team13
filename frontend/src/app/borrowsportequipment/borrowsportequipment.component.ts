import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {HomeService} from '../service/home.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-borrowsportequipment',
  templateUrl: './borrowsportequipment.component.html',
  styleUrls: ['./borrowsportequipment.component.css'],
  providers: [ HomeService ]
})
export class BorrowsportequipmentComponent implements OnInit {
sportequipment: Array<any>;
    sportequipmentSelect = null;

    piece: Array<any>;
    pieceSelect = null;

    classrooms: Array<any>;
    classroomSelect = null;

    name_borrow : string;
    name_lender : string;
    day_borrow = null;
    day_return = null;


  constructor(private homeservice : HomeService ,
              private httpClient : HttpClient,
              private route : ActivatedRoute,
              private router : Router) {
             this.router.routeReuseStrategy.shouldReuseRoute = function() {
                 return false;
                 }
}

  ngOnInit() {
   this.homeservice.getClassrooms().subscribe(data => {
      this.classrooms = data;
      console.log(this.classrooms);
    });
      this.homeservice.getPiece().subscribe(data => {
      this.piece = data;
      console.log(this.piece);
    });
      this.homeservice.getSportsE().subscribe(data => {
      this.sportequipment = data;
      console.log(this.sportequipment);
    });
  }
cancel(){
    this.router.navigated = false;
    this.router.navigate([this.router.url]);
    alert('ยกเลิก');
  }
  save(){
    if( this.name_borrow == null || this.classroomSelect == null || this.sportequipmentSelect == null || this.pieceSelect == null || this.day_borrow == null || this.day_return == null || this.name_lender == null){
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
   }else {
      this.httpClient.post('http://localhost:8080/borrowsportsequipment/'+this.name_borrow+'/'+this.classroomSelect+'/'+this.sportequipmentSelect+'/'+this.pieceSelect+'/'+this.day_borrow+'/'+this.day_return+'/'+this.name_lender,{}).subscribe()
      alert('บันทึกสำเร็จ');
   //   window.location.reload()
   }
  }

}
