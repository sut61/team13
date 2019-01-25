import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolbookComponent } from './enrolbook.component';

describe('EnrolbookComponent', () => {
  let component: EnrolbookComponent;
  let fixture: ComponentFixture<EnrolbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnrolbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
