import { Component } from '@angular/core';
import { Todo } from 'src/app/models/todo.interface';
import { TodoService } from 'src/app/service/todo.service';

@Component({
  selector: 'app-not-completed',
  templateUrl: './not-completed.component.html',
  styleUrls: ['./not-completed.component.scss']
})
export class NotCompletedComponent {
  notcompleted: Todo[] = [];

  constructor(private todoSrv: TodoService) {
    this.todoSrv.getTodos().subscribe(
      (todos: Todo[]) => {
        console.log('Dati ricevuti:', todos);
        this.notcompleted = todos.filter(todo => !todo.completed);
      },
      (error) => {
        console.log('Errore nel recupero dei dati:', error);
      }
    );
  }

  toggleComplete(id: number) {
    this.todoSrv.toggleComplete(id);
  }
}
