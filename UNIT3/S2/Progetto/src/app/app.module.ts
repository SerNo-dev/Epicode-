import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SingleTodoComponent } from './components/single-todo/single-todo.component';
import { Route,RouterModule } from '@angular/router';
import { CompletedComponent } from './components/completed/completed.component';
import { NotCompletedComponent } from './components/not-completed/not-completed.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ByUserComponent } from './components/by-user/by-user.component';


const routes: Route[]=[
  {
    path:'',
    component:HomeComponent
  },
  {
    path: 'completed',
    component: CompletedComponent
  },
  {
    path: 'notCompleted',
    component: NotCompletedComponent
  },
  {
    path: 'byUser',
    component: ByUserComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SingleTodoComponent,
    CompletedComponent,
    NotCompletedComponent,
    NavbarComponent,
    ByUserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
