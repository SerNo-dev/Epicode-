import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo.interface';
import { TodoService } from 'src/app/service/todo.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss']
})
export class CompletedComponent  {

  completed: Todo[] = [];

  constructor(private todoSrv: TodoService) {
    this.todoSrv.getTodos().subscribe(
      (todos: Todo[]) => {
        console.log('Dati ricevuti:', todos);
        this.completed = todos.filter(todo => todo.completed);
      },
      (error) => {
        console.log('Errore nel recupero dei dati:', error);
      }
    );
  }

  tooggleIncomplete(id: number) {
    this.todoSrv.toggleIncomplete(id);
  }
}
