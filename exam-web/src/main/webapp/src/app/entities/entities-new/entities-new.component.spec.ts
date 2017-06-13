import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntitiesNewComponent } from './entities-new.component';

describe('EntitiesNewComponent', () => {
  let component: EntitiesNewComponent;
  let fixture: ComponentFixture<EntitiesNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntitiesNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntitiesNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
