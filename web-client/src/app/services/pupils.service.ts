import {Injectable, Inject} from "@angular/core";
import {ReplaySubject} from "rxjs";
import {Subject, Observable} from 'rxjs';
import {Http, URLSearchParams} from "@angular/http";
import {APP_CONFIG} from "../configs/app.config";
import {AuthService} from "./auth.service";
import {HttpUtil} from "./http.util";


@Injectable()
export class PupilsService {

  constructor(@Inject(APP_CONFIG) private config: any,
              private http: Http,
              private authService: AuthService){
  }

  fetchPupil(pupilId) {
    return new Promise((resolve, reject) => {
      let params = new URLSearchParams();
      params.append('token', this.authService.token);
      this.http.get(`${this.config.apiEndpoint}/pupils/${pupilId}`, {search: params})
        .map(res => {
          return res.json();
        })
        .subscribe((pupil) => {
          resolve(pupil);
        });
    });
  }

}
