import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import  {AppRoutingModule } from './app-routing.module';

import { AppComponent }  from '../components/app.component';
import { RolesComponent } from "../components/roles.component";
import { RolesService } from "../services/roles.service";
import {APP_CONFIG, AppConfig} from "../configs/app.config";
import {HttpModule} from "@angular/http";
import {MenuComponent} from "../components/menu.component";
import {Ng2BootstrapModule, CollapseModule, ModalModule} from "ng2-bootstrap";
import {ProfileComponent} from "../components/profile.component";
import {TeachersService} from "../services/teachers.service";
import {LoginComponent} from "../components/login.component";
import {FormsModule} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {UsersService} from "../services/users.service";
import {PupilsService} from "../services/pupils.service";
import {HttpUtil} from "../services/http.util";
import {ScheduleComponent} from "../components/schedule.component";
import {MarksComponent} from "../components/marks.component";
import {ScheduleService} from "../services/schedule.service";
import {MarksService} from "../services/marks.service";
import {FullScheduleComponent} from "../components/full-schedule.component";
import {SchoolInfoService} from "../services/school-info.service";
import {KeysPipe} from "../pipes/keys.pipe";
import {DayTimePipe} from "../pipes/day-time.pipe";
import {GetPipe} from "../pipes/get.pipe";
import {ContextMenuModule} from "angular2-contextmenu";

@NgModule({
  imports: [
    Ng2BootstrapModule,
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    CollapseModule.forRoot(),
    ContextMenuModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    RolesComponent,
    MenuComponent,
    ProfileComponent,
    LoginComponent,
    ScheduleComponent,
    MarksComponent,
    FullScheduleComponent,
    KeysPipe,
    DayTimePipe,
    GetPipe,
  ],
  providers: [
    RolesService,
    TeachersService,
    AuthService,
    UsersService,
    PupilsService,
    HttpUtil,
    ScheduleService,
    MarksService,
    SchoolInfoService,
    { provide: APP_CONFIG, useValue: AppConfig },

  ],
  bootstrap:    [
    AppComponent
  ],
})
export class AppModule { }
