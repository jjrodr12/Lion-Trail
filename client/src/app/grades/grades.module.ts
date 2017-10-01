import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { GradesRoutingModule } from './grades-routing.module';
import { GradesComponent } from './grades.component';
import { GradesService } from '../grades.service';
import { ScheduleService } from '../schedule.service';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
    GradesRoutingModule
  ],
  declarations: [
    GradesComponent
  ],
  providers: [
    GradesService,
    ScheduleService
  ]
})
export class GradesModule { }
