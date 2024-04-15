import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';
@Component({
  selector: 'app-mainarticle',
  templateUrl: './mainarticle.component.html',
  styleUrls: ['./mainarticle.component.scss']
})
export class MainarticleComponent {
  posts!: Post[];
  randomPosts: Post[] = [];

  constructor(private postSrv: PostService) {
    this.getPosts().then((posts) => {
      this.getRandomPosts();
    });
  }

  async getPosts() {
    const posts = this.postSrv.getPosts();
    this.posts = posts
  }

  getRandomPosts() {
    for (let i = 0; i < this.posts.length; i++) { 
      const randomIndex = Math.floor(Math.random() * this.posts.length);
      this.randomPosts.push(this.posts[randomIndex]);
    }
  }
}
