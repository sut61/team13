import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnalComponent } from './personnal.component';

describe('PersonnalComponent', () => {
  let component: PersonnalComponent;
  let fixture: ComponentFixture<PersonnalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonnalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

