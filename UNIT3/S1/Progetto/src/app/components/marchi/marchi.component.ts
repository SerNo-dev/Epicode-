import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
@Component({
  selector: 'app-marchi',
  templateUrl: './marchi.component.html',
  styleUrls: ['./marchi.component.scss']
})
export class MarchiComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((posts) => {
      this.posts = posts;
    });
  }

  async getPosts() {
    let response = await fetch('assets/db.json');
    let data = await response.json();
    return data;
  }
}
