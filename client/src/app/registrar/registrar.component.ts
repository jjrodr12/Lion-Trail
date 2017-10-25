import { Component, OnInit } from '@angular/core';

import { RegistrarService } from '../registrar.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.scss']
})
export class RegistrarComponent implements OnInit {

  constructor(
    private registrarService: RegistrarService
  ) { }

  ngOnInit() {

    this.registrarService.getCourses()
    .subscribe((response: any) => {
      console.log(response);
    });
  }

}
