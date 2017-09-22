import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ScheduleRoutingModule } from './schedule-routing.module';
import { ScheduleComponent } from './schedule.component';
import { ScheduleService } from './schedule.service';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    ScheduleRoutingModule
  ],
  declarations: [
    ScheduleComponent
  ],
  providers: [
    ScheduleService
  ]
})
export class ScheduleModule { }
