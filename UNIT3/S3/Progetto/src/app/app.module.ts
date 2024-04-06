import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CardTopMoviesComponent } from './components/card-top-movies/card-top-movies.component';
import { MoviesComponent } from './components/movies/movies.component';
import { UtentiComponent } from './components/utenti/utenti.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AuthGuard } from './auth/auth.guard';
import { PreferitiComponent } from './components/preferiti/preferiti.component';
import { DetailsComponent } from './components/details/details.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'movies',
    component: MoviesComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'utenti',
    component: UtentiComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'details',
        component: DetailsComponent,
      },
      {
        path: 'favorites',
        component: PreferitiComponent,
      },
    ],
  },
  {
    path: '**',
    redirectTo: '',
  },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavbarComponent,
    CardTopMoviesComponent,
    MoviesComponent,
    UtentiComponent,
    ProfileComponent,
    PreferitiComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
