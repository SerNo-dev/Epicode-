import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FavoritesComponent } from './components/favorites/favorites.component';
import { HttpClientModule } from '@angular/common/http';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'favorites',
    component: FavoritesComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FavoritesComponent,
    HomeComponent,
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes),HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
