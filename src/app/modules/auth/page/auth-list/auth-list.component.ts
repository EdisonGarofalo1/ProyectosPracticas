import { Component } from '@angular/core';
import { User } from 'src/app/core/model/User';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-auth-list',
  templateUrl: './auth-list.component.html'

})
export class AuthListComponent {
  listaUser: User [] =[];
  filteredUsers: User[] = []
  logueado: boolean = false;
  pageTitle: string = '';

   constructor( private _AuthService: AuthService){
   }

   ngOnInit(): void {

    if (localStorage.getItem('token')) {
      this.logueado = true;
      
      
    }else{

      return
    }

      this.cargarUsers()
   }
   cargarUsers(){

    this._AuthService.getUser().subscribe( resp=> {this.listaUser=resp;
      
      const rol =localStorage.getItem('token');
     
      if(rol === 'Administrador'){

        this.pageTitle='User Administrador';
        this.filteredUsers=this.listaUser;

      } else if(rol ==='Gestores'){

        this.pageTitle='User Gestores';
        this.filteredUsers = this.listaUser.filter(user => user.userapproval === 0);
      }


     
      console.log("listaxxxx:",this.listaUser);

      console.log("filteredUsers:",this.filteredUsers);
    
    
    
    })

      

    

   }

   deleteUser(id:number){
    
//     this._AuthService.deleteUser(id).subscribe({next :resp=>{

//       console.log("respuesta del servidor",resp)
//       Swal.fire("Exito",'Se Elimino Existosamente','success')
//       this.cargarUsers();
    

// },
// error:error=>{
// Swal.fire("Error",error,'error')
      
//       console.log("Hubo un error!",error)
//     }
  
  
//   })

   }


}


