import { Injectable } from '@angular/core';
import { Users } from '../models/users.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
   apiUrl:string = 'http://localhost:3000/users';

  constructor(private http:HttpClient ) { }

  getUsers(){
    return this.http.get<Users[]>(this.apiUrl);
  }
}
