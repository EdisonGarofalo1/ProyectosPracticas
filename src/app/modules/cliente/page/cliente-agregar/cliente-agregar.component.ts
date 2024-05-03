import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs';
import Swal from 'sweetalert2';
import { ClienteService } from '../../service/cliente.service';

@Component({
  selector: 'app-cliente-agregar',
  templateUrl: './cliente-agregar.component.html'
})
export class ClienteAgregarComponent {
  clientForm: FormGroup;

  

  constructor( private fb:FormBuilder, private _ActivatedRoute:ActivatedRoute, private _ClienteService:ClienteService, private _Router:Router){  
  
    this.clientForm = this.fb.group({
      clientid: [''],
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      identification: [''],
      email: ['', [Validators.required, Validators.email]],
      phonenumber: ['', Validators.required],
      address: ['', Validators.required],
      referencceaddress: ['', Validators.required]
    });

  }

 

  ngOnInit(): void {

    if(!this._Router.url.includes('edit')){
  
      return;
  
    }

    this._ActivatedRoute.params.pipe(
      switchMap(({id})=> this._ClienteService.getClientid(id))).subscribe( { next:resp=> {
      
      console.log("seee",resp)
  
    
      this.clientForm.patchValue(resp)

    
   
    },error:error=>{
      Swal.fire("Error",error,'error')
            
            console.log("Hubo un error!",error)
          }


    
         } )

  }
  
  Guardar(){


 
      console.log("estoy editado",this.clientForm.value);

      this._ClienteService.updateClient(this.clientForm.value.clientid,this.clientForm.value).subscribe({
        next:resp=>{ console.log(resp)
          if(resp.code ==='UPDATED'){

            console.log("respuesta del servidor",resp)
            Swal.fire("Exito",resp.message,'success')
            this._Router.navigate(['/home/cliente/list']);
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
  this._Router.navigate(['/home/cliente/list'])
 
    }
 
  }