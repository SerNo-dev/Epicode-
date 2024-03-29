import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Todo } from '../models/todo.interface';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  apiUrl: string = 'http://localhost:3000/todo';
  private todos: Todo[] = [];
  private todosSubject = new BehaviorSubject<Todo[]>(this.todos);

  constructor(private http: HttpClient) {
    this.getTodosFromApi().subscribe(
      (todos: Todo[]) => {
        this.todos = todos;
        this.todosSubject.next(this.todos);
      },
      (error) => {
        console.log('Errore nel recupero dei dati:', error);
      }
    );
  }

  getTodos(): Observable<Todo[]> {
    return this.todosSubject.asObservable();
  }

  toggleComplete(id: number) {
    const todoIndex = this.todos.findIndex(todo => todo.id === id);
    if (todoIndex !== -1) {
      this.todos[todoIndex].completed = true;
      this.todosSubject.next(this.todos); 
    }
  }

  toggleIncomplete(id: number) {
    const todoIndex = this.todos.findIndex(todo => todo.id === id);
    if (todoIndex !== -1) {
      this.todos[todoIndex].completed = false; 
      this.todosSubject.next(this.todos); 
    }
  }

  

  private getTodosFromApi(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.apiUrl);
  }
}
