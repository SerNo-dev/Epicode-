import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { JumbotronComponent } from './components/jumbotron/jumbotron.component';
import { MainarticleComponent } from './components/mainarticle/mainarticle.component';
import { PlusarticleComponent } from './components/plusarticle/plusarticle.component';
import { PostattiviComponent } from './components/postattivi/postattivi.component';
import { PostinattiviComponent } from './components/postinattivi/postinattivi.component';
import { PostdetailComponent } from './components/postdetail/postdetail.component';
import { SinglePostComponent } from './components/single-post/single-post.component';
import { FormsModule } from '@angular/forms';
import { BgrandomColorDirective } from './directives/bgrandom-color.directive';




const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'postattivi',
    component: PostattiviComponent,
  },
  {
    path: 'postinattivi',
    component: PostinattiviComponent,
  },
  {
    path: 'post/:id',
    component: PostdetailComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    JumbotronComponent,
    MainarticleComponent,
    PlusarticleComponent,
    PostattiviComponent,
    PostinattiviComponent,
    PostdetailComponent,
    SinglePostComponent,
    BgrandomColorDirective,
  
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes),FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
