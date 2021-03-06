import 'rxjs/add/observable/throw';

import { Injectable } from '@angular/core';
import {
  Http, ConnectionBackend, RequestOptions, Request, Response, RequestOptionsArgs, RequestMethod, ResponseOptions, Headers
} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Subscriber } from 'rxjs/Subscriber';
import { extend } from 'lodash';

import { environment } from '../../../environments/environment';
import { Logger } from '../logger.service';
import { HttpCacheService } from './http-cache.service';
import { HttpCachePolicy } from './request-options-args';
import { AuthenticationService } from '../authentication/authentication.service';

const log = new Logger('HttpService');

export interface Credentials {
  // Customize received credentials here
  username: string;
  token: string;
}
const credentialsKey = 'credentials';

/**
 * Provides a base framework for http service extension.
 * The default extension adds support for API prefixing, request caching and default error handler.
 */
@Injectable()
export class HttpService extends Http {

  private _credentials: Credentials;

  constructor(backend: ConnectionBackend,
              private defaultOptions: RequestOptions,
              private httpCacheService: HttpCacheService,
              private authService: AuthenticationService) {
    // Customize default options here if needed
    super(backend, defaultOptions);
  }

  // Create basic auth headers
  createAuthorizationHeader(headers: Headers) {
    this._credentials = JSON.parse(sessionStorage.getItem(credentialsKey) || localStorage.getItem(credentialsKey));
    if(this._credentials) {
      headers.append('Authorization', 'Basic ' +
        btoa(this._credentials.username + ':' + this._credentials.token));
    }
  }

  /**
   * Performs any type of http request.
   * You can customize this method with your own extended behavior.
   */
  request(request: string|Request, options?: RequestOptionsArgs): Observable<Response> {
    options = options || {};
    let url: string;

    // Set auth headers
    if(!options.headers) {
      options.headers = new Headers();
    }
    this.createAuthorizationHeader(options.headers);

    if (typeof request === 'string') {
      url = request;
      request = environment.serverUrl + url;
    } else {
      url = request.url;
      request.url = environment.serverUrl + url;
    }

    if (!options.cache) {
      // Do not use cache
      return this.httpRequest(request, options);
    } else {
      return new Observable((subscriber: Subscriber<Response>) => {
        const cachedData = options.cache === HttpCachePolicy.Update ? null : this.httpCacheService.getCacheData(url);
        if (cachedData !== null) {
          // Create new response to avoid side-effects
          subscriber.next(new Response(cachedData));
          subscriber.complete();
        } else {
          this.httpRequest(request, options).subscribe(
            (response: Response) => {
              // Store the serializable version of the response
              this.httpCacheService.setCacheData(url, null, new ResponseOptions({
                body: response.text(),
                status: response.status,
                headers: response.headers,
                statusText: response.statusText,
                type: response.type,
                url: response.url
              }));
              subscriber.next(response);
            },
            (error) => subscriber.error(error),
            () => subscriber.complete()
          );
        }
      });
    }
  }

  get(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Get }));
  }

  post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Post
    }));
  }

  put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Put
    }));
  }

  delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Delete }));
  }

  patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Patch
    }));
  }

  head(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Head }));
  }

  options(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Options }));
  }

  // Customize the default behavior for all http requests here if needed
  private httpRequest(request: string|Request, options: RequestOptionsArgs): Observable<Response> {
    let req = super.request(request, options);
    if (!options.skipErrorHandler) {
      req = req.catch(error => this.errorHandler(error));
    }
    return req;
  }

  // Customize the default error handler here if needed
  private errorHandler(response: Response): Observable<Response> {
    if (environment.production) {
      // Avoid unchaught exceptions on production
      log.error('Request error', response);
      return Observable.throw(response);
    }
    throw response;
  }

}
