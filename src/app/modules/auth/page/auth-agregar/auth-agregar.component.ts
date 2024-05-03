import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { switchMap } from 'rxjs';
import Swal from 'sweetalert2';
import { Rol, User, UserStatus } from 'src/app/core/model/User';

@Component({
  selector: 'app-auth-agregar',
  templateUrl: './auth-agregar.component.html'

})
export class AuthAgregarComponent {

  pageTitle: string = 'Actualizar Usuario';
  showUserStatus: boolean = true;
  isEstadoMode: boolean = false; // Variable para verificar si estás en modo "estado"

  constructor(  private _ActivatedRoute:ActivatedRoute, private _AuthService:AuthService, private _Router:Router){  

  }
  roles = [
    { rolId: 1,
    rolName: "Administrador" },
    { rolId: 2,
      rolName: "Gestores" },
      { rolId: 3,
        rolName: "Cajeros" }
  ];


  user: User = {
    userid: 0,
    username: '',
    email: '',
    password: '',
    rol: { rolId: 0, rolName: '' },
    creationdate: new Date(),
    usercreate: 0,
    userapproval: 0,
    dateapproval: new Date(),
    userStatus: { statusid: '', description: '' }
  };

  userStatusList: UserStatus[] = [
    { statusid: 'A', description: 'Active' },
    { statusid: 'I', description: 'Inactive' },
    { statusid: 'B', description: 'Bloqueado' }
  ];

  rolList: Rol[] = [
    { rolId: 1, rolName: 'Administrador' },
    { rolId: 2, rolName: 'Gestores' },
    { rolId: 3, rolName: 'Cajeros' }
  ];
  ngOnInit(): void {

     // Aquí puedes implementar la lógica para enviar los datos al servidor
     console.log(this.user);


     console.log("URL:", this._Router.url);

     // Verificar si la URL incluye 'estado' o 'edit'
     if (this._Router.url.includes('estado')) {
       this.isEstadoMode = true;
       this.showUserStatus = true;
       console.log("Estado Mode activado");
     } else if (this._Router.url.includes('edit')) {
       this.showUserStatus = false;
       console.log("Edit Mode activado");
     } else {
       this.showUserStatus = true;
       console.log("Modo por defecto");
     }
 
     console.log("isEstadoMode:", this.isEstadoMode);
     console.log("showUserStatus:", this.showUserStatus);


 
     this._ActivatedRoute.params.pipe(
       switchMap(({id})=> this._AuthService.getUserid(id))).subscribe( { next:resp=> {
       
       console.log("seee",resp)
 
       this.user=resp;
     
    
     },error:error=>{
       Swal.fire("Error",error,'error')
             
             console.log("Hubo un error!",error)
           }
 
 
     
          } )
 
 
  }
  onSubmit() {

    if (
      !this.user.username ||
      !this.user.email ||
      !this.user.password ||
      !this.user.rol.rolId 
      //!this.user.userStatus.statusid
    ) {
      // Mostrar un mensaje de error o realizar alguna acción
      Swal.fire("Error", "Todos los campos son requeridos", "error");
      return; // Detener el envío del formulario si faltan campos
    }

    
    this._AuthService.updateUser(this.user.userid,this.user).subscribe({
      next:resp=>{ console.log(resp)
        if(resp.code ==='UPDATED'){

          console.log("respuesta del servidor",resp)
          Swal.fire("Exito",resp.message,'success')
          this._Router.navigate(['/auth/auth/list']);
        }else if(resp.code ==='JSONSCHEMA'){

         
            Swal.fire("Error","No cumple com la validacion",'error')
                  
               
        }
      
     },error:error=>{
 Swal.fire("Error",error,'error')
       
       console.log("Hubo un error!",error)
     }
 
})

       

  }
    
salir(){
this._Router.navigate(['/auth/auth/list'])

  }





 

 

}
