import {Injectable } from '@angular/core';
import { Movies } from '../models/movies.interface';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
@Injectable({
  providedIn: 'root'
})
export class MoviesService {
    apiUrl = environment.apiUrl

  constructor(private http:HttpClient) { }

  getTopMovies(){
    return this.http.get<Movies[]>(`${this.apiUrl}movies-toprated`);
  }
  getPopularMovies(){
    return this.http.get<Movies[]>(`${this.apiUrl}movies-popular`);
  }
}