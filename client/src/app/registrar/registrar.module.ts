import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrarRoutingModule } from './registrar-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { RegistrarComponent } from './registrar.component';
import { RegistrarService } from '../registrar.service';

@NgModule({
  imports: [
    CommonModule,
    RegistrarRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    RegistrarComponent
  ],
  providers: [
    RegistrarService
  ]
})
export class RegistrarModule { }
