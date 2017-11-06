import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';


const routes = {
  getCourseById: (id: number) => `/courses/id/${id}`,
  getAllCourses: () => '/resources/courses/all',
  getAllMajors: () => '/resources/majors/all',
  getCoursesByMajorId: (mid: number) => `/resources/courses/major/${mid}`,
  addStudentToClass: (sid: string, cid: number) => `/resources/classes/id/${cid}/${sid}`,
  dropStudentFromClass: (sid: string, cid: number) => `/resources/classes/id/${cid}/${sid}`,
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

  getAllMajors(): Observable<string> {
    return this.http.get(routes.getAllMajors())
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not load majors'));
  }

  getAllCourses(): Observable<string> {
    return this.http.get(routes.getAllCourses())
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not load courses'));
  }

  getCoursesByMajorId(majorId: number): Observable<string> {
    return this.http.get(routes.getCoursesByMajorId(majorId))
      .map((res: Response) => res.json())
      .catch((res:Response) => Observable.of(res.json()));
  }

  addStudentToClass(studentId: string, classId: number): Observable<string> {
    return this.http.put(routes.addStudentToClass(studentId, classId), '')
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not add student to class'));
  }

  dropStudentFromClass(studentId: string, classId: number): Observable<string> {
    return this.http.delete(routes.dropStudentFromClass(studentId, classId), '')
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not load courses'));
  }

  getGpa(): Observable<any> {
    return Observable.of(3.4);
  }

}