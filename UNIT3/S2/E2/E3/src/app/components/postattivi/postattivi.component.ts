import { Component,OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';
@Component({
  selector: 'app-postattivi',
  templateUrl: './postattivi.component.html',
  styleUrls: ['./postattivi.component.scss']
})
export class PostattiviComponent implements OnInit {
  posts!: Post[];

  constructor(private postSrv: PostService) {}
  
  ngOnInit() : void {
    const posts = this.postSrv.getPosts();
    this.posts = posts
    }

}
