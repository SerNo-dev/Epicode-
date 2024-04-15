import { Component,Input } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
@Component({
  selector: 'app-listcars',
  templateUrl: './listcars.component.html',
  styleUrls: ['./listcars.component.scss']
})
export class ListcarsComponent {
  @Input('post') post!: Post;
}
