import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClienteAgregarComponent } from './page/cliente-agregar/cliente-agregar.component';
import { ClienteListComponent } from './page/cliente-list/cliente-list.component';
import { ClienteRoutingModule } from './cliente-routing.module';




@NgModule({
  declarations: [
    ClienteAgregarComponent,
    ClienteListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
ClienteRoutingModule

  ]
})
export class ClienteModule { }
