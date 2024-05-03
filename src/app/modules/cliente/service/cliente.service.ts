import { Injectable } from '@angular/core';
import { of, Observable, throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http'
import { catchError, map, tap } from 'rxjs/operators';

import { ResponseData } from 'src/app/core/model/Response';
import { environment } from 'src/environments/environments';
import { Cliente } from 'src/app/core/model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private baseUrl: string = environment.baseUrl;
 

  constructor(private http:HttpClient ) { }

  
  private handleError(error:HttpErrorResponse){

    if(error.error instanceof ErrorEvent){
      console.error('Ocurrió un error:',error.error.message)


    }else {

      console.error(`El backend devolvió el código ${error.status}` +
      
      ` body era: ${error.error}`);

          }
          return throwError ('Algo malo sucedio; Por favor, inténtelo de nuevo más tarde.'

          );
    
  }



  getClientid(id:number):Observable<Cliente>{
    const requestData = { id: id }; // Objeto con la estructura esperada por el backend
  
  
    return this.http.post<ResponseData>(this.baseUrl+'client/ver',requestData).pipe(
      map((response) => response.data['client'] as Cliente)
    ).pipe(
      catchError(this.handleError)
  );
    }



    getClient():Observable<Cliente[]>{

  
      return this.http.get<ResponseData>(`${this.baseUrl}client/listar`).pipe(
        map((response) => response.data['listclientes'] as Cliente[])
      ).pipe(
        catchError(this.handleError)
    );
      }
    


      updateClient(id:number,data:Cliente):Observable<ResponseData>{

        return  this.http.put<ResponseData>(this.baseUrl + 'client/editar/'+ id, data).pipe(
          catchError(this.handleError)
          );
      }




    
    }



