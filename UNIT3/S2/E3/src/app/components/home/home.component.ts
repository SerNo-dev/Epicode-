import { Component, OnInit} from '@angular/core';
import { Subscription } from 'rxjs';
import { Products } from 'src/app/models/products.interface';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  products: Products[] | undefined;
  sub: Subscription | undefined;



  constructor(private productsSrv: ProductsService) {}

  ngOnInit(): void {
    this.sub = this.productsSrv.getProducts().subscribe(
      (response) => {
        this.products = response;
        console.log(this.products);
      },
      (err) => {
        alert(err);
      }
    );
  }
   
add(product: Products): void {
  this.productsSrv.addFavorites(product);
}

 
}
