import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-postdetail',
  templateUrl: './postdetail.component.html',
  styleUrls: ['./postdetail.component.scss']
})
export class PostdetailComponent {
      postId: number;
      post!: Post;
      constructor(private route: ActivatedRoute){
        this.postId = Number(this.route.snapshot.paramMap.get('id'));
        this.getPost().then((data)=>{
          this.post = data;
        });
      }

      async getPost() {
        const response = await fetch(`assets/db.json`);
        const data = await response.json();
        return data.find((post: Post) => post.id === this.postId);
      }
}
