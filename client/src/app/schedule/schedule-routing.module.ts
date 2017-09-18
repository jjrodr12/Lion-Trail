import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Route } from '../core/route.service';
import { extract } from '../core/i18n.service';
import { ScheduleComponent } from './schedule.component';

const routes: Routes = Route.withShell([
  { path: 'schedule', component: ScheduleComponent, data: { title: extract('Schedule') } }
]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class ScheduleRoutingModule { }
