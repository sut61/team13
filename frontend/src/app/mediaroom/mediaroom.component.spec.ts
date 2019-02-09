import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MediaroomComponent } from './mediaroom.component';

describe('MediaroomComponent', () => {
  let component: MediaroomComponent;
  let fixture: ComponentFixture<MediaroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MediaroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MediaroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
