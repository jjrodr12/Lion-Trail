import { Component, OnInit } from '@angular/core';

import { ScheduleService } from './schedule.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  semesters: Semester[];

  constructor(private scheduleService: ScheduleService) { }

  ngOnInit() {
    this.scheduleService.getSemesters()
      .subscribe((semesters: any) => {
        this.semesters = semesters;
      });
  }

}

export interface Semester {
  id: number,
  season: string,
  year: number,
  firstClassDate: string,
  lastClassDate: string,
  firstExamDate: string
  lastExamDate: string,
  classRegistrationDate: string,
  dropAddDeadlineDate: string
}
