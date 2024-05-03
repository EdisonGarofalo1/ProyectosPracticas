import { Component } from '@angular/core';
import { Cliente } from 'src/app/core/model/Cliente';
import { ClienteService } from '../../service/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',

})
export class ClienteListComponent {


  lista: Cliente [] =[];
  logueado: boolean = false;

   constructor( private _ClienteService: ClienteService){
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

    this._ClienteService.getClient().subscribe( resp=> {this.lista=resp;
      
      console.log("listaxxxx:",this.lista);})

   }



}
