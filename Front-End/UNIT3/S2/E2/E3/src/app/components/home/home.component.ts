import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  posts!: Post[];
  filteredPosts: any[] = [];
  constructor(private postSrv: PostService) {}
  
  ngOnInit() : void {
    const posts = this.postSrv.getPosts();
    this.posts = posts
    }

    getUniqueTags(): string[] {
    const uniqueTags = new Set<string>();
    this.posts.forEach(post => {
      post.tags.forEach(tag => uniqueTags.add(tag))
    });
    return Array.from(uniqueTags)
    }
   
   filterPostByTag(tag:string) {
    return this.posts.filter(post => post.tags.includes(tag))
   }

}
