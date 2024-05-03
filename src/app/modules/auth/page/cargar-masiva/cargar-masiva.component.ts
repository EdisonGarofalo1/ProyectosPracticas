import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import * as XLSX from 'xlsx';
import Swal from 'sweetalert2';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-cargar-masiva',
  templateUrl: './cargar-masiva.component.html'
})
export class CargarMasivaComponent {
  constructor(  private _ActivatedRoute:ActivatedRoute, private _AuthService:AuthService, private _Router:Router){  

  }


  TitleCargaMasiva: string = '';

  file: File | null = null;

  onFileChange(event: any) {
    this.file = event.target.files[0];
  }

  upload() {
    if (!this.file) {
      console.error('No se ha seleccionado ningún archivo.');
      return;
    }



    const reader = new FileReader();
    reader.onload = (e: any) => {
      const data = new Uint8Array(e.target.result);
      const workbook = XLSX.read(data, { type: 'array' });
      const sheetName = workbook.SheetNames[0];
      const sheet = workbook.Sheets[sheetName];
      const jsonData = XLSX.utils.sheet_to_json(sheet);

      // Aquí puedes hacer algo con los datos de clientes, como enviarlos a un servicio
      console.log(jsonData);

      const rol =localStorage.getItem('token');
     
      if(rol === 'Administrador'){
        console.log(jsonData);
        console.log('Bienvenido Adminitrador');

        const accion = 2;
        const transformedData = this.transformData(jsonData);


        console.log("trafonamme,",transformedData);
      this._AuthService.userCargaMaciva(accion,transformedData).subscribe({
        next:resp=>{ console.log(resp)
          if(resp.code ==='CREATED'){
  
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

     

      }else if(rol === 'Cajero'){
  
    
        const accion = 1;
        console.log('Bienvenido Cajero ');

      this._AuthService.userCargaMaciva(accion,jsonData).subscribe({
        next:resp=>{ console.log(resp)
          if(resp.code ==='CREATED'){
  
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


    };
    reader.readAsArrayBuffer(this.file);
  }


  ngOnInit(): void {

    const rol =localStorage.getItem('token')

    if(rol === 'Administrador'){
      this.TitleCargaMasiva='Cargar Usuarios'
      console.log('Bienvenido Adminitrador');
    }else if(rol === 'Cajero'){

      this.TitleCargaMasiva='Cargar Clientes'

    }

  }

  transformData(data: any[]): any[] {
    // Aquí puedes transformar la estructura de los datos según tus necesidades
    return data.map(item => {
      return {
        username: item.username,
        email: item.email,
        password: item.password,
        rol: {
          rolId: item['rol.rolId']
        },
        usercreate: item.usercreate,
        userStatus: {
          statusid: item['userStatus.statusid']
        }
      };
    });
  }
}
