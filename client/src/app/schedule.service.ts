import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ScheduleService {

  constructor(private http: Http) { }

  getSemesters(): Observable<string> {
    return this.http.get('/resources/semesters/all')
      .map((res: Response) => res.json())
      .catch(() => Observable.of('Error, could not load semesters'));
  }

}
