import {Injectable, Inject} from "@angular/core";
import {ReplaySubject} from "rxjs";
import {Subject, Observable} from 'rxjs';
import {Http, URLSearchParams} from "@angular/http";
import {APP_CONFIG} from "../configs/app.config";
import {AuthService} from "./auth.service";
import {HttpUtil} from "./http.util";


@Injectable()
export class MarksService {

  constructor(@Inject(APP_CONFIG) private config: any,
              private http: Http,
              private authService: AuthService){
  }

  fetchMarksForSubjectInClass(subjectId, classId) {
    return new Promise((resolve, reject) => {
      let params = new URLSearchParams();
      params.append('token', this.authService.token);
      params.append('subjectId', subjectId);
      params.append('classId', classId);
      this.http.get(`${this.config.apiEndpoint}/marks`, {search: params})
        .map(res => res.json())
        .subscribe((marks) => {
          resolve(marks);
        });
    });
  }

}
