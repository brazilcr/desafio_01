import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoUploadComponent } from './dialogo-upload.component';

describe('DialogoUploadComponent', () => {
  let component: DialogoUploadComponent;
  let fixture: ComponentFixture<DialogoUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogoUploadComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogoUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
