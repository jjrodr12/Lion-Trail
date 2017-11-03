import { Input, Component, OnInit } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  FormArray,
  NgForm,
  Validators
} from '@angular/forms';
import { RegistrarService } from '../registrar.service';

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

  @Input()
  public alerts: Array<IAlert> = [];

  private backup: Array<IAlert>;

  constructor(
    private registrarService: RegistrarService,
    private fb: FormBuilder
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
  }

  addClassSubmit(form: any) {
    console.log(form);
    this.registrarService.addStudentToClass('sad1', Number(form.addClassId))
    .subscribe((response: any) => {
      console.log(response);
    });
  }

  dropClassSubmit(form: any) {
    console.log(form);
    this.registrarService.dropStudentFromClass('sad1', Number(form.addClassId));
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