import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ScheduleRoutingModule } from './schedule-routing.module';
import { ScheduleComponent } from './schedule.component';
import { ScheduleService } from './schedule.service';

@NgModule({
  imports: [
    CommonModule,
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
