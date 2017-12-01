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
  classResults: any = [];
  private userId: number;

  @Input()
  public alerts: Array<IAlert> = [];
  private backup: Array<IAlert>;

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
      console.log(this.semesters);
    });

    this.userId = this.authenticationService.userInfo.id;
  }

  clickCourse(content: any, course: Course) {
    console.log(course);
    this.modalCourse = course;
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  getClasses(semester: any, course: Course) {
    console.log(semester);
    console.log(course);
    this.registrarService.getClasses(semester.id, course.id)
    .subscribe((response: any) => {
      console.log(JSON.stringify(response));
      if(response.errorMessage) {
        console.log('err');
        this.classSearchAlerts.push({
          id: 1,
          type: 'danger',
          message: `No classes found for ${course.majorAbr}${course.number} in ${semester.season} ${semester.year}`,
        });
      }
      else {
        this.classResults = response;
      }
    });
  }

  addClassSubmit(form: any) {
    console.log(form);
    this.registrarService.addStudentToClass(this.userId, Number(form.addClassId))
    .subscribe((response: any) => {
      console.log(response);
    });
  }

  dropClassSubmit(form: any) {
    console.log(form);
    this.registrarService.dropStudentFromClass(this.userId, Number(form.addClassId));
  }

  searchByMajor(majorId: number) {
    this.registrarService.getCoursesByMajorId(majorId)
    .subscribe((response: any) => {
      if(response.errorMessage) {
        this.alerts.push({
          id: 1,
          type: 'danger',
          message: response.errorMessage,
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
}