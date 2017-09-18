import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreModule } from '../core/core.module';
import { SharedModule } from '../shared/shared.module';
import { ScheduleRoutingModule } from './schedule-routing.module';
import { ScheduleComponent } from './schedule.component';
import { ScheduleService } from './schedule.service';

@NgModule({
  imports: [
    CommonModule,
    CoreModule,
    SharedModule,
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
