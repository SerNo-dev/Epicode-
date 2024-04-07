import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Movies } from '../models/movies.interface';

@Injectable({
  providedIn: 'root',
})
export class ProfiloService {
  private favoritesSubject = new BehaviorSubject<Movies[]>(
    this.getFavoritesFromLocalStorage()
  );
  favorites$ = this.favoritesSubject.asObservable();

  constructor() {}

  addToFavorites(movie: Movies): void {
    const favorites = this.favoritesSubject.getValue();
    const existingIndex = favorites.findIndex((fav) => fav.id === movie.id);
    if (existingIndex !== -1) {
      favorites.splice(existingIndex, 1);
    } else {
      favorites.push(movie);
    }
    this.updateFavorites(favorites);
  }

  private updateFavorites(favorites: Movies[]): void {
    this.favoritesSubject.next(favorites);
    this.saveFavoritesToLocalStorage(favorites);
  }

  private getFavoritesFromLocalStorage(): Movies[] {
    const favoritesJson = localStorage.getItem('favorites');
    return favoritesJson ? JSON.parse(favoritesJson) : [];
  }

  private saveFavoritesToLocalStorage(favorites: Movies[]): void {
    localStorage.setItem('favorites', JSON.stringify(favorites));
  }

  getFavorites(): Movies[] {
    return this.favoritesSubject.getValue();
  }
  isFavorite(movie: Movies): boolean {
    const favorites = this.favoritesSubject.getValue();
    return favorites.some((fav) => fav.id === movie.id);
  }
}
