import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from '../models/products.interface';
import { Subject, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  apiURL = 'https://dummyjson.com/products';
  favoriteSub = new Subject<Products[]>();

  favoritesCounter = 0;
  favoriteProducts: Products[] = [];

  constructor(private http: HttpClient) {}

  getProducts() {
    return this.http.get<{ products: Products[] }>(this.apiURL).pipe(
      map((response) => response.products),
      catchError((err) => {
        return throwError(this.getErrorMessage(err.status));
      })
    );
  }

  addFavorites(product: Products) {
    this.favoritesCounter++;
    this.favoriteProducts.push(product);
    this.favoriteSub.next(this.favoriteProducts); 
  }

  private getErrorMessage(status: number): string {
    let message = '';
    switch (status) {
      case 404:
        message = 'Elementi non trovati';
        break;
      default:
        message = 'Qualcosa non funziona';
        break;
    }
    return message;
  }
}
