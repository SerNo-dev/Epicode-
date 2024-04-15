import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/app/models/movies.interface';
import { MoviesService } from 'src/app/service/movies.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  TopMovies: Movies[] = [];
  loading: boolean = true; 

  constructor(private moviesService: MoviesService) {}

  ngOnInit(): void {
    this.moviesService.getTopMovies().subscribe(
      (data) => {
        this.TopMovies = data;
        this.loading = false;
      },
      (error) => {
        console.error('Errore nel recupero dei dati:', error);
        this.loading = false; 
      }
    );
  }
}
