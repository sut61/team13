import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mainhome',
  templateUrl: './mainhome.component.html',
  styleUrls: ['./mainhome.component.css']
})
export class MainhomeComponent implements OnInit {

  selectedIndex: number;
  transform: number;
  constructor() {
    this.selectedIndex = 0;
    this.transform = 100;
  }

  sliderArray = [
    {img: '../../assets/Img/5.jpg', alt: '', text: 'Suranaree University of Technology'},
    {img: '../../assets/Img/6.jpg', alt: '', text: 'Suranaree University of Technology'},
    {img: '../../assets/Img/3.jpg', alt: '', text: 'Suranaree University of Technology'},
    {img: '../../assets/Img/7.jpg', alt: '',  text: 'Suranaree University of Technology'},
    {img: '../../assets/Img/8.jpg', alt: '',  text: 'Suranaree University of Technology'}

  ];

  ngOnInit() {}

  selected(x) {
    this.downSelected(x);
    this.selectedIndex = x;

  }

  keySelected(x) {
    this.downSelected(x);
    this.selectedIndex = x;
  }
  downSelected(i) {
    this.transform =  100 - (i) * 50;
    this.selectedIndex = this.selectedIndex + 1;
    if(this.selectedIndex > 4) {
      this.selectedIndex = 0;
    }
  }
}
