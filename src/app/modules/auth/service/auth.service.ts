import { Injectable } from '@angular/core';
import { of, Observable, throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http'
import { catchError, map, tap } from 'rxjs/operators';

import { environment } from 'src/environments/environments';

import { ResponseData } from 'src/app/core/model/Response';
import { Send } from 'src/app/core/model/Send';
import { User } from 'src/app/core/model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

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
  Login(user: Send){
    return this.http.post<ResponseData>(this.baseUrl + 'sesion/login', user).pipe(
      catchError(this.handleError)
          );
  }

  logout(user: Send): Observable<ResponseData> {
   
    return this.http.post<ResponseData>(`${this.baseUrl}sesion/logout`,user).pipe(
      catchError(this.handleError)
      );
  }



  getpassword(username: string): Observable<ResponseData> {
    const requestData = { username: username }; // Objeto con la estructura esperada por el backend
  
    return this.http.post<ResponseData>(this.baseUrl + 'sesion/password', requestData).pipe(
      catchError(this.handleError)
    );
  }
  
  getUserid(id:number):Observable<User>{
    const requestData = { id: id }; // Objeto con la estructura esperada por el backend
  
  
    return this.http.post<ResponseData>(this.baseUrl+'user/ver',requestData).pipe(
      map((response) => response.data['user'] as User)
    ).pipe(
      catchError(this.handleError)
  );
    }




 
  
  validarToken(): Observable<boolean> {

    if ( !localStorage.getItem('token') ) {
      return of(false);
    }else{
      return of(true);

    }
}

getUser():Observable<User[]>{

  
  return this.http.get<ResponseData>(`${this.baseUrl}user/listar`).pipe(
    map((response) => response.data['listuser'] as User[])
  ).pipe(
    catchError(this.handleError)
);
  }


  updateUser(id:number,data:User):Observable<ResponseData>{

    return  this.http.put<ResponseData>(this.baseUrl + 'user/editar/'+ id, data).pipe(
      catchError(this.handleError)
      );
  }
 

  userCargaMaciva(accion: number, json: any): Observable<ResponseData> {
    const url = `${this.baseUrl}client/crearmasiva?accion=${accion}`;
    return this.http.post<ResponseData>(url, json).pipe(
      catchError(this.handleError)
    );
  }
}




