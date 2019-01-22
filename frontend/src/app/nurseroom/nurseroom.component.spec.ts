import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NurseRoomComponent } from './nurseroom.component';

describe('NurseRoomComponent', () => {
  let component: NurseRoomComponent;
  let fixture: ComponentFixture<NurseRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NurseRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NurseRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
