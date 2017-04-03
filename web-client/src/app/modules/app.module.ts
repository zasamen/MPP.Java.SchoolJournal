import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import  {AppRoutingModule } from './app-routing.module';

import { AppComponent }  from '../components/app.component';
import { RolesComponent } from "../components/roles.component";
import { RolesService } from "../services/roles.service";
import {APP_CONFIG, AppConfig} from "../configs/app.config";
import {HttpModule} from "@angular/http";
import {MenuComponent} from "../components/menu.component";
import {Ng2BootstrapModule, CollapseModule} from "ng2-bootstrap";
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

@NgModule({
  imports: [
    Ng2BootstrapModule,
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    CollapseModule.forRoot(),
    FormsModule
  ],
  declarations: [
    AppComponent,
    RolesComponent,
    MenuComponent,
    ProfileComponent,
    LoginComponent,
    ScheduleComponent,
    MarksComponent
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
    { provide: APP_CONFIG, useValue: AppConfig },
  ],
  bootstrap:    [
    AppComponent
  ]
})
export class AppModule { }
