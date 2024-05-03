import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthAgregarComponent } from './page/auth-agregar/auth-agregar.component';
import { AuthListComponent } from './page/auth-list/auth-list.component';
import { LoginComponent } from './page/login/login.component';
import { PasswordComponent } from './page/password/password.component';
import { AuthRoutingModule } from './auth-routing.module';


import { CargarMasivaComponent } from './page/cargar-masiva/cargar-masiva.component';
import { TurnAsignacionComponent } from './page/turn-asignacion/turn-asignacion.component';



@NgModule({
  declarations: [
    AuthAgregarComponent,
    AuthListComponent,
    LoginComponent,
    PasswordComponent,
 
    CargarMasivaComponent,
    TurnAsignacionComponent
  ],
  imports: [
    CommonModule,

    FormsModule,
    ReactiveFormsModule,
    AuthRoutingModule
  ]
})
export class AuthModule { }
