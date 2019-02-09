import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowsportequipmentComponent } from './borrowsportequipment.component';

describe('BorrowsportequipmentComponent', () => {
  let component: BorrowsportequipmentComponent;
  let fixture: ComponentFixture<BorrowsportequipmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorrowsportequipmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrowsportequipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
