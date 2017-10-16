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
  startOfDay,
  endOfDay,
  subDays,
  addDays,
  endOfMonth,
  isSameDay,
  isSameMonth,
  addHours
} from 'date-fns';

// Services
import { ScheduleService } from '../schedule.service';
import { CourseService } from '../course.service';

// angular-calendar
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent
} from 'angular-calendar';

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

  view: string = 'month';

  viewDate: Date = new Date();

  events: CalendarEvent[] = [];

  eventClicked({ event }: { event: CalendarEvent }): void {
    console.log('Event clicked', event);
  }

  activeDayIsOpen: boolean = true;

  constructor(
    private scheduleService: ScheduleService,
    private courseService: CourseService,
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

  ngOnInit() {
    this.scheduleService.getSemesters()
    .subscribe((semesters: any) => {
      this.semesters = semesters;
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
    });

    this.courseService.getCourses()
    .subscribe((courses: any) => {
      console.log(courses);
      this.courses = courses;
      this.courses.forEach(course => {
        // Fake it for now, we may have to readjust anyway later on
        this.events.push(
          {
            title: course.id,
            color: colors.blue,
            start: new Date()
          }
        );
      });
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
  days: string[],
  startTime: string,
  endTime: string
}
