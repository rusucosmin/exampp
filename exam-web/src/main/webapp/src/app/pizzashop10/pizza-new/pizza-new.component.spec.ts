import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaNewComponent } from './pizza-new.component';

describe('PizzaNewComponent', () => {
  let component: PizzaNewComponent;
  let fixture: ComponentFixture<PizzaNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PizzaNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
