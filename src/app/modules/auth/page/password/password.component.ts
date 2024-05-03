import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { Send } from 'src/app/core/model/Send';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent {
  constructor(private _router:Router, private _AuthService:AuthService){}
  usuario:Send={
    username: 'Edison',
    password: ''
  }
  recuperar(){

console.log(this.usuario.username,this.usuario.password);
     this._AuthService.getpassword(this.usuario.username!).subscribe(res => {
      console.log("resp", res);
      if (res.data && res.data['user']) { // Acceder a 'user' con corchetes
        const password = res.data['user'].password; // Acceder a 'password' con corchetes
        
        Swal.fire({
          icon: 'success',
          title: 'Recuperación Exitosa',
          html: `Contraseña recuperada: <strong>${password}</strong>`
        });
      } else {
        Swal.fire('Error', 'No se encontró la contraseña.', 'error');
      }
    }, error => {
      console.error('Error al recuperar la contraseña:', error);
      Swal.fire('Error', 'Ocurrió un error al recuperar la contraseña.', 'error');
    });
  }

  Longi(){

  this._router.navigateByUrl('/auth/login');

}
}
