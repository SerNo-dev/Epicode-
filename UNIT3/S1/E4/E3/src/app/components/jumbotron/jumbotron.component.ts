import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
@Component({
  selector: 'app-jumbotron',
  templateUrl: './jumbotron.component.html',
  styleUrls: ['./jumbotron.component.scss']
})
export class JumbotronComponent {
   posts!: Post[];
   randomPost : Post | undefined;
   constructor(){
    this.getPosts().then((posts) =>{
      this.posts = posts;
      const randomIndex = Math.floor(Math.random()* this.posts.length);
      this.randomPost = this.posts[randomIndex]
    })
   }
   async getPosts(){
    let response = await fetch('assets/db.json');
    let data = response.json();
    return data
   }
}
