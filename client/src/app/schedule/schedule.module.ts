import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ScheduleRoutingModule } from './schedule-routing.module';
import { ScheduleComponent } from './schedule.component';
import { ScheduleService } from '../schedule.service';
import { CourseService } from '../course.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarModule } from 'angular-calendar';
import { CalendarHeaderComponent } from './calendar-header.component';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    ScheduleRoutingModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot()
  ],
  declarations: [
    ScheduleComponent,
    CalendarHeaderComponent
  ],
  providers: [
    ScheduleService,
    CourseService
  ]
})
export class ScheduleModule { }
