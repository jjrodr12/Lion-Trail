import { Input, Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { FormBuilder,
  FormGroup,
  FormControl,
  FormArray,
  NgForm,
  Validators
} from '@angular/forms';
import { RegistrarService } from '../registrar.service';
import { AuthenticationService } from '../core/authentication/authentication.service';

function isInteger(input: FormControl) {
  return Number.isInteger(Number(input.value)) ? null : {validInteger: true};
}

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.scss']
})
export class RegistrarComponent implements OnInit {

  courses: Course[];
  majors: Major[];
  searchResults: any = [];
  private addForm: FormGroup;
  private dropForm: FormGroup;
  closeResult: string;
  modalCourse: Course;
  semesters: any;
  courseClassResults: any = [];
  private userId: number;

  @Input()
  public alerts: Array<IAlert> = [];
  private backup: Array<IAlert>;

  @Input()
  public addDropAlerts: Array<IAlert> = [];

  @Input()
  public classSearchAlerts: Array<IAlert> = [];

  constructor(
    private registrarService: RegistrarService,
    private fb: FormBuilder,
    private modalService: NgbModal,
    private authenticationService: AuthenticationService
  ) {
    this.addForm = fb.group({
      'addClassId': [null, [Validators.required, isInteger]]
    });
    this.dropForm = fb.group({
      'dropClassId': [null, [Validators.required, isInteger]]
    });
  }

  ngOnInit() {
    this.registrarService.getAllCourses()
    .subscribe((response: any) => {
      this.courses = response;
    });

    this.registrarService.getAllMajors()
    .subscribe((response: any) => {
      this.majors = response;
    });

    this.registrarService.getSemesters()
    .subscribe((response: any) => {
      this.semesters = response;
    });

    this.userId = this.authenticationService.userInfo.id;
  }

  clickCourse(content: any, course: Course) {
    this.modalCourse = course;
    this.modalService.open(content, {size: 'lg'}).result.then((result) => {
      this.courseClassResults = [];
    }, (reason) => {
      this.courseClassResults = [];
    });
  }

  getCourseClasses(semester: any, course: Course) {
    this.registrarService.getCourseClasses(semester.id, course.id)
    .subscribe((response: any) => {
      if(response.errorMessage) {
        this.classSearchAlerts.push({
          id: 1,
          type: 'danger',
          message: `No classes found for ${course.majorAbr}${course.number} in ${semester.season} ${semester.year}`,
          exp: this.getAlertTimeout()
        });
      }
      else {
        this.courseClassResults = response;
      }
    });
  }

  private getAlertTimeout() {
    let t = new Date();
    t.setSeconds(t.getSeconds() + 5);
    return t;
  }

  addClassSubmit(addClassId: any) {
    this.registrarService.addStudentToClass(this.userId, Number(addClassId))
    .subscribe((response: any) => {
      this.addDropAlerts.push({
        id: this.addDropAlerts.length + 1,
        type: 'success',
        message: 'Successfully added class with ID ' + addClassId + ' to schedule.',
        exp: this.getAlertTimeout()
      });
    }, e => {
      let t = new Date();
      t.setSeconds(t.getSeconds() + 5);
      this.addDropAlerts.push({
        id: this.addDropAlerts.length + 1,
        type: 'danger',
        message: e,
        exp: this.getAlertTimeout()
      });
    });
  }

  dropClassSubmit(dropClassId: any) {
    this.registrarService.dropStudentFromClass(this.userId, Number(dropClassId))
    .subscribe((response: any) => {
      this.addDropAlerts.push({
        id: this.addDropAlerts.length + 1,
        type: 'success',
        message: 'Successfully dropped class with ID ' + dropClassId + ' from schedule.',
        exp: this.getAlertTimeout()
      });
    }, e => {
      this.addDropAlerts.push({
        id: this.addDropAlerts.length + 1,
        type: 'danger',
        message: e,
        exp: this.getAlertTimeout()
      });
    });
  }

  closeAddDropAlert(alert: IAlert) {
    const index: number = this.addDropAlerts.indexOf(alert);
    this.addDropAlerts.splice(index, 1);
  }

  alertTimedOut(alert: IAlert) {
    if(alert.exp) {
      return alert.exp.getTime() - new Date().getTime() < 0;
    }
    else {
      return false;
    }
  }

  searchByMajor(majorId: number) {
    this.registrarService.getCoursesByMajorId(majorId)
    .subscribe((response: any) => {
      if(response.errorMessage) {
        this.alerts.push({
          id: 1,
          type: 'danger',
          message: response.errorMessage,
          exp: this.getAlertTimeout()
        });
      }
      else {
        this.searchResults = response;
        console.log(this.searchResults);
      }
    });
  }

  public closeAlert(alert: IAlert) {
    const index: number = this.alerts.indexOf(alert);
    this.alerts.splice(index, 1);
  }

  public closeClassSearchModalAlert(alert: IAlert) {
    const index: number = this.classSearchAlerts.indexOf(alert);
    this.classSearchAlerts.splice(index, 1);
  }

  public reset() {
    this.alerts = this.backup.map((alert: IAlert) => Object.assign({}, alert));
  }

}

interface Course {
  credits: number,
  description: string,
  id: number,
  majorAbr: string,
  majorId: number,
  majorLevel: string,
  majorName: string,
  name: string,
  number: number,
  prerequisites?: Course[]
}

interface MajorGroup {
  numberOfClasses: number,
  courses: Course[]
}

interface Major {
  id: number,
  abbreviation: string,
  name: string,
  level: string,
  departmentId: string,
  departmentName: string,
  requirements?: {
    requiredClasses?: Course[],
    groups?: MajorGroup[]
  }
}

export interface IAlert {
  id: number;
  type: string;
  message: string;
  exp?: Date;
}