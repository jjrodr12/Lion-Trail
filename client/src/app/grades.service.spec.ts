import { TestBed, inject } from '@angular/core/testing';

import { GradesService } from './grades.service';

describe('GradesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GradesService]
    });
  });

  it('should be created', inject([GradesService], (service: GradesService) => {
    expect(service).toBeTruthy();
  }));
});
