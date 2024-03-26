import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';
@Component({
  selector: 'app-postinattivi',
  templateUrl: './postinattivi.component.html',
  styleUrls: ['./postinattivi.component.scss']
})
export class PostinattiviComponent {
  posts!: Post[];

  constructor(private postSrv: PostService) {}
  
  ngOnInit() : void {
    const posts = this.postSrv.getPosts();
    this.posts = posts
    }
}
