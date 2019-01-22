import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NursRoomComponent } from './nursroom.component';

describe('NurseRoomComponent', () => {
  let component: NursRoomComponent;
  let fixture: ComponentFixture<NursRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NursRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NursRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
