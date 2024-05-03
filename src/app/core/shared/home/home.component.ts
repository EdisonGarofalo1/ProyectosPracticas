import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/modules/auth/service/auth.service';

import Swal from 'sweetalert2';
import { Send } from '../../model/Send';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  logueado:boolean=false;
  
  constructor(private _router:Router, private _AuthService:AuthService){

  

  }
  ngOnInit(): void {

    if (localStorage.getItem('token')) {
      this.logueado = true;
      
    }


    
  }
  
  Salir(){

  

    const username1= localStorage.getItem('username');
    console.log("sss:",username1);
  const Usuario: Send={
    username:username1
  }

console.log("user:",Usuario)
  this._AuthService.logout(Usuario).subscribe(resp =>{

    if(resp.code != null){
      Swal.fire("Exito",resp.message)
     
      localStorage.removeItem('token');
      localStorage.removeItem('username')
      this._router.navigate(['/login']);
    }else{

      Swal.fire("Error",'error')
          
      console.log("Hubo un error!",resp.message)
    
    }


  })

  }
}
