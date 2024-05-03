import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './page/login/login.component';
import { HomeComponent } from 'src/app/core/shared/home/home.component';
import { ValidarTokenGuard } from 'src/app/core/guards/auth.guard';
import { AuthListComponent } from './page/auth-list/auth-list.component';
import { AuthAgregarComponent } from './page/auth-agregar/auth-agregar.component';
import { PasswordComponent } from './page/password/password.component';
import { CargarMasivaComponent } from './page/cargar-masiva/cargar-masiva.component';



export const routes: Routes = [
  

  {
 path:'login',
 component: LoginComponent ,
  },

  {
    path:'password',
    component: PasswordComponent ,
     }
  ,{
  path:'auth',
  component: HomeComponent ,
  canActivate:[ValidarTokenGuard],
  canLoad:[ValidarTokenGuard],
  children: [
   { path: 'list', component: AuthListComponent },
   { path: 'create', component: AuthAgregarComponent },
   { path: 'edit/:id', component: AuthAgregarComponent },
   { path: 'estado/:id', component: AuthAgregarComponent },
   { path: 'carga-masiva', component: CargarMasivaComponent },

   
   
 ]
 },
 
 { path: '**', redirectTo: 'login' }
 
 
 
       
 ]
 


 @NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
