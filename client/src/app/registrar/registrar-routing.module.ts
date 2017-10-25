import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Route } from '../core/route.service';
import { extract } from '../core/i18n.service';
import { RegistrarComponent } from './registrar.component';

const routes: Routes = Route.withShell([
  { path: 'registrar', component: RegistrarComponent, data: { title: extract('Registrar') } }
]);

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class RegistrarRoutingModule { }
