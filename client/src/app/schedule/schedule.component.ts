// Angular packages
import {
  Component,
  OnInit,
  ChangeDetectionStrategy,
  ViewChild,
  TemplateRef
} from '@angular/core';
import { NgFor } from '@angular/common';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import {
  Observable
} from 'rxjs/Rx';

import {
  startOfDay,
  endOfDay,
  subDays,
  addDays,
  endOfMonth,
  isSameDay,
  isSameMonth,
  addHours,
  startOfMonth,
  startOfWeek,
  endOfWeek
} from 'date-fns';
import { RRule } from 'rrule';

// Services
import { RegistrarService } from '../registrar.service';
import { AuthenticationService }  from '../core/authentication/authentication.service';

// angular-calendar
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent
} from 'angular-calendar';

import * as _ from 'lodash';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.scss']
})
export class ScheduleComponent implements OnInit {
  @ViewChild('modalContent') modalContent: TemplateRef<any>;

  semesters: Semester[];
  courses: Course[];
  classes: Class[];
  filteredClasses: Class[];

  view: string = 'month';

  viewDate: Date = new Date();

  events: CalendarEvent[] = [];

  eventClicked({ event }: { event: CalendarEvent }): void {
    console.log('Event clicked', event);
  }

  activeDayIsOpen: boolean = true;

  constructor(
    private registrarService: RegistrarService,
    private authenticationService: AuthenticationService,
    private modal: NgbModal
  ) { }

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
        this.viewDate = date;
      }
    }
  }

  getAllSemesters() {
    return this.registrarService.getSemesters()
    .subscribe((semesters: any) => {

    });
  }

  ngOnInit() {
    Observable.forkJoin(
      this.registrarService.getSemesters(),
      this.registrarService.getStudentClasses(this.authenticationService.userInfo.id)
    ).subscribe((results: any) => {
      console.log(results);
      this.semesters = results[0];
      this.semesters.forEach(semester => {
        let prefix = semester.season.charAt(0).toUpperCase() + semester.season.slice(1).toLowerCase();
        this.events.push(
          {
            title: prefix + ' classes begin',
            color: colors.yellow,
            start: new Date(semester.firstClassDate),
            allDay: true
          },
          {
            title: prefix + ' classes end',
            color: colors.yellow,
            start: new Date(semester.lastClassDate),
            allDay: true
          },
          {
            title: prefix + ' final exams begin',
            color: colors.yellow,
            start: new Date(semester.firstExamDate),
            allDay: true
          },
          {
            title: prefix + ' final exams end',
            color: colors.yellow,
            start: new Date(semester.lastExamDate),
            allDay: true
          },
          {
            title: prefix + ' registration opens',
            color: colors.yellow,
            start: new Date(semester.classRegistrationDate),
            allDay: true
          },
          {
            title: prefix + ' add/drop deadline',
            color: colors.yellow,
            start: new Date(semester.dropAddDeadlineDate),
            allDay: true
          }
        );
      });

      this.classes = results[1];
      var recurringEvents: RecurringEvent[] = [];
      this.classes.forEach(sClass => {
        recurringEvents.push({
          title: sClass.courseAbbreviation + sClass.courseNumber,
          color: colors.blue,
          start: this.getSemesterFirstClassDate(sClass.semesterSeason, sClass.semesterYear),
          until: this.getSemesterLastClassDate(sClass.semesterSeason, sClass.semesterYear),
          rrule: {
            freq: RRule.WEEKLY,
            byweekday: [
              RRule.MO
            ]
          }
        });
      });

      const startOfPeriod: any = {
        month: startOfMonth,
        week: startOfWeek,
        day: startOfDay
      };

      const endOfPeriod: any = {
        month: endOfMonth,
        week: endOfWeek,
        day: endOfDay
      };

      recurringEvents.forEach(event => {
        const rule: RRule = new RRule(
          Object.assign({}, event.rrule, {
            dtstart: event.start,
            until: event.until
          })
        );

        rule.all().forEach(date => {
          this.events.push(
            Object.assign({}, event, {
              start: new Date(date)
            })
          );
        });
      });
    });
  }

  getSemesterFirstClassDate(season: string, year: number): Date {
    var date = new Date();
    this.semesters.forEach(semester => {
      if(semester.season == season && semester.year == year) {
        date = new Date(semester.firstClassDate);
        return date;
      }
    });
    return date;
  }

   getSemesterLastClassDate(season: string, year: number): Date {
    var date = new Date();
    this.semesters.forEach(semester => {
      if(semester.season == season && semester.year == year) {
        date = new Date(semester.lastClassDate);
        return date;
      }
    });
    return date;
  }

  filterClassesForSemester(semester: Semester) {
    if(this.classes) {
      return this.classes.filter(sClass => {
        return sClass.semesterSeason == semester.season && sClass.semesterYear == semester.year;
      });
    }
    else {
      return [];
    }
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
  days: string[],
  startTime: string,
  endTime: string
}

interface Class {
  buildingId: number,
  buildingName?: string,
  classId: number,
  courseAbbreviation: string,
  courseId: number,
  courseName: string,
  courseNumber: number,
  days: string[],
  enrollmentCount: number,
  instructorFirstName: string,
  instructorId: number,
  instructorLastName: string,
  online: boolean,
  roomId: number,
  roomNumber: number,
  semesterSeason: string,
  semesterYear: number,
  size: number,
  startTime: string,
  stopTime: string
}

interface RecurringEvent {
  title: string;
  color: any;
  start: Date;
  until: Date;
  rrule?: {
    freq: RRule.Frequency;
    bymonth?: number;
    bymonthday?: number;
    byweekday?: RRule.Weekday[];
  };
}