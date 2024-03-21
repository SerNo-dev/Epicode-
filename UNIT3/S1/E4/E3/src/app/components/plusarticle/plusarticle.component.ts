import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
@Component({
  selector: 'app-plusarticle',
  templateUrl: './plusarticle.component.html',
  styleUrls: ['./plusarticle.component.scss']
})
export class PlusarticleComponent {
  posts!: Post[];
  randomPosts: Post[] = [];

  constructor() {
    this.getPosts().then((posts) => {
      this.posts = posts;
      this.getRandomPosts();
    });
  }

  async getPosts() {
    let response = await fetch('assets/db.json');
    let data = await response.json();
    return data;
  }

  getRandomPosts() {
    for (let i = 0; i < this.posts.length; i++) { 
      const randomIndex = Math.floor(Math.random() * this.posts.length);
      this.randomPosts.push(this.posts[randomIndex]);
    }
  }
}
