import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';


const routes = {
  getCourseById: (id: number) => `/courses/id/${id}`
};

@Injectable()
export class RegistrarService {

  constructor(private http: Http) { }

  getCourses(): Observable<any> {
    return Observable.of([
      {
        id: 'SWENG123',
        semesterSeason: 'FALL',
        semesterYear: '2017',
        days: ['MO', 'WE'],
        startTime: '13:00',
        endTime: '14:00'
      },
      {
        id: 'PHIL456',
        semesterSeason: 'FALL',
        semesterYear: '2017',
        days: ['MO', 'WE'],
        startTime: '13:00',
        endTime: '14:00'
      },
      {
        id: 'ENG789',
        semesterSeason: 'SPRING',
        semesterYear: '2018',
        days: ['MO', 'WE'],
        startTime: '13:00',
        endTime: '14:00'
      }
    ]);
  }

  getCourseById(id: number): Observable<string> {
    return this.http.get(routes.getCourseById(id))
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not load courses'));
  }

  getGpa(): Observable<any> {
    return Observable.of(3.4);
  }

}
