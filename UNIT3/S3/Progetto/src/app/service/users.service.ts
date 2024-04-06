import { Injectable } from '@angular/core';
import { Register } from '../models/register.interface';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  apiUrl = environment.apiUrl;
  utenti!: Register[];
  constructor(private http: HttpClient) {}

  getUsers() {
    return this.http.get<Register[]>(`${this.apiUrl}users`);
  }
}
