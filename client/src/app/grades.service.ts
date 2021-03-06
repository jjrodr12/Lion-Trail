import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GradesService {

  constructor(private http: Http) { }

  getCourses(): Observable<any> {
    return Observable.of([
      {
        id: 'SWENG123',
        curGrade: 'A',
        semesterSeason: 'FALL',
        semesterYear: '2017',
        finalGrade: 'A',
        days: ['MO', 'WE']
      },
      {
        id: 'PHIL456',
        curGrade: 'B',
        semesterSeason: 'FALL',
        semesterYear: '2017',
        finalGrade: 'B',
        days: ['MO', 'WE']
      },
      {
        id: 'ENG789',
        curGrade: 'C',
        semesterSeason: 'SPRING',
        semesterYear: '2018',
        days: ['MO', 'WE']
      }
    ]);
  }

  getGpa(): Observable<any> {
    return Observable.of(3.4);
  }

}
