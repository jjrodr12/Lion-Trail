import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';

import { CalendarEvent } from 'angular-calendar';
//import { colors } from '../demo-utils/colors'; //

// Services
import { GradesService } from '../grades.service';
import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-grades',
  templateUrl: './grades.component.html',
  styleUrls: ['./grades.component.scss']
})
export class GradesComponent implements OnInit {

  semesters: Semester[];
  courses: Course[];
  gpa: number

  constructor(
    private scheduleService: ScheduleService,
    private gradesService: GradesService
  ) { }

  ngOnInit() {
    this.scheduleService.getSemesters()
    .subscribe((semesters: any) => {
      this.semesters = semesters;
    });

    this.gradesService.getCourses()
    .subscribe((courses: any) => {
      this.courses = courses;
    });

    this.gradesService.getGpa()
    .subscribe((gpa: any) => {
      this.gpa = gpa;
    });
  }

}

interface Semester {
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

interface Course {
  id: string,
  semesterSeason: string,
  semesterYear: number,
  curGrade: string,
  finalGrade?: string,
  completed?: boolean|false
}