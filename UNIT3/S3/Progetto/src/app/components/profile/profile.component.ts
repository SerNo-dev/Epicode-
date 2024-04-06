import { Component } from '@angular/core';
import { ProfiloService } from 'src/app/service/profilo.service';
import { Movies } from 'src/app/models/movies.interface';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent {
  showFavorites: boolean = false;
  favorites: Movies[] = [];

  constructor(private profileService: ProfiloService) {}

  ngOnInit(): void {
    this.profileService.favorites$.subscribe((favorites) => {
      this.favorites = favorites;
      console.log(favorites)
        });
  }

  toggleFavorites(): void {
    this.showFavorites = !this.showFavorites;
  }
}
