import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';



const routes: Routes = [

  
  //   { path:'carrito',
  //   loadChildren:()=> import("../../modules/carrito/carrito.module").then(m=> m.CarritoModule),
  //   canActivate:[ValidarTokenGuard],
  //   canLoad:[ValidarTokenGuard],
  
  //  },
   {
       path:'cliente',
       loadChildren:()=> import('../../modules/cliente/cliente.module').then(m=>m.ClienteModule)
   }
  //  ,
  //  {
  //   path:'producto',
  //   loadChildren:()=> import('../../modules/producto/producto.module').then(m=>m.ProductoModule)
  // },
   
  
  ];

  



@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class SharedRoutingModule { }
