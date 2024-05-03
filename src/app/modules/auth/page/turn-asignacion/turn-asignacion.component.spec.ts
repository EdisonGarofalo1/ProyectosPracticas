import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TurnAsignacionComponent } from './turn-asignacion.component';

describe('TurnAsignacionComponent', () => {
  let component: TurnAsignacionComponent;
  let fixture: ComponentFixture<TurnAsignacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TurnAsignacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TurnAsignacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
