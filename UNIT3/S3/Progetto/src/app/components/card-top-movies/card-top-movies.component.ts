import { Component,Input } from '@angular/core';
import { Movies } from 'src/app/models/movies.interface';
@Component({
  selector: 'app-card-top-movies',
  templateUrl: './card-top-movies.component.html',
  styleUrls: ['./card-top-movies.component.scss']
})
export class CardTopMoviesComponent {
  @Input() movie!: Movies;


  urlmg: string = 'https://image.tmdb.org/t/p/w500';
}
