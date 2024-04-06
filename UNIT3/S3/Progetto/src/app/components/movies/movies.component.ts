import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/app/models/movies.interface';
import { MoviesService } from 'src/app/service/movies.service';
import { ProfiloService } from 'src/app/service/profilo.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {
  topMovies: Movies[] = [];
  popularMovies: Movies[] = [];
  urlmg: string = 'https://image.tmdb.org/t/p/w500';

  constructor(private moviesService: MoviesService, private profileService: ProfiloService) { }

  ngOnInit(): void {
    this.fetchTopMovies();
    this.fetchPopularMovies();
  }

  fetchTopMovies(): void {
    this.moviesService.getTopMovies().subscribe(
      (data) => {
        this.topMovies = data;
      },
      (error) => {
        console.error('Errore durante il recupero dei film più votati:', error);
      }
    );
  }

  fetchPopularMovies(): void {
    this.moviesService.getPopularMovies().subscribe(
      (data) => {
        this.popularMovies = data;
      },
      (error) => {
        console.error('Errore durante il recupero dei film più popolari:', error);
      }
    );
  }

  addToFavorites(movie: Movies): void {
    this.profileService.addToFavorites(movie);
  }



  isFavorite(movie: Movies): boolean {
    return this.profileService.isFavorite(movie);
  }
}
