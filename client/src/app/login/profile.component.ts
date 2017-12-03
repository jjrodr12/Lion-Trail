import { Component, OnInit } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  FormArray,
  NgForm,
  Validators
} from '@angular/forms';

import { Router } from '@angular/router';

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
    private router: Router,
    private fb: FormBuilder
  ) {
     this.passwordForm = fb.group({
      'password': [null, [Validators.required]]
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
    this.authenticationService.changePassword(password)
    .subscribe((response: any) => {
      console.log('Success!');
      this.authenticationService.logout();
      this.router.navigate(['/login'], { replaceUrl: true });
    }, e => alert(e));
  }

}
