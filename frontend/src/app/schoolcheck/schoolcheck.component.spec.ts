import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolcheckComponent } from './schoolcheck.component';

describe('SchoolcheckComponent', () => {
  let component: SchoolcheckComponent;
  let fixture: ComponentFixture<SchoolcheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchoolcheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchoolcheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
