import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import Swal from 'sweetalert2';
import { AuthService } from '../../service/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  constructor(private _router:Router, private _AuthService:AuthService,private FB: FormBuilder){ 
  this.loginForm= this.FB.group({
    username:['Edison',[Validators.required]],
    password:['123456',[Validators.required]],
  })
  }  
  login(){
    if (this.loginForm.valid) {
      console.log("losmss:",this.loginForm.value)
      localStorage.setItem('username', this.loginForm.value.userName );
     this._AuthService.Login(this.loginForm.value).subscribe(res =>{
      if(res.code !==null){
        localStorage.setItem('token', res.code! );
        localStorage.setItem('Data', JSON.stringify(res.data) );
       
        const userDataString = localStorage.getItem('Data');
    if (userDataString) {
      const userData = JSON.parse(userDataString);
      const username = userData.user.username;
      const email = userData.user.email;
      
      Swal.fire({
        icon: 'success',
        title: 'Bienvenido Usuario',
        html: `Bienvenido, <strong>${username}</strong><br>Email: ${email}`
      });
    } else {
      Swal.fire('Error', 'No se encontraron datos de usuario en el almacenamiento.', 'error');
    }
        this._router.navigateByUrl('/home');
        console.log("si  igreos")
        } else {
          localStorage.removeItem('username')
          Swal.fire('Error', res.message, 'error');
        }
     } )
    } else { 
      localStorage.removeItem('username')
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Por favor, completa todos los campos.'
      });
    } 
  }
  recuperar(){
     this._router.navigateByUrl('/auth/password');
  }

}
