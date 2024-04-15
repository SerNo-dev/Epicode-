import { Component, Input, OnInit } from '@angular/core';
import { Movies } from 'src/app/models/movies.interface';
import { ProfiloService } from 'src/app/service/profilo.service';

@Component({
  selector: 'app-preferiti',
  templateUrl: './preferiti.component.html',
  styleUrls: ['./preferiti.component.scss'],
})
export class PreferitiComponent implements OnInit {
  @Input() favorites: Movies[] = [];
  urlmg: string = 'https://image.tmdb.org/t/p/w500';

  constructor(private profileService: ProfiloService) {}
  ngOnInit(): void {
    this.profileService.favorites$.subscribe((favorites) => {
      this.favorites = favorites;
    });
  }
}
