import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ClienteListComponent } from './page/cliente-list/cliente-list.component';
import { ClienteAgregarComponent } from './page/cliente-agregar/cliente-agregar.component';




const rutas: Routes = [
  {
    path: '',
  
    children: [
  
      { path: 'list', component: ClienteListComponent },
      { path: 'create', component: ClienteAgregarComponent },
      { path: 'edit/:id', component: ClienteAgregarComponent },
      { path: '**', redirectTo: 'list' }
  
  
    ]
  } 
  
  ];

  @NgModule({
    declarations: [],
    imports: [
      RouterModule.forChild(rutas)
    ],
    exports: [
      RouterModule
    ]
  })
export class ClienteRoutingModule { }
