import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route,RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { FiatComponent } from './components/fiat/fiat.component';
import { FordComponent } from './components/ford/ford.component';
import { AudiComponent } from './components/audi/audi.component';
import { JumbotronComponent } from './components/jumbotron/jumbotron.component';
import { MainarticleComponent } from './components/mainarticle/mainarticle.component';
import { MarchiComponent } from './components/marchi/marchi.component';
import { FeaturedcarsComponent } from './components/featuredcars/featuredcars.component';
import { ListcarsComponent } from './components/listcars/listcars.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  },{
    path: 'fiat',
    component: FiatComponent
  },
  {
    path: 'ford',
    component : FordComponent
  },{
    path : 'audi',
    component: AudiComponent
  },{
    path :'**',
    redirectTo: ''
  }
]
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    FiatComponent,
    FordComponent,
    AudiComponent,
    JumbotronComponent,
    MainarticleComponent,
    MarchiComponent,
    FeaturedcarsComponent,
    ListcarsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
