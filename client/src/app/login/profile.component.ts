import { Component, OnInit } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  FormArray,
  NgForm,
  Validators
} from '@angular/forms';

import { AuthenticationService } from '../core/authentication/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  passwordForm: FormGroup;

  constructor(
    private authenticationService: AuthenticationService,
    private fb: FormBuilder
  ) {
     this.passwordForm = fb.group({
      'addClassId': [null, [Validators.required]]
    });
  }

  ngOnInit() {
  }

  get username(): string {
    const credentials = this.authenticationService.credentials;
    return credentials ? credentials.username : null;
  }

  get userFirstLastName(): string {
    const userInfo = this.authenticationService.userInfo;
    return userInfo ? userInfo.name.firstName + ' ' + userInfo.name.lastName : this.username;
  }

  changePassword(password: string) {
    this.authenticationService.changePassword(this.username, password)
    .subscribe((response: any) => {
      console.log(response);
    });
  }

}
