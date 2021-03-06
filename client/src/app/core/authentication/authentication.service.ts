import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';

export interface Credentials {
  // Customize received credentials here
  username: string;
  token: string;
}

export interface UserData {
  id: number,
  name: {
    firstName: string,
    middleName: string,
    lastName: string,
  }
  username: string
}

export interface LoginContext {
  username: string;
  password: string;
  remember?: boolean;
}

const credentialsKey = 'credentials';
const userDataKey = 'userdata';

/**
 * Provides a base for authentication workflow.
 * The Credentials interface as well as login/logout methods should be replaced with proper implementation.
 */
@Injectable()
export class AuthenticationService {

  private _credentials: Credentials;
  private _userData: UserData;

  constructor(private http: Http) {
    this._credentials = JSON.parse(sessionStorage.getItem(credentialsKey) || localStorage.getItem(credentialsKey));
    this._userData = JSON.parse(sessionStorage.getItem(userDataKey) || localStorage.getItem(userDataKey));
  }

  /**
   * Authenticates the user.
   * @param {LoginContext} context The login parameters.
   * @return {Observable<Credentials>} The user credentials.
   */
  login(context: LoginContext): Observable<Credentials> {
    console.log(context);
    const data = {
      username: context.username,
      token: context.password
    };
    this.setCredentials(data, context.remember);
    return this.getUserData(context.username, context.remember);
  }

  /**
   * Logs out the user and clear credentials.
   * @return {Observable<boolean>} True if the user was logged out successfully.
   */
  logout(): Observable<boolean> {
    // Customize credentials invalidation here
    this.setCredentials();
    return Observable.of(true);
  }

  /**
   * Checks is the user is authenticated.
   * @return {boolean} True if the user is authenticated.
   */
  isAuthenticated(): boolean {
    return !!this.credentials;
  }

  /**
   * Gets the user credentials.
   * @return {Credentials} The user credentials or null if the user is not authenticated.
   */
  get credentials(): Credentials {
    return this._credentials;
  }

  get userInfo(): UserData {
    return this._userData;
  }

  /**
   * Sets the user credentials.
   * The credentials may be persisted across sessions by setting the `remember` parameter to true.
   * Otherwise, the credentials are only persisted for the current session.
   * @param {Credentials=} credentials The user credentials.
   * @param {boolean=} remember True to remember credentials across session
   * s.
   */
  private setCredentials(credentials?: Credentials, remember?: boolean) {
    this._credentials = credentials || null;

    if (credentials) {
      const storage = remember ? localStorage : sessionStorage;
      storage.setItem(credentialsKey, JSON.stringify(credentials));
    } else {
      sessionStorage.removeItem(credentialsKey);
      localStorage.removeItem(credentialsKey);
    }
  }

  private getUserData(username: string, remember?: boolean) {
    return this.http.get(`/resources/users?userName=${username}`)
    .map((res: Response) => {
      this.setUserData(res.json(), remember);
      return res.json();
    })
    .catch(e => Observable.throw('Error, could not load user ID'));
  }

  private setUserData(userData?: UserData, remember?: boolean) {
    this._userData = userData || null;

    if(userData) {
      const storage = remember ? localStorage : sessionStorage;
      storage.setItem(userDataKey, JSON.stringify(userData));
      console.log(this._userData);
    } else {
      sessionStorage.removeItem(userDataKey);
      localStorage.removeItem(userDataKey);
    }
  }

  changePassword(password: string) {
    return this.http.put(`/resources/users/id/${this._userData.id}`, password)
    .map((res: Response) => {
      if(res.status !== 202) {
        return Observable.throw('Error: ' + res.json().errorMessage[0]);
      }
      return Observable.of('success');
    })
    .catch(e => {
      return Observable.throw('Error: ' + e.json().errorMessage[0]);
    });
  }

}
