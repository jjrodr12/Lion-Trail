import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Route } from '../core/route.service';
import { extract } from '../core/i18n.service';
import { GradesComponent } from './grades.component';

const routes: Routes = Route.withShell([
  { path: 'grades', component: GradesComponent, data: { title: extract('Grades') } }
]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class GradesRoutingModule { }
